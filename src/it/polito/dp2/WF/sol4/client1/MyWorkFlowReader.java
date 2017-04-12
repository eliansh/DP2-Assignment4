package it.polito.dp2.WF.sol4.client1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowReader;

public class MyWorkFlowReader implements WorkflowReader{

	//private MyActionReader action;
	private String name;
	private HashMap<String, MyActionReader> actions;
	private HashSet<MyProcessReader> processes;
	
	public MyWorkFlowReader(HashMap<String, MyActionReader> actions, String name, HashSet<MyProcessReader> processes) throws WorkflowMonitorException {
		//this.action = action;
		if(isNameValid(name)){
		this.name = name;}
		else{
			throw new WorkflowMonitorException("Name is not true!");
		}
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
		return new HashSet<ProcessReader>(processes);
	}
	
	public static boolean isNameValid(String name) {
		String Regx = "[A-Za-z][A-Za-z0-9]*";
		return (name.matches(Regx));
	}

}
