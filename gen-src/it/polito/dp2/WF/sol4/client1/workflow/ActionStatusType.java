
package it.polito.dp2.WF.sol4.client1.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for actionStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actionStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actor" type="{http://www.example.org/Workflow/}actorType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="actionStatName" use="required" type="{http://www.example.org/Workflow/}nameType" />
 *       &lt;attribute name="terminated" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="terminationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="takenInCharge" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionStatusType", propOrder = {
    "actor"
})
public class ActionStatusType {

    protected ActorType actor;
    @XmlAttribute(name = "actionStatName", namespace = "http://www.example.org/Workflow/", required = true)
    protected String actionStatName;
    @XmlAttribute(name = "terminated", namespace = "http://www.example.org/Workflow/", required = true)
    protected boolean terminated;
    @XmlAttribute(name = "terminationTime", namespace = "http://www.example.org/Workflow/")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar terminationTime;
    @XmlAttribute(name = "takenInCharge", namespace = "http://www.example.org/Workflow/", required = true)
    protected boolean takenInCharge;

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link ActorType }
     *     
     */
    public ActorType getActor() {
        return actor;
    }

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActorType }
     *     
     */
    public void setActor(ActorType value) {
        this.actor = value;
    }

    /**
     * Gets the value of the actionStatName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionStatName() {
        return actionStatName;
    }

    /**
     * Sets the value of the actionStatName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionStatName(String value) {
        this.actionStatName = value;
    }

    /**
     * Gets the value of the terminated property.
     * 
     */
    public boolean isTerminated() {
        return terminated;
    }

    /**
     * Sets the value of the terminated property.
     * 
     */
    public void setTerminated(boolean value) {
        this.terminated = value;
    }

    /**
     * Gets the value of the terminationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminationTime() {
        return terminationTime;
    }

    /**
     * Sets the value of the terminationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminationTime(XMLGregorianCalendar value) {
        this.terminationTime = value;
    }

    /**
     * Gets the value of the takenInCharge property.
     * 
     */
    public boolean isTakenInCharge() {
        return takenInCharge;
    }

    /**
     * Sets the value of the takenInCharge property.
     * 
     */
    public void setTakenInCharge(boolean value) {
        this.takenInCharge = value;
    }

}
