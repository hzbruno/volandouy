
package volandouy.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para personasArrayDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="personasArrayDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="pasaje" type="{http://servidor.volandouy/}pasaje" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personasArrayDto", propOrder = {
    "pasaje"
})
public class PersonasArrayDto {

    @XmlElement(nillable = true)
    protected List<Pasaje> pasaje;

    /**
     * Gets the value of the pasaje property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the pasaje property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPasaje().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pasaje }
     * 
     * 
     * @return
     *     The value of the pasaje property.
     */
    public List<Pasaje> getPasaje() {
        if (pasaje == null) {
            pasaje = new ArrayList<>();
        }
        return this.pasaje;
    }

}
