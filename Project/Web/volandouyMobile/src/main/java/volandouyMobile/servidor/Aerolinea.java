
package volandouyMobile.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para aerolinea complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="aerolinea">
 *   <complexContent>
 *     <extension base="{http://servidor.volandouy/}usuario">
 *       <sequence>
 *         <element name="descripcionGeneral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="sitioWeb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aerolinea", propOrder = {
    "descripcionGeneral",
    "sitioWeb"
})
public class Aerolinea
    extends Usuario
{

    protected String descripcionGeneral;
    protected String sitioWeb;

    /**
     * Obtiene el valor de la propiedad descripcionGeneral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    /**
     * Define el valor de la propiedad descripcionGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionGeneral(String value) {
        this.descripcionGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad sitioWeb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    /**
     * Define el valor de la propiedad sitioWeb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSitioWeb(String value) {
        this.sitioWeb = value;
    }

}
