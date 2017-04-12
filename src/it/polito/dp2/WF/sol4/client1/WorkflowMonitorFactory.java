package it.polito.dp2.WF.sol4.client1;

import java.net.MalformedURLException;

import it.polito.dp2.WF.WorkflowMonitor;
import it.polito.dp2.WF.WorkflowMonitorException;

public class WorkflowMonitorFactory extends it.polito.dp2.WF.WorkflowMonitorFactory{

	@Override
	public WorkflowMonitor newWorkflowMonitor() throws WorkflowMonitorException {
		MyWorkFlowMonitor mwf = null;
		try {
			mwf = new MyWorkFlowMonitor();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mwf;
	}

}
