package it.polito.dp2.WF.sol4.server;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.ProcessActionReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.SimpleActionReader;
import it.polito.dp2.WF.sol4.server.workflow.ActionStatusType;
import it.polito.dp2.WF.sol4.server.workflow.ActionType;
import it.polito.dp2.WF.sol4.server.workflow.ActorType;
import it.polito.dp2.WF.sol4.server.workflow.ObjectFactory;
import it.polito.dp2.WF.sol4.server.workflow.ProcessActType;
import it.polito.dp2.WF.sol4.server.workflow.ProcessType;
import it.polito.dp2.WF.sol4.server.workflow.ServerErrorFault_Exception;
import it.polito.dp2.WF.sol4.server.workflow.SimpleActType;
import it.polito.dp2.WF.sol4.server.workflow.WFReader;
import it.polito.dp2.WF.sol4.server.workflow.WorkflowType;
import it.polito.dp2.WF.sol4.server.workflow.WrongArgumentFault;

@WebService( name="WFReader",
			endpointInterface="it.polito.dp2.WF.sol4.server.workflow.WFReader",
			wsdlLocation="META-INF/Workflow.wsdl",
			portName="WFReaderSOAP",
			serviceName="WFReader",
			targetNamespace = "http://www.example.org/Workflow/")
@XmlSeeAlso({
    ObjectFactory.class
})
//@HandlerChain(file = "META-INF/WorkflowHandlerClient1.xml")

public class MyWorkflowInfo implements WFReader{
private static Logger logger = Logger.getLogger(MyWorkflowControl.class.getName());
	

