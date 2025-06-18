
package volandouy.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para paquetesRutaArrayDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="paquetesRutaArrayDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="paquetesRuta" type="{http://servidor.volandouy/}paqueteRuta" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paquetesRutaArrayDto", propOrder = {
    "paquetesRuta"
})
public class PaquetesRutaArrayDto {

    @XmlElement(nillable = true)
    protected List<PaqueteRuta> paquetesRuta;

    /**
     * Gets the value of the paquetesRuta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the paquetesRuta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetesRuta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaqueteRuta }
     * 
     * 
     * @return
     *     The value of the paquetesRuta property.
     */
    public List<PaqueteRuta> getPaquetesRuta() {
        if (paquetesRuta == null) {
            paquetesRuta = new ArrayList<>();
        }
        return this.paquetesRuta;
    }

}
