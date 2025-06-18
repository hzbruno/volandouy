
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rutaDeVueloDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="rutaDeVueloDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="rutaDeVuelo" type="{http://servidor.volandouy/}rutaDeVuelo" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rutaDeVueloDto", propOrder = {
    "rutaDeVuelo"
})
public class RutaDeVueloDto {

    protected RutaDeVuelo rutaDeVuelo;

    /**
     * Obtiene el valor de la propiedad rutaDeVuelo.
     * 
     * @return
     *     possible object is
     *     {@link RutaDeVuelo }
     *     
     */
    public RutaDeVuelo getRutaDeVuelo() {
        return rutaDeVuelo;
    }

    /**
     * Define el valor de la propiedad rutaDeVuelo.
     * 
     * @param value
     *     allowed object is
     *     {@link RutaDeVuelo }
     *     
     */
    public void setRutaDeVuelo(RutaDeVuelo value) {
        this.rutaDeVuelo = value;
    }

}
