
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para usuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="usuario">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="contrasenia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="correo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="seguidores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="seguidoresList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="seguidos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="siguiendo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuario", propOrder = {
    "contrasenia",
    "correo",
    "nickname",
    "nombre",
    "seguidores",
    "seguidoresList",
    "seguidos",
    "siguiendo"
})
@XmlSeeAlso({
    Aerolinea.class,
    Cliente.class
})
public class Usuario {

    protected String contrasenia;
    protected String correo;
    protected String nickname;
    protected String nombre;
    protected int seguidores;
    @XmlElement(nillable = true)
    protected List<String> seguidoresList;
    protected int seguidos;
    @XmlElement(nillable = true)
    protected List<String> siguiendo;

    /**
     * Obtiene el valor de la propiedad contrasenia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Define el valor de la propiedad contrasenia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasenia(String value) {
        this.contrasenia = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad nickname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Define el valor de la propiedad nickname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
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
     * Obtiene el valor de la propiedad seguidores.
     * 
     */
    public int getSeguidores() {
        return seguidores;
    }

    /**
     * Define el valor de la propiedad seguidores.
     * 
     */
    public void setSeguidores(int value) {
        this.seguidores = value;
    }

    /**
     * Gets the value of the seguidoresList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the seguidoresList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeguidoresList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the seguidoresList property.
     */
    public List<String> getSeguidoresList() {
        if (seguidoresList == null) {
            seguidoresList = new ArrayList<>();
        }
        return this.seguidoresList;
    }

    /**
     * Obtiene el valor de la propiedad seguidos.
     * 
     */
    public int getSeguidos() {
        return seguidos;
    }

    /**
     * Define el valor de la propiedad seguidos.
     * 
     */
    public void setSeguidos(int value) {
        this.seguidos = value;
    }

    /**
     * Gets the value of the siguiendo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the siguiendo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiguiendo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the siguiendo property.
     */
    public List<String> getSiguiendo() {
        if (siguiendo == null) {
            siguiendo = new ArrayList<>();
        }
        return this.siguiendo;
    }

}
