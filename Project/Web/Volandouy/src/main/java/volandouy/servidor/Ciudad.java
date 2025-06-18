
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ciudad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="ciudad">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="aeropuerto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaAlta" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="pagWeb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="pais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ciudad", propOrder = {
    "aeropuerto",
    "descripcion",
    "fechaAlta",
    "nombre",
    "pagWeb",
    "pais"
})
public class Ciudad {

    protected String aeropuerto;
    protected String descripcion;
    protected DtFecha fechaAlta;
    protected String nombre;
    protected String pagWeb;
    protected String pais;

    /**
     * Obtiene el valor de la propiedad aeropuerto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAeropuerto() {
        return aeropuerto;
    }

    /**
     * Define el valor de la propiedad aeropuerto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAeropuerto(String value) {
        this.aeropuerto = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaAlta(DtFecha value) {
        this.fechaAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad pagWeb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagWeb() {
        return pagWeb;
    }

    /**
     * Define el valor de la propiedad pagWeb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagWeb(String value) {
        this.pagWeb = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

}
