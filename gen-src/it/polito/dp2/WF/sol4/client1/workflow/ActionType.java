
package it.polito.dp2.WF.sol4.client1.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="simpleAct" type="{http://www.example.org/Workflow/}simpleActType" minOccurs="0"/>
 *         &lt;element name="processAct" type="{http://www.example.org/Workflow/}processActType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="actionName" use="required" type="{http://www.example.org/Workflow/}nameType" />
 *       &lt;attribute name="actionRole" use="required" type="{http://www.example.org/Workflow/}roleType" />
 *       &lt;attribute name="automaticallyInstantiated" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionType", propOrder = {
    "simpleAct",
    "processAct"
})
public class ActionType {

    protected SimpleActType simpleAct;
    protected ProcessActType processAct;
    @XmlAttribute(name = "actionName", namespace = "http://www.example.org/Workflow/", required = true)
    protected String actionName;
    @XmlAttribute(name = "actionRole", namespace = "http://www.example.org/Workflow/", required = true)
    protected String actionRole;
    @XmlAttribute(name = "automaticallyInstantiated", namespace = "http://www.example.org/Workflow/", required = true)
    protected boolean automaticallyInstantiated;

    /**
     * Gets the value of the simpleAct property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleActType }
     *     
     */
    public SimpleActType getSimpleAct() {
        return simpleAct;
    }

    /**
     * Sets the value of the simpleAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleActType }
     *     
     */
    public void setSimpleAct(SimpleActType value) {
        this.simpleAct = value;
    }

    /**
     * Gets the value of the processAct property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessActType }
     *     
     */
    public ProcessActType getProcessAct() {
        return processAct;
    }

    /**
     * Sets the value of the processAct property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessActType }
     *     
     */
    public void setProcessAct(ProcessActType value) {
        this.processAct = value;
    }

    /**
     * Gets the value of the actionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Sets the value of the actionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionName(String value) {
        this.actionName = value;
    }

    /**
     * Gets the value of the actionRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionRole() {
        return actionRole;
    }

    /**
     * Sets the value of the actionRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionRole(String value) {
        this.actionRole = value;
    }

    /**
     * Gets the value of the automaticallyInstantiated property.
     * 
     */
    public boolean isAutomaticallyInstantiated() {
        return automaticallyInstantiated;
    }

    /**
     * Sets the value of the automaticallyInstantiated property.
     * 
     */
    public void setAutomaticallyInstantiated(boolean value) {
        this.automaticallyInstantiated = value;
    }

}
