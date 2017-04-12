
package it.polito.dp2.WF.sol4.client1.workflow;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nextActions" type="{http://www.example.org/Workflow/}nameType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="relatedWorkflow" type="{http://www.example.org/Workflow/}nameType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nextActions",
    "relatedWorkflow"
})
@XmlRootElement(name = "checkSimpleOrProcessResponse")
public class CheckSimpleOrProcessResponse {

    @XmlElement(nillable = true)
    protected List<String> nextActions;
    @XmlElement(required = true, nillable = true)
    protected String relatedWorkflow;

    /**
     * Gets the value of the nextActions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nextActions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNextActions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNextActions() {
        if (nextActions == null) {
            nextActions = new ArrayList<String>();
        }
        return this.nextActions;
    }

    /**
     * Gets the value of the relatedWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedWorkflow() {
        return relatedWorkflow;
    }

    /**
     * Sets the value of the relatedWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedWorkflow(String value) {
        this.relatedWorkflow = value;
    }

}
