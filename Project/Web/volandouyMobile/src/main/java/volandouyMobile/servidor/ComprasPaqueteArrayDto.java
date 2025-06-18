
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para comprasPaqueteArrayDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="comprasPaqueteArrayDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="comprasPaquete" type="{http://servidor.volandouy/}compraPaquete" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comprasPaqueteArrayDto", propOrder = {
    "comprasPaquete"
})
public class ComprasPaqueteArrayDto {

    @XmlElement(nillable = true)
    protected List<CompraPaquete> comprasPaquete;

    /**
     * Gets the value of the comprasPaquete property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the comprasPaquete property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComprasPaquete().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompraPaquete }
     * 
     * 
     * @return
     *     The value of the comprasPaquete property.
     */
    public List<CompraPaquete> getComprasPaquete() {
        if (comprasPaquete == null) {
            comprasPaquete = new ArrayList<>();
        }
        return this.comprasPaquete;
    }

}
