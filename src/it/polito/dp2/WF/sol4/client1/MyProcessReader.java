package it.polito.dp2.WF.sol4.client1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowReader;

public class MyProcessReader implements ProcessReader{
	private Calendar start;
	private ArrayList<MyActionStatusReader> statusReader;
	private MyWorkFlowReader workFlow;
	
	public MyProcessReader (Calendar start, ArrayList<MyActionStatusReader> statusReader, MyWorkFlowReader workFlow){
		this.start = start;
		this.statusReader = statusReader;
		this.workFlow = workFlow;
	}
	

	@Override
	public Calendar getStartTime() {
		return start;
	}

	@Override
	public List<ActionStatusReader> getStatus() {
		return new ArrayList<ActionStatusReader>(statusReader);
	}

	@Override
	public WorkflowReader getWorkflow() {
		return workFlow;
	}

}
