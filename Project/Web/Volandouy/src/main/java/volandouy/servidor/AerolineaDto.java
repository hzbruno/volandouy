
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para aerolineaDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="aerolineaDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="aerolinea" type="{http://servidor.volandouy/}aerolinea" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aerolineaDto", propOrder = {
    "aerolinea"
})
public class AerolineaDto {

    protected Aerolinea aerolinea;

    /**
     * Obtiene el valor de la propiedad aerolinea.
     * 
     * @return
     *     possible object is
     *     {@link Aerolinea }
     *     
     */
    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    /**
     * Define el valor de la propiedad aerolinea.
     * 
     * @param value
     *     allowed object is
     *     {@link Aerolinea }
     *     
     */
    public void setAerolinea(Aerolinea value) {
        this.aerolinea = value;
    }

}
