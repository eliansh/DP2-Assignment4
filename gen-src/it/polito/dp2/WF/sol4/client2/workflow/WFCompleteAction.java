
package it.polito.dp2.WF.sol4.client2.workflow;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * Interface for complete an action
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WFCompleteAction", targetNamespace = "http://www.example.org/Workflow/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WFCompleteAction {


    /**
     * 
     * @param actor
     * @param relatedWorkflow
     * @param nextActions
     * @param startTime
     * @param flowName
     * @param actionName
     * @throws WrongActorFault
     * @throws WrongStartTimeFault_Exception
     * @throws WrongArgumentFault
     * @throws ServerErrorFault_Exception
     * @throws WrongWorkFlowFault
     * @throws WrongActionFault
     */
    @WebMethod(action = "http://www.example.org/WFCompleteAction/completeAction")
    @RequestWrapper(localName = "completeAction", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.client2.workflow.CompleteAction")
    @ResponseWrapper(localName = "completeActionResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.client2.workflow.CompleteActionResponse")
    public void completeAction(
        @WebParam(name = "actionName", targetNamespace = "http://www.example.org/Workflow/")
        String actionName,
        @WebParam(name = "startTime", targetNamespace = "http://www.example.org/Workflow/")
        XMLGregorianCalendar startTime,
        @WebParam(name = "flowName", targetNamespace = "http://www.example.org/Workflow/")
        String flowName,
        @WebParam(name = "actor", targetNamespace = "http://www.example.org/Workflow/")
        ActorType actor,
        @WebParam(name = "nextActions", targetNamespace = "http://www.example.org/Workflow/")
        List<String> nextActions,
        @WebParam(name = "relatedWorkflow", targetNamespace = "http://www.example.org/Workflow/")
        String relatedWorkflow)
        throws ServerErrorFault_Exception, WrongActionFault, WrongActorFault, WrongArgumentFault, WrongStartTimeFault_Exception, WrongWorkFlowFault
    ;

    /**
     * 
     * @param relatedWorkflow
     * @param nextActions
     * @param flowName
     * @param actionName
     * @throws WrongArgumentFault
     * @throws ServerErrorFault_Exception
     * @throws WrongWorkFlowFault
     * @throws WrongActionFault
     */
    @WebMethod(action = "http://www.example.org/WFCompleteAction/checkSimpleOrProcess")
    @RequestWrapper(localName = "checkSimpleOrProcess", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.client2.workflow.CheckSimpleOrProcess")
    @ResponseWrapper(localName = "checkSimpleOrProcessResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.client2.workflow.CheckSimpleOrProcessResponse")
    public void checkSimpleOrProcess(
        @WebParam(name = "actionName", targetNamespace = "http://www.example.org/Workflow/")
        String actionName,
        @WebParam(name = "flowName", targetNamespace = "http://www.example.org/Workflow/")
        String flowName,
        @WebParam(name = "nextActions", targetNamespace = "http://www.example.org/Workflow/", mode = WebParam.Mode.OUT)
        Holder<List<String>> nextActions,
        @WebParam(name = "relatedWorkflow", targetNamespace = "http://www.example.org/Workflow/", mode = WebParam.Mode.OUT)
        Holder<String> relatedWorkflow)
        throws ServerErrorFault_Exception, WrongActionFault, WrongArgumentFault, WrongWorkFlowFault
    ;

}
