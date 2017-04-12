package it.polito.dp2.WF.sol4.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.Actor;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.sol4.server.workflow.ActionStatusType;
import it.polito.dp2.WF.sol4.server.workflow.ActionType;
import it.polito.dp2.WF.sol4.server.workflow.ObjectFactory;
import it.polito.dp2.WF.sol4.server.workflow.ProcessType;
import it.polito.dp2.WF.sol4.server.workflow.ServerErrorFault_Exception;
import it.polito.dp2.WF.sol4.server.workflow.WFProcessCreator;
import it.polito.dp2.WF.sol4.server.workflow.WorkflowType;
import it.polito.dp2.WF.sol4.server.workflow.WrongArgumentFault;
import it.polito.dp2.WF.sol4.server.workflow.WrongStartTimeFault_Exception;
import it.polito.dp2.WF.sol4.server.workflow.WrongWorkFlowFault;

@WebService( name="WFProcessCreator",
			endpointInterface="it.polito.dp2.WF.sol4.server.workflow.WFProcessCreator",
			wsdlLocation="META-INF/Workflow.wsdl",
			portName="WFProcessCreatorSOAP",
			serviceName="WFProcessCreator",
			targetNamespace = "http://www.example.org/Workflow/")
@XmlSeeAlso({
    ObjectFactory.class
})
//@HandlerChain(file = "META-INF/WorkflowHandlerClient2.xml")

public class MyWorkflowControl implements WFProcessCreator{
	
	private static Logger logger = Logger.getLogger(MyWorkflowControl.class.getName());
	//private ConcurrentHashMap<String, MyActionReader> actions;
	//private ConcurrentHashMap<String, MyProcessReader> processes;
	
	 @WebMethod(action = "http://www.example.org/WFProcessCreator/createProcess")
	 @RequestWrapper(localName = "createProcess", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.CreateProcess")
	 @ResponseWrapper(localName = "createProcessResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.CreateProcessResponse")
	   
	@Override
	public void createProcess (
			@WebParam(name = "flowName", targetNamespace = "")
			String flowName) 
			throws ServerErrorFault_Exception, WrongArgumentFault,
			WrongStartTimeFault_Exception, WrongWorkFlowFault {
		logger.entering(logger.getName(), "createProcess");

		ConcurrentHashMap<String, MyWorkFlowReader> myWorkflows = WorkflowManager.getInstance().getWorkflows();
    	if (myWorkflows == null) {
    		logger.severe("Cannot get information about workflows");
    		ServerErrorFault_Exception e = new ServerErrorFault_Exception("Cannot get information about workflows", null);
    		logger.throwing(logger.getName(), "createProcess", e);
    		throw e;
    	}
    	
    	MyWorkFlowReader myWorkflow = myWorkflows.get(flowName);
		if (myWorkflow == null) {
			logger.warning("Workflow " + flowName + " not found");
			WrongArgumentFault e = new WrongArgumentFault("Invalid argument", "flowName");
			logger.throwing(logger.getName(), "createProcess", e);
			throw e;
		}
		
		ConcurrentHashMap<String, MyProcessReader> myProcesses=null;
		try {
			myProcesses = WorkflowManager.getInstance().getProcesses();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    	//String st = getCurrentDate();
    	String st = getCurrentDate();
    	MyProcessReader myProcess = myProcesses.get(st);
    	
    	if (myProcess != null) {
			logger.warning("Process " + st + " is already exists!");
			WrongArgumentFault e = new WrongArgumentFault("Invalid argument", "startTime");
			logger.throwing(logger.getName(), "createProcess", e);
			throw e;
		}

    	try {
			ArrayList<MyActionStatusReader> statusReader = new ArrayList<MyActionStatusReader>();
	            for (ActionReader ar : myWorkflow.getActions()) {
	                if (ar.isAutomaticallyInstantiated()) continue;
	                
					statusReader.add(new MyActionStatusReader(ar.getName(), new Actor(null, null), parseDate(st), false, false));
					
					
	            
	        }
	            System.out.println("((((((Numebr of Action status Readers are:)))))) "+statusReader.size());
			
			MyProcessReader created=new MyProcessReader(parseDate(st), statusReader, myWorkflow);
			
			myWorkflow.addProcess(created);
			//myWorkflow.getProcesses().add(created);
//			try {
//				WorkflowManager.getInstance().createWorkflows(myWorkflow, created);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				WorkflowManager.getInstance().addProcess(myWorkflow,created);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			myWorkflows.put(flowName, myWorkflow);
			myProcesses.put(st, created);
			
//			ProcessType newp = new ProcessType();
//			try {
//				newp.setStartTime(getXMLGregorianCalendarNow());
//			} catch (DatatypeConfigurationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			WorkflowType pt = new WorkflowType();
//			List<ActionType> actions = new ArrayList<ActionType>();
//			actions = pt.getAction();
//			for(ActionType a : actions){
//				if(!a.isAutomaticallyInstantiated()){
//					ActionStatusType newsts = new ActionStatusType();
//					newsts.setActionStatName(a.getActionName());
//					newsts.setTakenInCharge(false);
//					newp.getActionStatus().add(newsts);
//				}
//			}
//			synchronized (this){
//				this.workflowss.get(wfname).getProcess().add(newp);
//				this.allprocessess.get(wfname).addAll(this.workflowss.get(wfname).getProcess());
//			}

		} catch (WorkflowMonitorException | ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
    	
		logger.info("Process created successfully");
		
		logger.exiting(logger.getName(), "createProcess");
	}
	
	private static String formatDate(GregorianCalendar calendar) {
		logger.entering(logger.getName(), "formatDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		dateFormat.setTimeZone(calendar.getTimeZone());
		String reply = dateFormat.format(calendar.getTime());
		logger.exiting(logger.getName(), "formatDate");
		return reply;
	}
	
//		private static String formatDate(Calendar calendar) {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
//			dateFormat.setTimeZone(calendar.getTimeZone());
//			return dateFormat.format(calendar.getTime());
//		}

	    private static XMLGregorianCalendar convertDate(Calendar date) throws DatatypeConfigurationException {
	    	logger.entering(logger.getName(), "convertDate");
	    	XMLGregorianCalendar reply = null;
	    	GregorianCalendar c=new GregorianCalendar();
			c.setTime(date.getTime());
	    	try {
	    		reply = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
	    	} catch (DatatypeConfigurationException e) {
	    		logger.severe("Cannot convert the calendar");
	    		logger.throwing(logger.getName(), "convertDate", e);
	    		throw e;
	    	}
			logger.exiting(logger.getName(), "convertDate");
			return reply;
	    }
	    
	   
	    private static String getCurrentDate() {

	    	
	    	
	    		   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
	    		   //get current date time with Date()
	    		   Date date = new Date();
	    		   return(dateFormat.format(date));

	    	  }
	    private static Calendar parseDate(String string) throws ParseException {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
			Calendar cal  = Calendar.getInstance();
			dateFormat.setTimeZone(TimeZone.getTimeZone("CEST"));
			cal.setTime(dateFormat.parse(string));
			return cal;
		}
	    public XMLGregorianCalendar getXMLGregorianCalendarNow() 
	            throws DatatypeConfigurationException
	    {
	        GregorianCalendar gregorianCalendar = new GregorianCalendar();
	        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
	        XMLGregorianCalendar now = 
	            datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
	        return now;
	    }
			
}
