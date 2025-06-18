
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para reserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="reserva">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantPasajes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="check" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         <element name="cliente" type="{http://servidor.volandouy/}cliente" minOccurs="0"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="fecha" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="fechaCheck" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="paquete" type="{http://servidor.volandouy/}compraPaquete" minOccurs="0"/>
 *         <element name="pasajes" type="{http://servidor.volandouy/}pasaje" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="tipoAsiento" type="{http://servidor.volandouy/}enumAsiento" minOccurs="0"/>
 *         <element name="unidadesEquipExtra" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "reserva", propOrder = {
    "cantPasajes",
    "check",
    "cliente",
    "costo",
    "fecha",
    "fechaCheck",
    "id",
    "paquete",
    "pasajes",
    "tipoAsiento",
    "unidadesEquipExtra",
    "vuelo"
})
public class Reserva {

    protected int cantPasajes;
    protected boolean check;
    protected Cliente cliente;
    protected double costo;
    protected DtFecha fecha;
    protected DtFecha fechaCheck;
    protected int id;
    protected CompraPaquete paquete;
    @XmlElement(nillable = true)
    protected List<Pasaje> pasajes;
    @XmlSchemaType(name = "string")
    protected EnumAsiento tipoAsiento;
    protected int unidadesEquipExtra;
    protected Vuelo vuelo;

    /**
     * Obtiene el valor de la propiedad cantPasajes.
     * 
     */
    public int getCantPasajes() {
        return cantPasajes;
    }

    /**
     * Define el valor de la propiedad cantPasajes.
     * 
     */
    public void setCantPasajes(int value) {
        this.cantPasajes = value;
    }

    /**
     * Obtiene el valor de la propiedad check.
     * 
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * Define el valor de la propiedad check.
     * 
     */
    public void setCheck(boolean value) {
        this.check = value;
    }

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setCliente(Cliente value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(double value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFecha(DtFecha value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCheck.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaCheck() {
        return fechaCheck;
    }

    /**
     * Define el valor de la propiedad fechaCheck.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaCheck(DtFecha value) {
        this.fechaCheck = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad paquete.
     * 
     * @return
     *     possible object is
     *     {@link CompraPaquete }
     *     
     */
    public CompraPaquete getPaquete() {
        return paquete;
    }

    /**
     * Define el valor de la propiedad paquete.
     * 
     * @param value
     *     allowed object is
     *     {@link CompraPaquete }
     *     
     */
    public void setPaquete(CompraPaquete value) {
        this.paquete = value;
    }

    /**
     * Gets the value of the pasajes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the pasajes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPasajes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pasaje }
     * 
     * 
     * @return
     *     The value of the pasajes property.
     */
    public List<Pasaje> getPasajes() {
        if (pasajes == null) {
            pasajes = new ArrayList<>();
        }
        return this.pasajes;
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

    /**
     * Obtiene el valor de la propiedad unidadesEquipExtra.
     * 
     */
    public int getUnidadesEquipExtra() {
        return unidadesEquipExtra;
    }

    /**
     * Define el valor de la propiedad unidadesEquipExtra.
     * 
     */
    public void setUnidadesEquipExtra(int value) {
        this.unidadesEquipExtra = value;
    }

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