	 @WebMethod(action = "http://www.example.org/WFReader/getProcess")
	    @WebResult(name = "process", targetNamespace = "http://www.example.org/Workflow/")
	    @RequestWrapper(localName = "getProcess", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetProcess")
	    @ResponseWrapper(localName = "getProcessResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetProcessResponse")

	@Override
	public ProcessType getProcess(
			@WebParam(name = "flowName", targetNamespace = "")
			String flowName,
			@WebParam(name = "startTime", targetNamespace = "")
			XMLGregorianCalendar startTime)
			throws ServerErrorFault_Exception, WrongArgumentFault {
		 logger.entering(logger.getName(), "getProcess");
			

	    	ConcurrentHashMap<String, MyProcessReader> myProcesses=null;
			try {
				myProcesses = WorkflowManager.getInstance().getProcesses();
				//myProcesses = manager.getProcesses();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	if (myProcesses == null) {
	    		logger.severe("Cannot get information about processes");
	    		ServerErrorFault_Exception e = new ServerErrorFault_Exception("Cannot get information about processes", null);
	    		logger.throwing(logger.getName(), "getProcess", e);
	    		throw e;
	    	}
	    	MyProcessReader myProcess = myProcesses.get(startTime);
			if (myProcess == null) {
				logger.warning("Process " + formatDate(startTime.toGregorianCalendar()) + " not found");
				WrongArgumentFault e = new WrongArgumentFault("Invalid argument", "startTime");
				logger.throwing(logger.getName(), "getProcess", e);
				throw e;
			}
			ProcessType processType = new ProcessType();

			try {
				processType.setStartTime(convertDate(myProcess.getStartTime()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(ActionStatusReader as: myProcess.getStatus()){
				ActionStatusType statusType = new ActionStatusType();
				statusType.setActionStatName(as.getActionName());
				statusType.setTakenInCharge(as.isTakenInCharge());
				try {
					statusType.setTerminationTime(convertDate(as.getTerminationTime()));
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 statusType.setTerminated(as.isTerminated());
				 
				 ActorType actor = new ActorType();
				 actor.setActorName(as.getActor().getName());
				 actor.setActorRole(as.getActor().getRole());
				 
				 statusType.setActor(actor);
				 processType.getActionStatus().add(statusType);
			}
			logger.info("Getting information about process " + formatDate(startTime.toGregorianCalendar()));
				
			logger.info("Information about process " + formatDate(startTime.toGregorianCalendar()) + " got successfully");
			
			logger.exiting(logger.getName(), "getProcess");
			return processType;
	}

	@WebMethod(action = "http://www.example.org/WFReader/getWorkFlow")
    @WebResult(name = "workflow", targetNamespace = "http://www.example.org/Workflow/")
    @RequestWrapper(localName = "getWorkFlow", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetWorkFlow")
    @ResponseWrapper(localName = "getWorkFlowResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetWorkFlowResponse")
 
	@Override
	public WorkflowType getWorkFlow(
			@WebParam(name = "flowName", targetNamespace = "")
					String flowName) throws ServerErrorFault_Exception, WrongArgumentFault {
		logger.entering(logger.getName(), "getWorkFlow");
    	
    	ConcurrentHashMap<String, MyWorkFlowReader> myWorkflows = WorkflowManager.getInstance().getWorkflows();
    	if (myWorkflows == null) {
    		logger.severe("Cannot get information about workflows");
    		ServerErrorFault_Exception e = new ServerErrorFault_Exception("Cannot get information about workflows", null);
    		logger.throwing(logger.getName(), "getWorkFlow", e);
    		throw e;
    	}
    	
    	MyWorkFlowReader myWorkflow = myWorkflows.get(flowName);
		if (myWorkflow == null) {
			logger.warning("Workflow " + flowName + " not found");
			WrongArgumentFault e = new WrongArgumentFault("Invalid argument", "flowName");
			logger.throwing(logger.getName(), "getWorkFlow", e);
			throw e;
		}
		WorkflowType flowType = new WorkflowType();
		flowType.setFlowName(flowName);
		for(ProcessReader p: myWorkflow.getProcesses()){
			ProcessType processType = new ProcessType();

			try {
				processType.setStartTime(convertDate(p.getStartTime()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(ActionStatusReader as: p.getStatus()){
				ActionStatusType statusType = new ActionStatusType();
				statusType.setActionStatName(as.getActionName());
				
				statusType.setTerminated(as.isTerminated());
				if(as.isTerminated()){
				try {
					System.out.println("******getTerminationTime****"+formatDate(as.getTerminationTime()));
					statusType.setTerminationTime(convertDate(as.getTerminationTime()));
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				statusType.setTakenInCharge(as.isTakenInCharge());
				 ActorType actor = new ActorType();
				if(as.isTakenInCharge()){
				
				 actor.setActorName(as.getActor().getName());
				 actor.setActorRole(as.getActor().getRole());
				}
				 statusType.setActor(actor);
				 processType.getActionStatus().add(statusType);
			}
			
			flowType.getProcess().add(processType);
			
		}
		
		for(ActionReader ar: myWorkflow.getActions()){
			ActionType actionType = new ActionType();
			actionType.setActionName(ar.getName());
			actionType.setActionRole(ar.getRole());
			actionType.setAutomaticallyInstantiated(ar.isAutomaticallyInstantiated());
			
			if(ar instanceof ProcessActionReader){
				ProcessActType pact = new ProcessActType();
				pact.setRelatedWorkFlow(((ProcessActionReader) ar).getActionWorkflow().getName());
			}else if(ar instanceof SimpleActionReader){
				SimpleActType sact = new SimpleActType();
				for(ActionReader ac:((SimpleActionReader) ar).getPossibleNextActions()){
					sact.getNextAction().add(ac.getName());
				}
			}
			flowType.getAction().add(actionType);
		}

		logger.info("Getting information about workflow " + flowName);
		
		logger.info("Information about workflow " + flowName + " got successfully");
		
		logger.exiting(logger.getName(), "getWorkflow");
		return flowType;
	}
	
	
	
		    @WebMethod(action = "http://www.example.org/WFReader/getWorkFlows")
		    @WebResult(name = "flowName", targetNamespace = "http://www.example.org/Workflow/")
		    @RequestWrapper(localName = "getWorkFlows", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetWorkFlows")
		    @ResponseWrapper(localName = "getWorkFlowsResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetWorkFlowsResponse")
		   
			@Override
			public List<String> getWorkFlows() throws ServerErrorFault_Exception {
				logger.entering(logger.getName(), "getWorkFlows");
		    	ConcurrentHashMap<String, MyWorkFlowReader> myWorkflows = WorkflowManager.getInstance().getWorkflows();

//		    	for(String s: myWorkflows.keySet()){
//		    		System.out.println("*********myWorkflows"+ s);
//		    	}
		    	List<String> reply = new ArrayList<String>();
		    	if (myWorkflows == null) {
		    		logger.severe("Cannot get information about workflows");
		    		ServerErrorFault_Exception e = new ServerErrorFault_Exception("Cannot get information about workflows", null);
		    		logger.throwing(logger.getName(), "getWorkFlows", e);
		    		throw e;
		    	}
		    	
		    	for(MyWorkFlowReader workFlow:myWorkflows.values() ){
		    		reply.add(workFlow.getName());
		    	}
		    	logger.info("Returning " + reply.size() + " of " + myWorkflows.size() + " workflows...");
		    	
		    	logger.exiting(logger.getName(), "getWorkFlows");
				return reply;
				
			}
		    @WebMethod(action = "http://www.example.org/WFReader/getProcesses")
		    @WebResult(name = "startTime", targetNamespace = "http://www.example.org/Workflow/")
		    @RequestWrapper(localName = "getProcesses", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetProcesses")
		    @ResponseWrapper(localName = "getProcessesResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.GetProcessesResponse")
		  
			@Override
			public List<XMLGregorianCalendar> getProcesses( 
					@WebParam(name = "flowName", targetNamespace = "")
					String flowName)
					throws ServerErrorFault_Exception, WrongArgumentFault {
		    	//WorkflowManager manager = new WorkflowManager();
				logger.entering(logger.getName(), "getProcesses");
				LinkedList<XMLGregorianCalendar> reply = new LinkedList<XMLGregorianCalendar>();

				if(flowName==null){	//return all the processes 
					ConcurrentHashMap<String, MyProcessReader> myAllProcesses=null;
					try {
						
						myAllProcesses = WorkflowManager.getInstance().getProcesses();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					 Collection<MyProcessReader> allProcessesSubList = myAllProcesses.values();
					for (ProcessReader process : allProcessesSubList) {
						XMLGregorianCalendar convertedDate = null;
						try {
							convertedDate = convertDate(process.getStartTime());
						} catch (DatatypeConfigurationException ex) {
							logger.severe("Invalid process: invalid start time");
							ServerErrorFault_Exception e = new ServerErrorFault_Exception("Invalid process: invalid start time", null);
							logger.throwing(logger.getName(), "getProcesses", e);
							throw e;
						}
						logger.fine("Adding start time " + formatDate(convertedDate.toGregorianCalendar()));
						reply.add(convertedDate);
					}
				
				
				}else{
			    	ConcurrentHashMap<String, MyWorkFlowReader> myWorkflows = WorkflowManager.getInstance().getWorkflows();
			    	if (myWorkflows == null) {
			    		logger.severe("Cannot get information about workflows");
			    		ServerErrorFault_Exception e = new ServerErrorFault_Exception("Cannot get information about workflows", null);
			    		logger.throwing(logger.getName(), "getProcesses", e);
			    		throw e;
			    	}
			    	
					if (!myWorkflows.containsKey(flowName)) { // Assumption: No insertion/deletion operations -> no need for synchronization.
						logger.warning("Workflow " + flowName + " not found");
						WrongArgumentFault e = new WrongArgumentFault("Invalid argument", "flowName");
						logger.throwing(logger.getName(), "getProcesses", e);
						throw e;
					}
					Set<ProcessReader> processes = myWorkflows.get(flowName).getProcesses();
					
					//List<ProcessReader> processesSubList = getInPages(processes, pageNumber, pageSize);

					for (ProcessReader process : processes) {
						XMLGregorianCalendar convertedDate = null;
						try {
							convertedDate = convertDate(process.getStartTime());
						} catch (DatatypeConfigurationException ex) {
							logger.severe("Invalid process: invalid start time");
							ServerErrorFault_Exception e = new ServerErrorFault_Exception("Invalid process: invalid start time", null);
							logger.throwing(logger.getName(), "getProcesses", e);
							throw e;
						}
						logger.fine("Adding start time " + formatDate(convertedDate.toGregorianCalendar()));
						reply.add(convertedDate);
					}

			    	logger.info("Returning " + reply.size() + " of " + processes.size() + " processes");
			    	
					logger.exiting(logger.getName(), "getProcesses");
					
				}
				return reply;
			}


//
//		 	private static <E> List<E> getInPages(Collection<E> set, BigInteger pageNumber, BigInteger pageSize) {
//		    	logger.entering(logger.getName(), "getInPages");
//		    	List<E> reply = getInPages(new LinkedList<E>(set), pageNumber, pageSize);
//		    	logger.exiting(logger.getName(), "getInPages");
//		    	return reply;
//		    }
//		    
//		    private static <E> List<E> getInPages(List<E> list, BigInteger pageNumber, BigInteger pageSize) {
//		    	logger.entering(logger.getName(), "getInPages");
//				int startIndex = pageSize.intValue() * (pageNumber.intValue() - 1);
//				if (startIndex > list.size() - 1)
//					return new LinkedList<E>();
//				
//				int endIndex = Math.max(list.size(), pageSize.intValue() * pageNumber.intValue());
//				
//				logger.fine("Getting sub list from index " + startIndex + " to index " + endIndex + "...");
//				List<E> reply = list.subList(startIndex, endIndex);
//				logger.fine("Sub list got successfully");
//				
//				logger.exiting(logger.getName(), "getInPages");
//				return reply;
//	}
		    private static String formatDate(Calendar calendar) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
				dateFormat.setTimeZone(calendar.getTimeZone());
				return dateFormat.format(calendar.getTime());
			}

//		    private static XMLGregorianCalendar convertDate(Calendar date) throws DatatypeConfigurationException {
//		    	logger.entering(logger.getName(), "convertDate");
//		    	XMLGregorianCalendar reply = null;
//		    	GregorianCalendar c=new GregorianCalendar();
//				c.setTime(date.getTime());
//		    	try {
//		    		reply = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//		    	} catch (DatatypeConfigurationException e) {
//		    		logger.severe("Cannot convert the calendar");
//		    		logger.throwing(logger.getName(), "convertDate", e);
//		    		throw e;
//		    	}
//				logger.exiting(logger.getName(), "convertDate");
//				return reply;
//		    }
		    
		    
		    public static XMLGregorianCalendar convertDate(Calendar c)
		    		  throws DatatypeConfigurationException {
		    		 GregorianCalendar gc = new GregorianCalendar();
		    		 gc.setTimeInMillis(c.getTimeInMillis());
		    		 XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		    		 return xc;
		    		}
		
}
