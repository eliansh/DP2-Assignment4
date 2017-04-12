package it.polito.dp2.WF.sol4.server;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.ProcessReader;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowReader;

public class MyProcessReader implements ProcessReader{
	private Calendar start;
	private ArrayList<MyActionStatusReader> statusReader;
	private MyWorkFlowReader workFlow;
	// I use ConcurrentSkipListMap instead of ConcurrentHashMap for paged responses.
	//private ConcurrentSkipListSet<MyActionStatusReader> statusReader;
		
	public MyProcessReader (Calendar start, ArrayList<MyActionStatusReader> statusReader, MyWorkFlowReader workFlow) throws WorkflowMonitorException{
		this.start = start;
		this.statusReader = statusReader;
		this.workFlow = workFlow;
        System.out.println("((((((MyProcessReader is instantiated:)))))) number of Status: "+statusReader.size()+"Name of Workflow: "+workFlow.getName()+"StartTime is"+formatDate(start));

		
		
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
	

	
	public void setStartTime(Calendar startTime) {
		this.start = startTime;
	}


//	@Override
//	public int compareTo(MyProcessReader o) {
//		return this.getStartTime().compareTo(o.getStartTime());
//	}
	private static String formatDate(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		dateFormat.setTimeZone(calendar.getTimeZone());
		return dateFormat.format(calendar.getTime());
	}
}
