
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para paqueteRuta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="paqueteRuta">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="rutaAsociada" type="{http://servidor.volandouy/}rutaDeVuelo" minOccurs="0"/>
 *         <element name="tipoAsiento" type="{http://servidor.volandouy/}enumAsiento" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paqueteRuta", propOrder = {
    "cantidad",
    "rutaAsociada",
    "tipoAsiento"
})
public class PaqueteRuta {

    protected int cantidad;
    protected RutaDeVuelo rutaAsociada;
    @XmlSchemaType(name = "string")
    protected EnumAsiento tipoAsiento;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad rutaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link RutaDeVuelo }
     *     
     */
    public RutaDeVuelo getRutaAsociada() {
        return rutaAsociada;
    }

    /**
     * Define el valor de la propiedad rutaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link RutaDeVuelo }
     *     
     */
    public void setRutaAsociada(RutaDeVuelo value) {
        this.rutaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoAsiento.
     * 
     * @return
     *     possible object is
     *     {@link EnumAsiento }
     *     
     */
    public EnumAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    /**
     * Define el valor de la propiedad tipoAsiento.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumAsiento }
     *     
     */
    public void setTipoAsiento(EnumAsiento value) {
        this.tipoAsiento = value;
    }

}
