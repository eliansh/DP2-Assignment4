
package it.polito.dp2.WF.sol4.client2.workflow;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WFCompleteAction", targetNamespace = "http://www.example.org/Workflow/", wsdlLocation = "file:/C:/Users/Eli/workspace/Assignment4b%20-%20alltestspassed/wsdl/Workflow.wsdl")
public class WFCompleteAction_Service
    extends Service
{

    private final static URL WFCOMPLETEACTION_WSDL_LOCATION;
    private final static WebServiceException WFCOMPLETEACTION_EXCEPTION;
    private final static QName WFCOMPLETEACTION_QNAME = new QName("http://www.example.org/Workflow/", "WFCompleteAction");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Eli/workspace/Assignment4b%20-%20alltestspassed/wsdl/Workflow.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WFCOMPLETEACTION_WSDL_LOCATION = url;
        WFCOMPLETEACTION_EXCEPTION = e;
    }

    public WFCompleteAction_Service() {
        super(__getWsdlLocation(), WFCOMPLETEACTION_QNAME);
    }

    public WFCompleteAction_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WFCOMPLETEACTION_QNAME, features);
    }

    public WFCompleteAction_Service(URL wsdlLocation) {
        super(wsdlLocation, WFCOMPLETEACTION_QNAME);
    }

    public WFCompleteAction_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WFCOMPLETEACTION_QNAME, features);
    }

    public WFCompleteAction_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WFCompleteAction_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WFCompleteAction
     */
    @WebEndpoint(name = "WFCompleteActionSOAP")
    public WFCompleteAction getWFCompleteActionSOAP() {
        return super.getPort(new QName("http://www.example.org/Workflow/", "WFCompleteActionSOAP"), WFCompleteAction.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WFCompleteAction
     */
    @WebEndpoint(name = "WFCompleteActionSOAP")
    public WFCompleteAction getWFCompleteActionSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.example.org/Workflow/", "WFCompleteActionSOAP"), WFCompleteAction.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WFCOMPLETEACTION_EXCEPTION!= null) {
            throw WFCOMPLETEACTION_EXCEPTION;
        }
        return WFCOMPLETEACTION_WSDL_LOCATION;
    }

}
