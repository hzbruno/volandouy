
package volandouyMobile.servidor;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para enumEstado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="enumEstado">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="INGRESADA"/>
 *     <enumeration value="CONFIRMADA"/>
 *     <enumeration value="RECHAZADA"/>
 *     <enumeration value="FINALIZADA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "enumEstado")
@XmlEnum
public enum EnumEstado {

    INGRESADA,
    CONFIRMADA,
    RECHAZADA,
    FINALIZADA;

    public String value() {
        return name();
    }

    public static EnumEstado fromValue(String v) {
        return valueOf(v);
    }

}
