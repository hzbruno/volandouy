
package volandouy.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para rutaDeVuelo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="rutaDeVuelo">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="aerolinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="categorias" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="costoBaseEjecutivo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="costoBaseTurista" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="costoEquipajeExtra" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="descripcionCorta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="destino" type="{http://servidor.volandouy/}ciudad" minOccurs="0"/>
 *         <element name="estado" type="{http://servidor.volandouy/}enumEstado" minOccurs="0"/>
 *         <element name="fechaDeAlta" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="hora" type="{http://servidor.volandouy/}dtHora" minOccurs="0"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="origen" type="{http://servidor.volandouy/}ciudad" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rutaDeVuelo", propOrder = {
    "aerolinea",
    "categorias",
    "costoBaseEjecutivo",
    "costoBaseTurista",
    "costoEquipajeExtra",
    "descripcion",
    "descripcionCorta",
    "destino",
    "estado",
    "fechaDeAlta",
    "hora",
    "nombre",
    "origen"
})
public class RutaDeVuelo {

    protected String aerolinea;
    @XmlElement(nillable = true)
    protected List<String> categorias;
    protected double costoBaseEjecutivo;
    protected double costoBaseTurista;
    protected double costoEquipajeExtra;
    protected String descripcion;
    protected String descripcionCorta;
    protected Ciudad destino;
    @XmlSchemaType(name = "string")
    protected EnumEstado estado;
    protected DtFecha fechaDeAlta;
    protected DtHora hora;
    protected String nombre;
    protected Ciudad origen;

    /**
     * Obtiene el valor de la propiedad aerolinea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAerolinea() {
        return aerolinea;
    }

    /**
     * Define el valor de la propiedad aerolinea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAerolinea(String value) {
        this.aerolinea = value;
    }

    /**
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the categorias property.
     */
    public List<String> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<>();
        }
        return this.categorias;
    }

    /**
     * Obtiene el valor de la propiedad costoBaseEjecutivo.
     * 
     */
    public double getCostoBaseEjecutivo() {
        return costoBaseEjecutivo;
    }

    /**
     * Define el valor de la propiedad costoBaseEjecutivo.
     * 
     */
    public void setCostoBaseEjecutivo(double value) {
        this.costoBaseEjecutivo = value;
    }

    /**
     * Obtiene el valor de la propiedad costoBaseTurista.
     * 
     */
    public double getCostoBaseTurista() {
        return costoBaseTurista;
    }

    /**
     * Define el valor de la propiedad costoBaseTurista.
     * 
     */
    public void setCostoBaseTurista(double value) {
        this.costoBaseTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad costoEquipajeExtra.
     * 
     */
    public double getCostoEquipajeExtra() {
        return costoEquipajeExtra;
    }

    /**
     * Define el valor de la propiedad costoEquipajeExtra.
     * 
     */
    public void setCostoEquipajeExtra(double value) {
        this.costoEquipajeExtra = value;
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
     * Obtiene el valor de la propiedad descripcionCorta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    /**
     * Define el valor de la propiedad descripcionCorta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionCorta(String value) {
        this.descripcionCorta = value;
    }

    /**
     * Obtiene el valor de la propiedad destino.
     * 
     * @return
     *     possible object is
     *     {@link Ciudad }
     *     
     */
    public Ciudad getDestino() {
        return destino;
    }

    /**
     * Define el valor de la propiedad destino.
     * 
     * @param value
     *     allowed object is
     *     {@link Ciudad }
     *     
     */
    public void setDestino(Ciudad value) {
        this.destino = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EnumEstado }
     *     
     */
    public EnumEstado getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumEstado }
     *     
     */
    public void setEstado(EnumEstado value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDeAlta.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaDeAlta() {
        return fechaDeAlta;
    }

    /**
     * Define el valor de la propiedad fechaDeAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaDeAlta(DtFecha value) {
        this.fechaDeAlta = value;
    }

    /**
     * Obtiene el valor de la propiedad hora.
     * 
     * @return
     *     possible object is
     *     {@link DtHora }
     *     
     */
    public DtHora getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     * @param value
     *     allowed object is
     *     {@link DtHora }
     *     
     */
    public void setHora(DtHora value) {
        this.hora = value;
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
     * Obtiene el valor de la propiedad origen.
     * 
     * @return
     *     possible object is
     *     {@link Ciudad }
     *     
     */
    public Ciudad getOrigen() {
        return origen;
    }

    /**
     * Define el valor de la propiedad origen.
     * 
     * @param value
     *     allowed object is
     *     {@link Ciudad }
     *     
     */
    public void setOrigen(Ciudad value) {
        this.origen = value;
    }

}
