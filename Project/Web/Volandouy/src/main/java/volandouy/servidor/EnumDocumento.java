
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para enumDocumento.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="enumDocumento">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="PASAPORTE"/>
 *     <enumeration value="DNI"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "enumDocumento")
@XmlEnum
public enum EnumDocumento {

    PASAPORTE,
    DNI;

    public String value() {
        return name();
    }

    public static EnumDocumento fromValue(String v) {
        return valueOf(v);
    }

}
