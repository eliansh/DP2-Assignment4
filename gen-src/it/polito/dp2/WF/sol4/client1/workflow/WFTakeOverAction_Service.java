
package it.polito.dp2.WF.sol4.client1.workflow;

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
@WebServiceClient(name = "WFTakeOverAction", targetNamespace = "http://www.example.org/Workflow/", wsdlLocation = "file:/C:/Users/Eli/workspace/Assignment4b%20-%20alltestspassed/wsdl/Workflow.wsdl")
public class WFTakeOverAction_Service
    extends Service
{

    private final static URL WFTAKEOVERACTION_WSDL_LOCATION;
    private final static WebServiceException WFTAKEOVERACTION_EXCEPTION;
    private final static QName WFTAKEOVERACTION_QNAME = new QName("http://www.example.org/Workflow/", "WFTakeOverAction");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Eli/workspace/Assignment4b%20-%20alltestspassed/wsdl/Workflow.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WFTAKEOVERACTION_WSDL_LOCATION = url;
        WFTAKEOVERACTION_EXCEPTION = e;
    }

    public WFTakeOverAction_Service() {
        super(__getWsdlLocation(), WFTAKEOVERACTION_QNAME);
    }

    public WFTakeOverAction_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WFTAKEOVERACTION_QNAME, features);
    }

    public WFTakeOverAction_Service(URL wsdlLocation) {
        super(wsdlLocation, WFTAKEOVERACTION_QNAME);
    }

    public WFTakeOverAction_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WFTAKEOVERACTION_QNAME, features);
    }

    public WFTakeOverAction_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WFTakeOverAction_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WFTakeOverAction
     */
    @WebEndpoint(name = "WFTakeOverActionSOAP")
    public WFTakeOverAction getWFTakeOverActionSOAP() {
        return super.getPort(new QName("http://www.example.org/Workflow/", "WFTakeOverActionSOAP"), WFTakeOverAction.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WFTakeOverAction
     */
    @WebEndpoint(name = "WFTakeOverActionSOAP")
    public WFTakeOverAction getWFTakeOverActionSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.example.org/Workflow/", "WFTakeOverActionSOAP"), WFTakeOverAction.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WFTAKEOVERACTION_EXCEPTION!= null) {
            throw WFTAKEOVERACTION_EXCEPTION;
        }
        return WFTAKEOVERACTION_WSDL_LOCATION;
    }

}
