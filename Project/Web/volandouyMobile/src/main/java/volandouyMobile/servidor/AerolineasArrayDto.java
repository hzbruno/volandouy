
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para aerolineasArrayDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="aerolineasArrayDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="aerolineas" type="{http://servidor.volandouy/}aerolinea" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aerolineasArrayDto", propOrder = {
    "aerolineas"
})
public class AerolineasArrayDto {

    @XmlElement(nillable = true)
    protected List<Aerolinea> aerolineas;

    /**
     * Gets the value of the aerolineas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the aerolineas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAerolineas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aerolinea }
     * 
     * 
     * @return
     *     The value of the aerolineas property.
     */
    public List<Aerolinea> getAerolineas() {
        if (aerolineas == null) {
            aerolineas = new ArrayList<>();
        }
        return this.aerolineas;
    }

}
