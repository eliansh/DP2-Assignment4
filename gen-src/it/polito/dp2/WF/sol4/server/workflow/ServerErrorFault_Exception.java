
package it.polito.dp2.WF.sol4.server.workflow;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ServerErrorFault", targetNamespace = "http://www.example.org/Workflow/")
public class ServerErrorFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ServerErrorFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ServerErrorFault_Exception(String message, ServerErrorFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ServerErrorFault_Exception(String message, ServerErrorFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: it.polito.dp2.WF.sol4.server.workflow.ServerErrorFault
     */
    public ServerErrorFault getFaultInfo() {
        return faultInfo;
    }

}
