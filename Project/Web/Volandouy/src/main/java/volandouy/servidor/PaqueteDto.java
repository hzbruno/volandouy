
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para paqueteDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="paqueteDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="paquete" type="{http://servidor.volandouy/}paquete" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paqueteDto", propOrder = {
    "paquete"
})
public class PaqueteDto {

    protected Paquete paquete;

    /**
     * Obtiene el valor de la propiedad paquete.
     * 
     * @return
     *     possible object is
     *     {@link Paquete }
     *     
     */
    public Paquete getPaquete() {
        return paquete;
    }

    /**
     * Define el valor de la propiedad paquete.
     * 
     * @param value
     *     allowed object is
     *     {@link Paquete }
     *     
     */
    public void setPaquete(Paquete value) {
        this.paquete = value;
    }

}
