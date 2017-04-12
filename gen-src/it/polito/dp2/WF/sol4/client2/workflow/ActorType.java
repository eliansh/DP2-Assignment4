
package it.polito.dp2.WF.sol4.client2.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="actorName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="actorRole" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actorType")
public class ActorType {

    @XmlAttribute(name = "actorName", namespace = "http://www.example.org/Workflow/", required = true)
    protected String actorName;
    @XmlAttribute(name = "actorRole", namespace = "http://www.example.org/Workflow/", required = true)
    protected String actorRole;

    /**
     * Gets the value of the actorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActorName() {
        return actorName;
    }

    /**
     * Sets the value of the actorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActorName(String value) {
        this.actorName = value;
    }

    /**
     * Gets the value of the actorRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActorRole() {
        return actorRole;
    }

    /**
     * Sets the value of the actorRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActorRole(String value) {
        this.actorRole = value;
    }

}
