package it.polito.dp2.WF.sol4.server;

import it.polito.dp2.WF.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class WorkflowManager {

	    private static Logger logger = Logger.getLogger(WorkflowManager.class.getName());
	    
		private volatile ConcurrentHashMap<String,MyProcessReader> myProcesses = null;
		
	//	private volatile ConcurrentHashMap<String,ConcurrentHashMap<String, MyActionReader>> myActions = null;


		// I use ConcurrentHashMap instead of ConcurrentHashMap for paged responses.
		private volatile ConcurrentHashMap<String, MyWorkFlowReader> myWorkflows = null;
		
		// Assumption: Only the getworkflowMonitorInstance() method calls the (public) constructor.
		private volatile WorkflowMonitor workflowMonitorInstance = null;
		
	    private static class WorkflowManagerHolder {
	        private final static WorkflowManager INSTANCE = new WorkflowManager();
	    }

	    public static WorkflowManager getInstance() {
	        return WorkflowManagerHolder.INSTANCE;
	    }

	    private WorkflowManager() {
	        logger.fine("WorkflowManager instance created successfully");
	    }

		public ConcurrentHashMap<String, MyWorkFlowReader> getWorkflows() {
	    	logger.entering(logger.getName(), "getWorkflows");
	    	ConcurrentHashMap<String, MyWorkFlowReader> result = myWorkflows;
	        if (result == null) { // First check (no locking)
	            synchronized (this) {
	                result = myWorkflows;
	                if (result == null)
						try {
							
							myWorkflows=result=createWorkflows();
						} catch (Exception e) {
							result = null;
						}
	            }
	        }
	        logger.exiting(logger.getName(), "getWorkflows");
	        return result;
	    }

		public ConcurrentHashMap<String,MyProcessReader>getProcesses() {
	    	logger.entering(logger.getName(), "getProcesses");
	    	ConcurrentHashMap<String,MyProcessReader> result = myProcesses;
	        if (result == null) { // First check (no locking)
	            synchronized (this) {
	                result = myProcesses;
	                if (result == null)
						try {
							myProcesses = result = createProcesses();
						} catch (WorkflowMonitorException e) {
							result = null;
						}
	            }
	        }
	        logger.exiting(logger.getName(), "getProcesses");
	        return result;
	    }
		
//		public ConcurrentHashMap<String,ConcurrentHashMap<String, MyActionReader>>getActionsOfWorkflow() {
//	    	logger.entering(logger.getName(), "getActions");
//	    	ConcurrentHashMap<String,ConcurrentHashMap<String, MyActionReader>> result = myActions;
//	        if (result == null) { // First check (no locking)
//	            synchronized (this) {
//	                result = myActions;
//	                if (result == null)
//						
//							//createWorkflows();
//							result = myActions;
//						
//	            }
//	        }
//	        logger.exiting(logger.getName(), "getProcesses");
//	        return result;
//	    }
//	    
		private ConcurrentHashMap<String, MyProcessReader> createProcesses() throws WorkflowMonitorException {
			logger.entering(logger.getName(), "createProcesses");
			WorkflowMonitor monitor = getWorkflowMonitorInstance();
			
			ConcurrentHashMap<String,MyProcessReader> processes = new ConcurrentHashMap<String,MyProcessReader>();
			 Set<ProcessReader> monitorProcesses = monitor.getProcesses();
				for(ProcessReader monitorProcess:monitorProcesses){
					ArrayList<MyActionStatusReader> myActionStatuses= new ArrayList<MyActionStatusReader>();
					List<ActionStatusReader> monitorActionStatuses = monitorProcess.getStatus();
					for(ActionStatusReader asr:monitorActionStatuses){
						Calendar terminationTime = null;
						
						
//						ActionReader temp = new ActionReader(workFlow, myWorkFlowReader, actionName, actionRole, isAutomatic);
//						temp.isAutomaticallyInstantiated()
						
					
						if(asr.isTerminated()){
							terminationTime = asr.getTerminationTime();
						}
						Actor actor = null;
						if(asr.isTakenInCharge()){
							actor = asr.getActor();
						}
						
						MyActionStatusReader myActionStatus = new MyActionStatusReader(asr.getActionName(), actor, terminationTime, asr.isTakenInCharge(), asr.isTerminated());
						myActionStatuses.add(myActionStatus);	
					}
					MyProcessReader myProcess = new MyProcessReader(monitorProcess.getStartTime(), myActionStatuses, getWorkflows().get(monitorProcess.getWorkflow().getName()));
					processes.put(formatDate(myProcess.getStartTime()), myProcess);
				}
				//myProcesses.putAll(processes);
				logger.exiting(logger.getName(), "createProcesses");
				logger.info("Initial data about Processes populated successfully");
				return processes;
		}
		
		
		
	    private ConcurrentHashMap<String, MyWorkFlowReader> createWorkflows() throws Exception {
	    	logger.entering(logger.getName(), "createWorkflows");
	    	WorkflowMonitor monitor = getWorkflowMonitorInstance();
	    	
	    	ConcurrentHashMap<String, MyWorkFlowReader> myWorkflows = new ConcurrentHashMap<String, MyWorkFlowReader>();
			
			Set<WorkflowReader> workflows = monitor.getWorkflows();
	    	
			for (WorkflowReader workflow : workflows) {
				ConcurrentHashMap<String, MyActionReader> actions = new ConcurrentHashMap<String, MyActionReader>();
				ConcurrentHashMap<String,MyProcessReader> processes = new ConcurrentHashMap<String,MyProcessReader>();
			
				MyWorkFlowReader myWorkflow = new MyWorkFlowReader(actions, workflow.getName(), processes);
				
				Set<ActionReader> monitorAtions=workflow.getActions();
				for(ActionReader monitorAction:monitorAtions){
					MyActionReader myAction = new MyActionReader(myWorkflow, monitorAction.getName(), monitorAction.getRole(), monitorAction.isAutomaticallyInstantiated());
					if(monitorAction instanceof SimpleActionReader){
						HashSet<MyActionReader> nextPossibleActions = new HashSet<MyActionReader>();

						Set<ActionReader> nextActions = ((SimpleActionReader) monitorAction).getPossibleNextActions();
						for(ActionReader a:nextActions){

							MyActionReader nextPossible = new MyActionReader(myWorkflow, a.getName(), a.getRole(), a.isAutomaticallyInstantiated());

							nextPossibleActions.add(nextPossible);
						}
						myAction = new MySimpleActionReader(myWorkflow, monitorAction.getName(), monitorAction.getRole(), monitorAction.isAutomaticallyInstantiated(),nextPossibleActions);

					}else if (monitorAction instanceof ProcessActionReader){
						WorkflowReader relatedWorkflow = ((ProcessActionReader) monitorAction).getActionWorkflow();
						MyWorkFlowReader work = null;
						for(MyWorkFlowReader wf:myWorkflows.values()){
							if(relatedWorkflow.getName().equals(wf.getName()))
								work=wf;
						}
						myAction = new MyProcessActionReader(work,myWorkflow,monitorAction.getName(), monitorAction.getRole(), monitorAction.isAutomaticallyInstantiated());
					}
				
				actions.put(myAction.getName(), myAction);
				
				}
			//	myActions.put(myWorkflow.getName(), actions);
				 Set<ProcessReader> monitorProcesses = workflow.getProcesses();
				for(ProcessReader monitorProcess:monitorProcesses){
					ArrayList<MyActionStatusReader> myActionStatuses= new ArrayList<MyActionStatusReader>();
					List<ActionStatusReader> monitorActionStatuses = monitorProcess.getStatus();
					for(ActionStatusReader asr:monitorActionStatuses){
						Calendar terminationTime = null; 
						if(asr.isTerminated()){
							terminationTime = asr.getTerminationTime();
						}
						Actor actor = null;
						if(asr.isTakenInCharge()){
							actor = asr.getActor();
						}
						
						MyActionStatusReader myActionStatus = new MyActionStatusReader(asr.getActionName(), actor, terminationTime, asr.isTakenInCharge(), asr.isTerminated());
						myActionStatuses.add(myActionStatus);	
					}
					MyProcessReader myProcess = new MyProcessReader(monitorProcess.getStartTime(), myActionStatuses, myWorkflow);
					processes.put(myProcess.getStartTime().toString(), myProcess);
				}
				
				//createProcesses(workflow,myWorkflow);
				//myProcesses.putAll(processes);
				//MyWorkFlowReader wf = new MyWorkFlowReader(actions, myWorkflow.getName(), processes);
				
				myWorkflows.put(myWorkflow.getName(), myWorkflow);
			}
			
			logger.exiting(logger.getName(), "createWorkflows");
			logger.info("Initial data about workflows populated successfully");
			return myWorkflows;
	    }
		
		private static String formatDate(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		dateFormat.setTimeZone(calendar.getTimeZone());
		return dateFormat.format(calendar.getTime());
	}
		
	    
	    private WorkflowMonitor getWorkflowMonitorInstance() throws WorkflowMonitorException {
	    	logger.entering(logger.getName(), "getWorkflowMonitorInstance");
	    	WorkflowMonitor result = workflowMonitorInstance;
	    	if (result == null) {
	    		synchronized (this) {
	    			result = workflowMonitorInstance;
	    			if (result == null)
						try {
							workflowMonitorInstance = result = WorkflowMonitorFactory.newInstance().newWorkflowMonitor();
						} catch (WorkflowMonitorException | FactoryConfigurationError e) {
							logger.severe("Cannot create workflow monitor instance");
							logger.throwing(logger.getName(), "getWorkflowMonitorInstance", e);
							throw e;
						}
	    		}
	    	}
	    	logger.exiting(logger.getName(), "getWorkflowMonitorInstance");
	    	return result;
	    }
	
}
