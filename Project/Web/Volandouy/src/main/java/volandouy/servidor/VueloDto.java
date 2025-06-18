
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para vueloDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="vueloDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="vuelo" type="{http://servidor.volandouy/}vuelo" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vueloDto", propOrder = {
    "vuelo"
})
public class VueloDto {

    protected Vuelo vuelo;

    /**
     * Obtiene el valor de la propiedad vuelo.
     * 
     * @return
     *     possible object is
     *     {@link Vuelo }
     *     
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**
     * Define el valor de la propiedad vuelo.
     * 
     * @param value
     *     allowed object is
     *     {@link Vuelo }
     *     
     */
    public void setVuelo(Vuelo value) {
        this.vuelo = value;
    }

}
