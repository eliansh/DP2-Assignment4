
package it.polito.dp2.WF.sol4.server.workflow;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * Interface for take over an action
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WFTakeOverAction", targetNamespace = "http://www.example.org/Workflow/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WFTakeOverAction {


    /**
     * 
     * @param actor
     * @param startTime
     * @param flowName
     * @param actionName
     * @throws WrongActorFault
     * @throws ServerErrorFault_Exception
     * @throws WrongWorkFlowFault
     * @throws WrongStartTimeFault_Exception
     * @throws WrongArgumentFault
     */
    @WebMethod(action = "http://www.example.org/WFTakeOverAction/takeOverAction")
    @RequestWrapper(localName = "takeOverAction", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.TakeOverAction")
    @ResponseWrapper(localName = "takeOverActionResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.server.workflow.TakeOverActionResponse")
    public void takeOverAction(
        @WebParam(name = "actionName", targetNamespace = "http://www.example.org/Workflow/")
        String actionName,
        @WebParam(name = "startTime", targetNamespace = "http://www.example.org/Workflow/")
        XMLGregorianCalendar startTime,
        @WebParam(name = "flowName", targetNamespace = "http://www.example.org/Workflow/")
        String flowName,
        @WebParam(name = "actor", targetNamespace = "http://www.example.org/Workflow/")
        ActorType actor)
        throws ServerErrorFault_Exception, WrongActorFault, WrongArgumentFault, WrongStartTimeFault_Exception, WrongWorkFlowFault
    ;

}
