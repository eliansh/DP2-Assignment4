
package it.polito.dp2.WF.sol4.client1.workflow;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.dp2.WF.sol4.client1.workflow package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WrongArgumentFault_QNAME = new QName("http://www.example.org/Workflow/", "WrongArgumentFault");
    private final static QName _WrongActorFault_QNAME = new QName("http://www.example.org/Workflow/", "WrongActorFault");
    private final static QName _In1_QNAME = new QName("http://www.example.org/Workflow/", "in1");
    private final static QName _In2_QNAME = new QName("http://www.example.org/Workflow/", "in2");
    private final static QName _Out_QNAME = new QName("http://www.example.org/Workflow/", "out");
    private final static QName _Out2_QNAME = new QName("http://www.example.org/Workflow/", "out2");
    private final static QName _WrongActionFault_QNAME = new QName("http://www.example.org/Workflow/", "WrongActionFault");
    private final static QName _WrongWorkFlowFault_QNAME = new QName("http://www.example.org/Workflow/", "WrongWorkFlowFault");
    private final static QName _In_QNAME = new QName("http://www.example.org/Workflow/", "in");
    private final static QName _Out1_QNAME = new QName("http://www.example.org/Workflow/", "out1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.dp2.WF.sol4.client1.workflow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProcesses }
     * 
     */
    public GetProcesses createGetProcesses() {
        return new GetProcesses();
    }

    /**
     * Create an instance of {@link CheckSimpleOrProcessResponse }
     * 
     */
    public CheckSimpleOrProcessResponse createCheckSimpleOrProcessResponse() {
        return new CheckSimpleOrProcessResponse();
    }

    /**
     * Create an instance of {@link CheckSimpleOrProcess }
     * 
     */
    public CheckSimpleOrProcess createCheckSimpleOrProcess() {
        return new CheckSimpleOrProcess();
    }

    /**
     * Create an instance of {@link TakeOverAction }
     * 
     */
    public TakeOverAction createTakeOverAction() {
        return new TakeOverAction();
    }

    /**
     * Create an instance of {@link ActorType }
     * 
     */
    public ActorType createActorType() {
        return new ActorType();
    }

    /**
     * Create an instance of {@link ServerErrorFault }
     * 
     */
    public ServerErrorFault createServerErrorFault() {
        return new ServerErrorFault();
    }

    /**
     * Create an instance of {@link GetProcess }
     * 
     */
    public GetProcess createGetProcess() {
        return new GetProcess();
    }

    /**
     * Create an instance of {@link TakeOverActionResponse }
     * 
     */
    public TakeOverActionResponse createTakeOverActionResponse() {
        return new TakeOverActionResponse();
    }

    /**
     * Create an instance of {@link CreateProcess }
     * 
     */
    public CreateProcess createCreateProcess() {
        return new CreateProcess();
    }

    /**
     * Create an instance of {@link CreateProcessResponse }
     * 
     */
    public CreateProcessResponse createCreateProcessResponse() {
        return new CreateProcessResponse();
    }

    /**
     * Create an instance of {@link WrongStartTimeFault }
     * 
     */
    public WrongStartTimeFault createWrongStartTimeFault() {
        return new WrongStartTimeFault();
    }

    /**
     * Create an instance of {@link GetWorkFlowsResponse }
     * 
     */
    public GetWorkFlowsResponse createGetWorkFlowsResponse() {
        return new GetWorkFlowsResponse();
    }

    /**
     * Create an instance of {@link GetWorkFlowResponse }
     * 
     */
    public GetWorkFlowResponse createGetWorkFlowResponse() {
        return new GetWorkFlowResponse();
    }

    /**
     * Create an instance of {@link WorkflowType }
     * 
     */
    public WorkflowType createWorkflowType() {
        return new WorkflowType();
    }

    /**
     * Create an instance of {@link GetProcessesResponse }
     * 
     */
    public GetProcessesResponse createGetProcessesResponse() {
        return new GetProcessesResponse();
    }

    /**
     * Create an instance of {@link GetWorkFlow }
     * 
     */
    public GetWorkFlow createGetWorkFlow() {
        return new GetWorkFlow();
    }

    /**
     * Create an instance of {@link GetProcessResponse }
     * 
     */
    public GetProcessResponse createGetProcessResponse() {
        return new GetProcessResponse();
    }

    /**
     * Create an instance of {@link ProcessType }
     * 
     */
    public ProcessType createProcessType() {
        return new ProcessType();
    }

    /**
     * Create an instance of {@link GetWorkFlows }
     * 
     */
    public GetWorkFlows createGetWorkFlows() {
        return new GetWorkFlows();
    }

    /**
     * Create an instance of {@link CompleteAction }
     * 
     */
    public CompleteAction createCompleteAction() {
        return new CompleteAction();
    }

    /**
     * Create an instance of {@link CompleteActionResponse }
     * 
     */
    public CompleteActionResponse createCompleteActionResponse() {
        return new CompleteActionResponse();
    }

    /**
     * Create an instance of {@link ActionStatusType }
     * 
     */
    public ActionStatusType createActionStatusType() {
        return new ActionStatusType();
    }

    /**
     * Create an instance of {@link ActionType }
     * 
     */
    public ActionType createActionType() {
        return new ActionType();
    }

    /**
     * Create an instance of {@link SimpleActType }
     * 
     */
    public SimpleActType createSimpleActType() {
        return new SimpleActType();
    }

    /**
     * Create an instance of {@link ProcessActType }
     * 
     */
    public ProcessActType createProcessActType() {
        return new ProcessActType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "WrongArgumentFault")
    public JAXBElement<String> createWrongArgumentFault(String value) {
        return new JAXBElement<String>(_WrongArgumentFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "WrongActorFault")
    public JAXBElement<String> createWrongActorFault(String value) {
        return new JAXBElement<String>(_WrongActorFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "in1")
    public JAXBElement<String> createIn1(String value) {
        return new JAXBElement<String>(_In1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "in2")
    public JAXBElement<String> createIn2(String value) {
        return new JAXBElement<String>(_In2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "out")
    public JAXBElement<String> createOut(String value) {
        return new JAXBElement<String>(_Out_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "out2")
    public JAXBElement<String> createOut2(String value) {
        return new JAXBElement<String>(_Out2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "WrongActionFault")
    public JAXBElement<String> createWrongActionFault(String value) {
        return new JAXBElement<String>(_WrongActionFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "WrongWorkFlowFault")
    public JAXBElement<String> createWrongWorkFlowFault(String value) {
        return new JAXBElement<String>(_WrongWorkFlowFault_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "in")
    public JAXBElement<String> createIn(String value) {
        return new JAXBElement<String>(_In_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Workflow/", name = "out1")
    public JAXBElement<String> createOut1(String value) {
        return new JAXBElement<String>(_Out1_QNAME, String.class, null, value);
    }

}
