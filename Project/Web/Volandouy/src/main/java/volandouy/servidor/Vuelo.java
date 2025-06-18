
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para vuelo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="vuelo">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cantAsientoEjecutivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cantAsientoTurista" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cantAsientosEjecutivoChecked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cantAsientosTuristaChecked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cantMaxAsientoEjecutivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cantMaxAsientoTurista" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="duracion" type="{http://servidor.volandouy/}dtHora" minOccurs="0"/>
 *         <element name="fecha" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="fechaAlta" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "vuelo", propOrder = {
    "cantAsientoEjecutivo",
    "cantAsientoTurista",
    "cantAsientosEjecutivoChecked",
    "cantAsientosTuristaChecked",
    "cantMaxAsientoEjecutivo",
    "cantMaxAsientoTurista",
    "duracion",
    "fecha",
    "fechaAlta",
    "nombre",
    "rutaDeVuelo"
})
public class Vuelo {

    protected int cantAsientoEjecutivo;
    protected int cantAsientoTurista;
    protected int cantAsientosEjecutivoChecked;
    protected int cantAsientosTuristaChecked;
    protected int cantMaxAsientoEjecutivo;
    protected int cantMaxAsientoTurista;
    protected DtHora duracion;
    protected DtFecha fecha;
    protected DtFecha fechaAlta;
    protected String nombre;
    protected RutaDeVuelo rutaDeVuelo;

    /**
     * Obtiene el valor de la propiedad cantAsientoEjecutivo.
     * 
     */
    public int getCantAsientoEjecutivo() {
        return cantAsientoEjecutivo;
    }

    /**
     * Define el valor de la propiedad cantAsientoEjecutivo.
     * 
     */
    public void setCantAsientoEjecutivo(int value) {
        this.cantAsientoEjecutivo = value;
    }

    /**
     * Obtiene el valor de la propiedad cantAsientoTurista.
     * 
     */
    public int getCantAsientoTurista() {
        return cantAsientoTurista;
    }

    /**
     * Define el valor de la propiedad cantAsientoTurista.
     * 
     */
    public void setCantAsientoTurista(int value) {
        this.cantAsientoTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad cantAsientosEjecutivoChecked.
     * 
     */
    public int getCantAsientosEjecutivoChecked() {
        return cantAsientosEjecutivoChecked;
    }

    /**
     * Define el valor de la propiedad cantAsientosEjecutivoChecked.
     * 
     */
    public void setCantAsientosEjecutivoChecked(int value) {
        this.cantAsientosEjecutivoChecked = value;
    }

    /**
     * Obtiene el valor de la propiedad cantAsientosTuristaChecked.
     * 
     */
    public int getCantAsientosTuristaChecked() {
        return cantAsientosTuristaChecked;
    }

    /**
     * Define el valor de la propiedad cantAsientosTuristaChecked.
     * 
     */
    public void setCantAsientosTuristaChecked(int value) {
        this.cantAsientosTuristaChecked = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMaxAsientoEjecutivo.
     * 
     */
    public int getCantMaxAsientoEjecutivo() {
        return cantMaxAsientoEjecutivo;
    }

    /**
     * Define el valor de la propiedad cantMaxAsientoEjecutivo.
     * 
     */
    public void setCantMaxAsientoEjecutivo(int value) {
        this.cantMaxAsientoEjecutivo = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMaxAsientoTurista.
     * 
     */
    public int getCantMaxAsientoTurista() {
        return cantMaxAsientoTurista;
    }

    /**
     * Define el valor de la propiedad cantMaxAsientoTurista.
     * 
     */
    public void setCantMaxAsientoTurista(int value) {
        this.cantMaxAsientoTurista = value;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     * @return
     *     possible object is
     *     {@link DtHora }
     *     
     */
    public DtHora getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     * @param value
     *     allowed object is
     *     {@link DtHora }
     *     
     */
    public void setDuracion(DtHora value) {
        this.duracion = value;
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
