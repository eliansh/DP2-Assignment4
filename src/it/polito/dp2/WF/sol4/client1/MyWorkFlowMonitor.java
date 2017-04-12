package it.polito.dp2.WF.sol4.client1;

import it.polito.dp2.WF.sol4.client1.workflow.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.namespace.QName;

import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowMonitor;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowReader;

public class MyWorkFlowMonitor implements WorkflowMonitor {
	
	private HashMap<String, MyWorkFlowReader> workFlows = new HashMap<String, MyWorkFlowReader>();
	private HashSet<MyProcessReader> allProcess = new HashSet<MyProcessReader>();
	private WFReader proxy;
	//private static final String SCHEMA_FILE = "xsd" + File.separatorChar + "WFInfo.xsd";
	
	public MyWorkFlowMonitor() throws WorkflowMonitorException, MalformedURLException {
		URL url = null;
		QName qname = null;
		try{
		if(System.getProperty("it.polito.dp2.WF.lab4.URL")!=null)
			url = new URL(System.getProperty("it.polito.dp2.WF.lab4.URL"));	
		else
			url = new URL("http://localhost:7071/wfinfo");
		}catch (MalformedURLException e) {
			e.printStackTrace();
			System.err.println("Wrong url!");
		}catch (IllegalArgumentException iae){
			iae.printStackTrace();
		}	
		qname = new QName("http://www.example.org/Workflow/", "WFReader");	
		 WFReader_Service service = new WFReader_Service(url, qname);
		
		 proxy = service.getWFReaderSOAP();
		    
		 Parser  parser = new Parser(proxy, workFlows, allProcess);
		 parser.parse();
		 
		
	 }

	@Override
	public Set<ProcessReader> getProcesses() {
		return new HashSet<ProcessReader>(allProcess);
	}

	@Override
	public WorkflowReader getWorkflow(String name) {
		if(isNameValid(name)){
			return workFlows.get(name);
		}
		else
			return null;
	}

	@Override
	public Set<WorkflowReader> getWorkflows() {
		return new HashSet<WorkflowReader>(workFlows.values());
	}
	
	public static boolean isNameValid(String name) {
		String Regx = "[A-Za-z][A-Za-z0-9]*";
		return (name==null || name.matches(Regx));
	}
	private static String formatDate(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		dateFormat.setTimeZone(calendar.getTimeZone());
		return dateFormat.format(calendar.getTime());
	}

}

