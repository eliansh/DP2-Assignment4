package it.polito.dp2.WF.sol4.server;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowReader;

public class MyWorkFlowReader implements WorkflowReader{

	//private MyActionReader action;
	private String name;
	//private ConcurrentHashMap<String,MyActionReader> actions;
	//private ConcurrentHashMap<String,MyProcessReader> processes;
	// I use ConcurrentHashMap instead of ConcurrentHashMap for paged responses.
		private ConcurrentHashMap<String, MyActionReader> actions = new ConcurrentHashMap<String, MyActionReader>();
	// I use ConcurrentHashMap instead of ConcurrentHashMap for paged responses.
		private ConcurrentHashMap<String, MyProcessReader> processes = new ConcurrentHashMap<String, MyProcessReader>();
				
	public MyWorkFlowReader(ConcurrentHashMap<String, MyActionReader> actions, String name, ConcurrentHashMap<String, MyProcessReader> processes) throws WorkflowMonitorException {
		//this.action = action;
		//if(isNameValid(name)){
		this.name = name;//}
		//else{
			//throw new WorkflowMonitorException("Name is not true!");
		//}
		this.actions = actions;
		this.processes = processes;
	}
	
	@Override
	public ActionReader getAction(String arg0) {
		return actions.get(arg0);
	}

	@Override
	public Set<ActionReader> getActions() {
		return new HashSet<ActionReader>(actions.values());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Set<ProcessReader> getProcesses() {
		return new HashSet<ProcessReader>(processes.values());
	}
	
	public ConcurrentHashMap<String, MyActionReader> getActionList() {
		return actions;
	}
	
	public ConcurrentHashMap<String, MyProcessReader> getProcessList() {
		return processes;
	}

	
	public void addProcess(MyProcessReader process) {
		processes.put(process.getStartTime().toString(), process);
	}
	
//	public static boolean isNameValid(String name) {
//		String Regx = "[A-Za-z][A-Za-z0-9]*";
//		return (name.matches(Regx));
//	}

}
