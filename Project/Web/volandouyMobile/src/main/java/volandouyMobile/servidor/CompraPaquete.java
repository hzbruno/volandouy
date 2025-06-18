
package volandouyMobile.servidor;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para compraPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="compraPaquete">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="fechaDeCompra" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="fechaVencimiento" type="{http://servidor.volandouy/}dtFecha" minOccurs="0"/>
 *         <element name="paquete" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="paqueteAsociado" type="{http://servidor.volandouy/}paquete" minOccurs="0"/>
 *         <element name="restantes">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     <complexType>
 *                       <complexContent>
 *                         <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           <sequence>
 *                             <element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             <element name="value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                           </sequence>
 *                         </restriction>
 *                       </complexContent>
 *                     </complexType>
 *                   </element>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compraPaquete", propOrder = {
    "cliente",
    "costo",
    "fechaDeCompra",
    "fechaVencimiento",
    "paquete",
    "paqueteAsociado",
    "restantes"
})
public class CompraPaquete {

    protected String cliente;
    protected float costo;
    protected DtFecha fechaDeCompra;
    protected DtFecha fechaVencimiento;
    protected String paquete;
    protected Paquete paqueteAsociado;
    @XmlElement(required = true)
    protected CompraPaquete.Restantes restantes;

    /**
     * Obtiene el valor de la propiedad cliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Define el valor de la propiedad cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDeCompra.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaDeCompra() {
        return fechaDeCompra;
    }

    /**
     * Define el valor de la propiedad fechaDeCompra.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaDeCompra(DtFecha value) {
        this.fechaDeCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVencimiento.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Define el valor de la propiedad fechaVencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaVencimiento(DtFecha value) {
        this.fechaVencimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad paquete.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaquete() {
        return paquete;
    }

    /**
     * Define el valor de la propiedad paquete.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaquete(String value) {
        this.paquete = value;
    }

    /**
     * Obtiene el valor de la propiedad paqueteAsociado.
     * 
     * @return
     *     possible object is
     *     {@link Paquete }
     *     
     */
    public Paquete getPaqueteAsociado() {
        return paqueteAsociado;
    }

    /**
     * Define el valor de la propiedad paqueteAsociado.
     * 
     * @param value
     *     allowed object is
     *     {@link Paquete }
     *     
     */
    public void setPaqueteAsociado(Paquete value) {
        this.paqueteAsociado = value;
    }

    /**
     * Obtiene el valor de la propiedad restantes.
     * 
     * @return
     *     possible object is
     *     {@link CompraPaquete.Restantes }
     *     
     */
    public CompraPaquete.Restantes getRestantes() {
        return restantes;
    }

    /**
     * Define el valor de la propiedad restantes.
     * 
     * @param value
     *     allowed object is
     *     {@link CompraPaquete.Restantes }
     *     
     */
    public void setRestantes(CompraPaquete.Restantes value) {
        this.restantes = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           <complexType>
     *             <complexContent>
     *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 <sequence>
     *                   <element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   <element name="value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                 </sequence>
     *               </restriction>
     *             </complexContent>
     *           </complexType>
     *         </element>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class Restantes {

        protected List<CompraPaquete.Restantes.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a {@code set} method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CompraPaquete.Restantes.Entry }
         * 
         * 
         * @return
         *     The value of the entry property.
         */
        public List<CompraPaquete.Restantes.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<>();
            }
            return this.entry;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>{@code
         * <complexType>
         *   <complexContent>
         *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       <sequence>
         *         <element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         <element name="value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *       </sequence>
         *     </restriction>
         *   </complexContent>
         * </complexType>
         * }</pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected Integer value;

            /**
             * Obtiene el valor de la propiedad key.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * Define el valor de la propiedad key.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setValue(Integer value) {
                this.value = value;
            }

        }

    }

}
