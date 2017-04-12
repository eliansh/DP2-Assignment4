package it.polito.dp2.WF.sol4.client1;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;

import it.polito.dp2.WF.sol4.client1.workflow.*;
import it.polito.dp2.WF.*;
public class Parser {
	//private String customizedURL;
	private WFReader proxy;
	private HashMap<String, MyWorkFlowReader> workFlows = new HashMap<String, MyWorkFlowReader>();
	private HashSet<MyProcessReader> allProcess = new HashSet<MyProcessReader>();
	//private Holder<List<String>> name = new Holder<List<String>>();
	//private Holder<XMLGregorianCalendar> lastModTime = new Holder<XMLGregorianCalendar>();
	//private Holder<List<Workflow>> workflow = new Holder<List<Workflow>>();
	
	public Parser(WFReader proxy, HashMap<String, MyWorkFlowReader> workFlows, HashSet<MyProcessReader> allProcess){
		//this.customizedURL = customizedURL;
		this.proxy = proxy;
		this.workFlows = workFlows;
		this.allProcess = allProcess;

	}
	
	public void parse() throws WorkflowMonitorException{
		
		
		//BigInteger pageNumber = null;
		//BigInteger pageSize = null;
		List<String> flowNames = null;
		try {
			flowNames = proxy.getWorkFlows();
		} catch (ServerErrorFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(String name:flowNames){
//			System.out.println("******WorkFlowNAme*****"+name);
//		}
		for(String name: flowNames){
			
				WorkflowType workflow = null;
				try {
					workflow = proxy.getWorkFlow(name);
				} catch (ServerErrorFault_Exception | WrongArgumentFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				parseWorkFlowNode(workflow);	
				
				System.out.println("(((((((((Number of Processes in client1 is :))))) "+allProcess.size());
		}
		}
//		for(String name: flowNames){
//			try {
//				List<XMLGregorianCalendar> startTimes = proxy.getProcesses(name);
//				for(XMLGregorianCalendar startTime:startTimes){
//					ProcessType process = proxy.getProcess(name, startTime);
//				}
//				
//			} catch (ServerErrorFault_Exception | WrongArgumentFault e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
			
	//}

	private void parseWorkFlowNode(WorkflowType workFlowNode) throws WorkflowMonitorException{
		String flowName = workFlowNode.getFlowName();
		
		
		HashMap<String, MyActionReader> actions = new HashMap<String, MyActionReader>();
		HashSet<MyProcessReader> processes = new HashSet<MyProcessReader>();
		MyWorkFlowReader wfs = new MyWorkFlowReader(actions, flowName, processes);
		List<ActionType> ac = workFlowNode.getAction();
		//ActionsType actionsNode = workFlowNode.getActions();
		for(ActionType actionNode : ac){
			String actionName = actionNode.getActionName();
			if(!MyActionReader.isNameValid(actionName))
				throw new WorkflowMonitorException("action name is not correct");

			String actionRole =actionNode.getActionRole();
			if(!MyActionReader.isRoleValid(actionRole))
				throw new WorkflowMonitorException("action role is not correct");
			boolean automaticallyInstantiated = actionNode.isAutomaticallyInstantiated();
			MyActionReader action = new MyActionReader(wfs, actionName, actionRole, automaticallyInstantiated);
			if(actionNode.getSimpleAct()!=null){
				SimpleActType simpleActNode = actionNode.getSimpleAct();
					HashSet<MyActionReader> nextActions = new HashSet<MyActionReader>();
					for(String s: simpleActNode.getNextAction()){
						for(MyActionReader a:actions.values()){
							if(a.getName().equals(s))
								nextActions.add(a);
						}						
					}
					action = new MySimpleActionReader(wfs, actionName, actionRole, automaticallyInstantiated, nextActions);
						
						}else if(actionNode.getProcessAct()!=null) {
							ProcessActType processActNode = actionNode.getProcessAct();
							String relatedWorkFlow = processActNode.getRelatedWorkFlow();
							MyWorkFlowReader work = null;
							for(MyWorkFlowReader wf:workFlows.values()){
								if(relatedWorkFlow.equals(wf.getName())){
									work = wf;
								}
								}
								action = new MyProcessActionReader(work,wfs, actionName, actionRole, automaticallyInstantiated);
							}
					actions.put(actionName, action);
		}
		Calendar startTime = null;
		for(ProcessType processNode:workFlowNode.getProcess()){
			startTime = processNode.getStartTime().toGregorianCalendar();
			ArrayList<MyActionStatusReader> actionStatuses= new ArrayList<MyActionStatusReader>();
			for(ActionStatusType actionStatusNode:processNode.getActionStatus()){
				String actionStatName = actionStatusNode.getActionStatName();	
				boolean terminated = actionStatusNode.isTerminated();
				Calendar terminationTime = null;
				if(terminated)
					terminationTime = actionStatusNode.getTerminationTime().toGregorianCalendar();
				boolean takenInCharge = actionStatusNode.isTakenInCharge();
				Actor actor = null;
				if(takenInCharge){
					ActorType actorNode = actionStatusNode.getActor();
					if(actorNode!=null){
					String actorName = actorNode.getActorName();
					String actorRole = actorNode.getActorRole();
					actor = new Actor(actorName, actorRole);
					}
				}
				
				MyActionStatusReader actionStatus = new MyActionStatusReader(actionStatName, actor, terminationTime, takenInCharge, terminated);
				actionStatuses.add(actionStatus);
			}
			
			MyProcessReader process = new MyProcessReader(startTime,actionStatuses, wfs);
			processes.add(process);
			}	
		allProcess.addAll(processes);
		MyWorkFlowReader wf = new MyWorkFlowReader(actions, flowName, processes);
		workFlows.put(flowName, wf);
	}
	

			private static Calendar parseDate(String string) throws ParseException {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
				Calendar cal  = Calendar.getInstance();
				dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
				cal.setTime(dateFormat.parse(string));
				return cal;
			}
			
			private static String formatDate(Calendar calendar) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
				dateFormat.setTimeZone(calendar.getTimeZone());
				return dateFormat.format(calendar.getTime());
			}
			
}


