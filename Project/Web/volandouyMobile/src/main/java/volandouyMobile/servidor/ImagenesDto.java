
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para imagenesDto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="imagenesDto">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="imagenes" type="{http://servidor.volandouy/}imagenDto" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imagenesDto", propOrder = {
    "imagenes"
})
public class ImagenesDto {

    @XmlElement(nillable = true)
    protected List<ImagenDto> imagenes;

    /**
     * Gets the value of the imagenes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the imagenes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImagenes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImagenDto }
     * 
     * 
     * @return
     *     The value of the imagenes property.
     */
    public List<ImagenDto> getImagenes() {
        if (imagenes == null) {
            imagenes = new ArrayList<>();
        }
        return this.imagenes;
    }

}
