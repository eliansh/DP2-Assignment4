
package it.polito.dp2.WF.sol4.client2.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processActType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processActType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="relatedWorkFlow" use="required" type="{http://www.example.org/Workflow/}nameType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processActType")
public class ProcessActType {

    @XmlAttribute(name = "relatedWorkFlow", namespace = "http://www.example.org/Workflow/", required = true)
    protected String relatedWorkFlow;

    /**
     * Gets the value of the relatedWorkFlow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedWorkFlow() {
        return relatedWorkFlow;
    }

    /**
     * Sets the value of the relatedWorkFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedWorkFlow(String value) {
        this.relatedWorkFlow = value;
    }

}
