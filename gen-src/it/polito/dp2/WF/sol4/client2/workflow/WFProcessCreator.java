
package it.polito.dp2.WF.sol4.client2.workflow;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * Interface for creating processes
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WFProcessCreator", targetNamespace = "http://www.example.org/Workflow/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WFProcessCreator {


    /**
     * Operation for create process 
     * 
     * @param flowName
     * @throws WrongStartTimeFault_Exception
     * @throws WrongArgumentFault
     * @throws ServerErrorFault_Exception
     * @throws WrongWorkFlowFault
     */
    @WebMethod(action = "http://www.example.org/WFProcessCreator/createProcess")
    @RequestWrapper(localName = "createProcess", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.client2.workflow.CreateProcess")
    @ResponseWrapper(localName = "createProcessResponse", targetNamespace = "http://www.example.org/Workflow/", className = "it.polito.dp2.WF.sol4.client2.workflow.CreateProcessResponse")
    public void createProcess(
        @WebParam(name = "flowName", targetNamespace = "http://www.example.org/Workflow/")
        String flowName)
        throws ServerErrorFault_Exception, WrongArgumentFault, WrongStartTimeFault_Exception, WrongWorkFlowFault
    ;

}
