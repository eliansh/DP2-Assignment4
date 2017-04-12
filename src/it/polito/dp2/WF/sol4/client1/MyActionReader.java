package it.polito.dp2.WF.sol4.client1;

import it.polito.dp2.WF.ActionReader;
import it.polito.dp2.WF.WorkflowMonitorException;
import it.polito.dp2.WF.WorkflowReader;


public class MyActionReader implements ActionReader{
	private MyWorkFlowReader workFlow;
	private String actionName;
	private String actionRole;
	private boolean isAutomatic;
//	private boolean isSimple=false;
//	private boolean isProcess=false;
	
	public MyActionReader(MyWorkFlowReader workFlow, String actionName, String actionRole, boolean isAutomatic ) throws WorkflowMonitorException {
		this.workFlow = workFlow;
		if(isNameValid(actionName)){
		this.actionName = actionName;
		}else throw new WorkflowMonitorException("Action Name is Wrong!");
		if(isRoleValid(actionRole)){
		this.actionRole = actionRole;
		}else throw new WorkflowMonitorException("Action Role is Wrong!");
		this.isAutomatic = isAutomatic;
		//this.isSimple = isSimple;
		//this.isProcess = isProcess;
	
	}

	@Override
	public WorkflowReader getEnclosingWorkflow() {
		return workFlow;
	}

	@Override
	public String getName() {
		return actionName;
	}

	@Override
	public String getRole() {
		return actionRole;
	}

	@Override
	public boolean isAutomaticallyInstantiated() {
		return isAutomatic;
	}
	
	
//	public boolean isSimpled(){
//		return this.isSimple;
//	}
//	
//	public boolean isProcessed(){
//		return this.isProcess;
//	}
	
	public static boolean isNameValid(String name) {
		String Regx = "[A-Za-z][A-Za-z0-9]*";
		return (name==null||name.matches(Regx));
	}
	public static boolean isRoleValid(String role) {
		String Regx = "([A-Za-z])+";
		return (role==null||role.matches(Regx));
	}
}
