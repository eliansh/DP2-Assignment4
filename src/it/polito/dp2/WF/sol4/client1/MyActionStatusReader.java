package it.polito.dp2.WF.sol4.client1;

import java.util.Calendar;

import it.polito.dp2.WF.ActionStatusReader;
import it.polito.dp2.WF.Actor;
import it.polito.dp2.WF.WorkflowMonitorException;

public class MyActionStatusReader implements ActionStatusReader{

	private String actionName;
	private Actor actor;
	private Calendar termination;
	private boolean isTaken;
	private boolean isTerminated;
	
	public MyActionStatusReader(String actionName, Actor actor,Calendar termination,boolean isTaken, boolean isTerminated) throws WorkflowMonitorException{
		//if(isNameValid(actionName)){
		this.actionName = actionName;
		//}else throw new WorkflowMonitorException("Action Status Name is wrong!");
		this.isTaken = isTaken;
		if(isTaken){
		this.actor = actor;
		}
		this.isTerminated = isTerminated;
		if(isTerminated){
			this.termination = termination;
		}else{this.termination = null;}
		
	}
	@Override
	public String getActionName() {
		return actionName;
	}

	@Override
	public Actor getActor() {
		return actor;
	}

	@Override
	public Calendar getTerminationTime() {
		return termination;
	}

	@Override
	public boolean isTakenInCharge() {
		return isTaken;
	}

	@Override
	public boolean isTerminated() {
		return isTerminated;
	}
	public static boolean isNameValid(String name) {
		String Regx = "[A-Za-z][A-Za-z0-9]*";
		return (name==null||name.matches(Regx));
	}
}
