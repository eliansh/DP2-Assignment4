package it.polito.dp2.WF.sol4.server;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.SimpleActionReader;
import it.polito.dp2.WF.WorkflowMonitorException;

public class MySimpleActionReader extends MyActionReader implements SimpleActionReader{

	private HashSet<MyActionReader> nextActions;
	public MySimpleActionReader(MyWorkFlowReader workFlow, String actionName, String actionRole, boolean isAutomatic,HashSet<MyActionReader> nextActions) throws WorkflowMonitorException {
		super(workFlow, actionName, actionRole, isAutomatic);
		//System.out.println("MySimpleActionReader**actionName = "+actionName+" nextActions: "+nextActions.size());
		this.nextActions = nextActions;
	}

	@Override
	public Set<ActionReader> getPossibleNextActions() {
		return new HashSet<ActionReader>(nextActions);
	}
	
}
