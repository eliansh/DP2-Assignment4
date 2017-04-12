package it.polito.dp2.WF.sol4.client1;

import it.polito.dp2.WF.ProcessActionReader;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowReader;

public class MyProcessActionReader extends MyActionReader implements ProcessActionReader{

	private MyWorkFlowReader workFlow;
	
	public MyProcessActionReader(MyWorkFlowReader workFlow, MyWorkFlowReader myWorkFlowReader, String actionName, String actionRole, boolean isAutomatic) throws WorkflowMonitorException {
		super(myWorkFlowReader, actionName, actionRole, isAutomatic);
		this.workFlow = workFlow;
	}

	@Override
	public WorkflowReader getActionWorkflow() {
		return workFlow;
	}
}


