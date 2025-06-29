
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para vueloArrayDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="vueloArrayDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="vuelo" type="{http://servidor.volandouy/}vuelo" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vueloArrayDto", propOrder = {
    "vuelo"
})
public class VueloArrayDto {

    @XmlElement(nillable = true)
    protected List<Vuelo> vuelo;

    /**
     * Gets the value of the vuelo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the vuelo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVuelo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Vuelo }
     * 
     * 
     * @return
     *     The value of the vuelo property.
     */
    public List<Vuelo> getVuelo() {
        if (vuelo == null) {
            vuelo = new ArrayList<>();
        }
        return this.vuelo;
    }

}
