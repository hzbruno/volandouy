
package volandouy.servidor;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para enumAsiento.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="enumAsiento">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="turista"/>
 *     <enumeration value="ejecutivo"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "enumAsiento")
@XmlEnum
public enum EnumAsiento {

    @XmlEnumValue("turista")
    TURISTA("turista"),
    @XmlEnumValue("ejecutivo")
    EJECUTIVO("ejecutivo");
    private final String value;

    EnumAsiento(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EnumAsiento fromValue(String v) {
        for (EnumAsiento c: EnumAsiento.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
