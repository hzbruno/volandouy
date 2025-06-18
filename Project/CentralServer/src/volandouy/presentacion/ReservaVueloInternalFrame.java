package volandouy.presentacion;

import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import volandouy.datatypes.*;
import volandouy.excepciones.*;
import volandouy.logica.*;


public class ReservaVueloInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldDocumento;
    private JTextField textFieldNombreAerolinea;
    private JTextField textFieldSitioWeb;
    private JTextArea textAreaDescripcion;
    private JComboBox<String> comboBoxNacionalidad;
    private Cliente cliente;
	private Vuelo vuelo;
	private double precio;
	private int pasajes;
	private double precioEquipajeE;
	private int cantidadAsientosActuales;
	private CompraPaquete paqueteComprado=null;

	public ReservaVueloInternalFrame() {
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();

        setTitle("Reservar vuelo");
        setBounds(100,  100,  700,  560);
        setClosable(true);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox comboBoxAerolinea = new JComboBox();
		comboBoxAerolinea.setBounds(80,  45,  97,  22);
		
		contentPane.add(comboBoxAerolinea);
		for (String nickname : controladorUsuarios.getAerolineas().keySet()) {
			comboBoxAerolinea.addItem(nickname);
		}
		
		JComboBox comboBoxRutaDeVuelo = new JComboBox();
		comboBoxRutaDeVuelo.setBounds(299,  45,  97,  22);
		contentPane.add(comboBoxRutaDeVuelo);
		
		JComboBox comboBoxVuelo = new JComboBox();
		comboBoxVuelo.setBounds(484,  45,  97,  22);
		contentPane.add(comboBoxVuelo);
		
		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.setBounds(57,  138,  97,  22);
		contentPane.add(comboBoxCliente);
		
		for (String nickname: controladorUsuarios.getClientes().keySet()) {
			comboBoxCliente.addItem(nickname);
		}
		
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(10,  49,  60,  14);
		contentPane.add(lblAerolinea);
		
		JLabel lblRutaDeVuelo = new JLabel("Ruta de vuelo");
		lblRutaDeVuelo.setBounds(200,  49,  89,  14);
		contentPane.add(lblRutaDeVuelo);
		
		JLabel lblVuelo = new JLabel("Vuelo");
		lblVuelo.setBounds(432,  49,  46,  14);
		contentPane.add(lblVuelo);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10,  142,  46,  14);
		contentPane.add(lblCliente);
		
		JComboBox comboBoxTipoAsiento = new JComboBox();
		comboBoxTipoAsiento.setBounds(421,  138,  97,  22);
		contentPane.add(comboBoxTipoAsiento);
		
		comboBoxTipoAsiento.addItem("Turista");
		comboBoxTipoAsiento.addItem("Ejecutivo");

		JLabel lblTipoAsiento = new JLabel("Tipo de asiento");
		lblTipoAsiento.setBounds(322,  142,  89,  14);
		contentPane.add(lblTipoAsiento);
		
		JLabel lblPasajes = new JLabel("N° Pasajes");
		lblPasajes.setBounds(398,  200,  80,  14);
		contentPane.add(lblPasajes);
		
		
	    JScrollPane scrollPanePasajeros = new JScrollPane();
	    scrollPanePasajeros.setBounds(33,  199,  323,  126);
	    contentPane.add(scrollPanePasajeros);

	    DefaultTableModel tablaPersonas = new DefaultTableModel();
	    tablaPersonas.addColumn("Nombre");
	    tablaPersonas.addColumn("Apellido");

	    table = new JTable(tablaPersonas);
	    scrollPanePasajeros.setViewportView(table);
		
		JComboBox comboBoxPasajes = new JComboBox();
		comboBoxPasajes.setBounds(489,  196,  53,  22);
		contentPane.add(comboBoxPasajes);
		
	    JLabel lblEquipajeExtra = new JLabel("Equipaje extra");
	    lblEquipajeExtra.setBounds(398,  235,  97,  14);
	    contentPane.add(lblEquipajeExtra);
	    
	    JSpinner spinnerEquipajeExtra = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
	    spinnerEquipajeExtra.setBounds(496,  232,  46,  20);
	    contentPane.add(spinnerEquipajeExtra);

		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(416,  275,  46,  14);
		contentPane.add(lblCosto);
		
		JRadioButton rdbtnPaquete = new JRadioButton("Usar paquete");
		rdbtnPaquete.setBounds(180,  138,  109,  23);
		contentPane.add(rdbtnPaquete);
		rdbtnPaquete.setVisible(false);

		JTextArea lblInfoVuelo = new JTextArea("");
		lblInfoVuelo.setBounds(10,  80,  600,  40);
		contentPane.add(lblInfoVuelo);
		lblInfoVuelo.setEditable(false);
        lblInfoVuelo.setOpaque(false);
		lblInfoVuelo.setLineWrap(true);
		lblInfoVuelo.setWrapStyleWord(true);
		
		JLabel lblPrecio = new JLabel("-----");
		lblPrecio.setBounds(472,  275,  46,  14);
		contentPane.add(lblPrecio);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(180,  425,  89,  23);
		contentPane.add(btnReservar);



		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		


		comboBoxAerolinea.setSelectedIndex(-1);
		comboBoxCliente.setSelectedIndex(-1);

		comboBoxCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

				if (comboBoxCliente.getSelectedItem()!=null && comboBoxTipoAsiento.getSelectedItem()!=null){
					boolean rb =calcularPaqueteDisponible((String)comboBoxCliente.getSelectedItem(),  (String)comboBoxRutaDeVuelo.getSelectedItem(),  (String)comboBoxTipoAsiento.getSelectedItem());
					rdbtnPaquete.setVisible(rb);
					if (rb==false){
						rdbtnPaquete.setSelected(rb);
					}
				}

            }
        });

		rdbtnPaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				String nombreCliente = (String)comboBoxCliente.getSelectedItem();
				Cliente cliente = controladorUsuarios.getCliente(nombreCliente);
				String nombreRuta = (String)comboBoxRutaDeVuelo.getSelectedItem();
				String tipoAsiento = (String)comboBoxTipoAsiento.getSelectedItem();
				String vueloNombre = (String)comboBoxVuelo.getSelectedItem(); 
				Vuelo vuelo = controladorVuelos.getVuelo(vueloNombre);
				List<CompraPaquete> paquetes =  cliente.getComprasDePaquetes();
				DtFecha fechaActual = new DtFecha();
                double descuento = 1;
				if (rdbtnPaquete.isSelected()) {
					int cantidadRestante=0;
					for (CompraPaquete cp : paquetes){

						for (PaqueteRuta pr :cp.getPaqueteAsociado().getPaquetesRuta()){

							if ( pr.getRutaAsociada().getNombre().equals(nombreRuta) && cp.getRestantes().get(nombreRuta)>0 && pr.getTipoAsiento().equals(EnumAsiento.fromString(tipoAsiento)) && cp.getFechaVencimiento().compararFechas(fechaActual) != -1){
								double d=1.0-((double)(cp.getPaqueteAsociado().getDescuento())/100.0);
								if(d<=descuento) {
									descuento = d;
									cantidadRestante+=cp.getRestantes().get(nombreRuta);
									paqueteComprado = cp;
									break;
								}
							}  
						}
				
					}
					comboBoxPasajes.removeAllItems();

					if (tipoAsiento.equals("Turista")) {
		    			for (int i = 1; i <=Math.min(vuelo.getCantAsientoTurista(),  cantidadRestante); i++) {
		    			    comboBoxPasajes.addItem(Integer.toString(i));
		    			}
		    			precio=vuelo.getRutaDeVuelo().getCostoBaseTurista();
		    		}
		    		else  if (tipoAsiento.equals("Ejecutivo")) {
		    			for (int i = 1; i <=Math.min(vuelo.getCantAsientoEjecutivo(), cantidadRestante); i++) {
		    			    comboBoxPasajes.addItem(Integer.toString(i));
		    			    
		    			}
		    			precio=vuelo.getRutaDeVuelo().getCostoBaseEjecutivo();
		    		}
					
					cantidadAsientosActuales = comboBoxPasajes.getItemCount()-1;
					precio = precio * descuento;
					String precioTotal=String.valueOf(precio*pasajes+precioEquipajeE);
		        	lblPrecio.setText(precioTotal);
					

                }
				else {
					comboBoxPasajes.removeAllItems();

					if (tipoAsiento.equals("Turista")) {
		    			for (int i = 0; i <=vuelo.getCantAsientoTurista(); i++) {
		    			    comboBoxPasajes.addItem(Integer.toString(i));
		    			}
						precio=controladorVuelos.getRutaDeVuelo(nombreRuta).getCostoBaseTurista();
		    		}
		    		else  if (tipoAsiento.equals("Ejecutivo")) {
		    			for (int i = 0; i <=vuelo.getCantAsientoEjecutivo(); i++) {
		    			    comboBoxPasajes.addItem(Integer.toString(i));   
		    			}
						precio=controladorVuelos.getRutaDeVuelo(nombreRuta).getCostoBaseEjecutivo();
		    		}
					String precioTotal=String.valueOf(precio*pasajes+precioEquipajeE);
		        	lblPrecio.setText(precioTotal);
				}
            }
        });








		spinnerEquipajeExtra.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int unidadesEquipajeExtra = (int) spinnerEquipajeExtra.getValue();
				String nombreRuta = (String)comboBoxRutaDeVuelo.getSelectedItem();
				precioEquipajeE=unidadesEquipajeExtra*controladorVuelos.getRutaDeVuelo(nombreRuta).getCostoEquipajeExtra();
				String precioTotal=String.valueOf(precio*pasajes+precioEquipajeE);
		        lblPrecio.setText(precioTotal);
				
				
            }
        });







	
		btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = (String)comboBoxCliente.getSelectedItem();
                String vuelo = (String)comboBoxVuelo.getSelectedItem();
                String tipoAsiento = (String)comboBoxTipoAsiento.getSelectedItem();
                Integer unidadesEquipajeExtra = (Integer) spinnerEquipajeExtra.getValue();
                double costoFinal = precio*pasajes+precioEquipajeE;

				DtFecha fechaActual= new DtFecha();
                EnumAsiento tipoAsientoE = EnumAsiento.fromString(tipoAsiento);
				Map<String, String> personas=new HashMap<>();


				for (int i = 0; i < table.getRowCount(); i++) {
					personas.put(table.getValueAt(i,  0).toString(), table.getValueAt(i,  1).toString());
				}
				boolean paqC = paqueteComprado==null?false : true;
				
				
                try {
                    controladorVuelos.altaReserva(cliente, vuelo, tipoAsientoE, unidadesEquipajeExtra, pasajes, fechaActual, paqC, personas);
                    dispose();
                } catch (SetException err) {
                    String mensajeError = "Se encontraron errores: \n";
                    for (String mErr : err.getErrorSet()) {
                        mensajeError+=mErr +"\n";
                    }
                    JOptionPane.showMessageDialog(contentPane ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
                }   

            }
        });



		comboBoxAerolinea.addItemListener((ItemEvent e) -> {
		    if (e.getStateChange() == ItemEvent.SELECTED) { 
		        comboBoxRutaDeVuelo.removeAllItems();
		        comboBoxVuelo.removeAllItems();
				if (comboBoxCliente.getSelectedItem()!=null && comboBoxTipoAsiento.getSelectedItem()!=null){
					boolean rb =calcularPaqueteDisponible((String)comboBoxCliente.getSelectedItem(),  (String)comboBoxRutaDeVuelo.getSelectedItem(),  (String)comboBoxTipoAsiento.getSelectedItem());
					rdbtnPaquete.setVisible(rb);
					if (rb==false){
						rdbtnPaquete.setSelected(rb);
					}
				}
		        String aerolineaSeleccionada = (String) comboBoxAerolinea.getSelectedItem();
		        for (String nombre : controladorVuelos.getRutasDeVueloAceptadas(aerolineaSeleccionada).keySet()) {
		            comboBoxRutaDeVuelo.addItem(nombre);
		        }
		    }
		});

		comboBoxRutaDeVuelo.addItemListener((ItemEvent e) -> {
		    if (e.getStateChange() == ItemEvent.SELECTED) { 
		        comboBoxVuelo.removeAllItems(); 
                int unidadesEquipajeExtra = (int) spinnerEquipajeExtra.getValue();
				String rutaNombre = (String)comboBoxRutaDeVuelo.getSelectedItem();
				DtFecha fechaActual = new DtFecha();
				if (comboBoxCliente.getSelectedItem()!=null){
					boolean rb =calcularPaqueteDisponible((String)comboBoxCliente.getSelectedItem(),  rutaNombre,  (String)comboBoxTipoAsiento.getSelectedItem());
					rdbtnPaquete.setVisible(rb);
					if (rb==false){
						rdbtnPaquete.setSelected(rb);
					}
				}
		        String rutaDeVueloSeleccionada = (String) comboBoxRutaDeVuelo.getSelectedItem();
		        for (Vuelo v : controladorVuelos.getRutaDeVuelo(rutaDeVueloSeleccionada).getVuelos().values()) {
					if (v.getFecha().compararFechas(fechaActual)!=-1){  
		            	comboBoxVuelo.addItem(v.getNombre());
					}
		        }
				if (comboBoxTipoAsiento.getSelectedItem().equals("Turista")){
					precio=controladorVuelos.getRutaDeVuelo(rutaNombre).getCostoBaseTurista();
				}else {
					precio=controladorVuelos.getRutaDeVuelo(rutaNombre).getCostoBaseEjecutivo();
				}
				precioEquipajeE=unidadesEquipajeExtra*controladorVuelos.getRutaDeVuelo(rutaDeVueloSeleccionada).getCostoEquipajeExtra();
				String precioTotal=String.valueOf(precio*pasajes+precioEquipajeE);
		        lblPrecio.setText(precioTotal);
		    }
		});
		
		comboBoxVuelo.addItemListener((ItemEvent e) -> {
			comboBoxPasajes.removeAllItems();
		    if (e.getStateChange() == ItemEvent.SELECTED) { 
				String vueloNombre = (String)comboBoxVuelo.getSelectedItem(); 
				String tipoAsiento = (String)comboBoxTipoAsiento.getSelectedItem();
				Vuelo vuelo = controladorVuelos.getVuelo(vueloNombre);
				RutaDeVuelo rdv = vuelo.getRutaDeVuelo();
				if (vueloNombre != null && !vueloNombre.equals("") ) {
					
					if (!rdbtnPaquete.isSelected()){
						if (tipoAsiento.equals("Turista")) {
							for (int i = 0; i <= vuelo.getCantAsientoTurista(); i++) {
								comboBoxPasajes.addItem(Integer.toString(i));
							}
						}
						else  if (tipoAsiento.equals("Ejecutivo")) {
							for (int i = 0; i <= vuelo.getCantAsientoEjecutivo(); i++) {
								comboBoxPasajes.addItem(Integer.toString(i));
							}
						}

					}else {
						if (tipoAsiento.equals("Turista")) {
							for (int i = 0; i <= Math.min(vuelo.getCantAsientoTurista(), cantidadAsientosActuales); i++) {
								comboBoxPasajes.addItem(Integer.toString(i));
							}
						}
						else  if (tipoAsiento.equals("Ejecutivo")) {
							for (int i = 0; i <= Math.min(vuelo.getCantAsientoEjecutivo(), cantidadAsientosActuales); i++) {
								comboBoxPasajes.addItem(Integer.toString(i));
							}
						}
					}
					
					
					lblInfoVuelo.setText(
						"Vuelo: " + vueloNombre + " Ciudad origen: " + rdv.getOrigen().getNombre() + " Ciudad destino: " + rdv.getDestino().getNombre() + " Fecha: " +
						vuelo.getFecha().toString() + " Duracion: " + vuelo.getDuracion().toString() + " Asientos Turista: " + vuelo.getCantAsientoTurista() + 
						" Asientos Ejecutivo: " + vuelo.getCantAsientoEjecutivo());
		    	}
				cantidadAsientosActuales = comboBoxPasajes.getItemCount()-1;
				comboBoxTipoAsiento.setSelectedItem(comboBoxTipoAsiento.getSelectedItem());
			}
		});

	
		comboBoxTipoAsiento.addItemListener((ItemEvent e) -> {
		    if (e.getStateChange() == ItemEvent.SELECTED) { 
		    	comboBoxPasajes.removeAllItems();
		    	
		    	String vueloNombre = (String)comboBoxVuelo.getSelectedItem(); 
		    	String tipoAsiento = (String)comboBoxTipoAsiento.getSelectedItem();
		        String rutaNombre = (String)comboBoxRutaDeVuelo.getSelectedItem();

		    	if (vueloNombre != null && !vueloNombre.equals("")) {
		    		if (comboBoxCliente.getSelectedItem()!=null && comboBoxTipoAsiento.getSelectedItem()!=null){
					boolean rb =calcularPaqueteDisponible((String)comboBoxCliente.getSelectedItem(),  (String)comboBoxRutaDeVuelo.getSelectedItem(),  (String)comboBoxTipoAsiento.getSelectedItem());
					rdbtnPaquete.setVisible(rb);
					if (rb==false){
						rdbtnPaquete.setSelected(rb);
					}
					}	
		    		Vuelo vuelo = controladorVuelos.getVuelo(vueloNombre);
					if (rdbtnPaquete.isSelected()) {
    					for (ActionListener al : rdbtnPaquete.getActionListeners()) {
        					al.actionPerformed(new ActionEvent(rdbtnPaquete,  ActionEvent.ACTION_PERFORMED,  null));
    
						}
					}
					else {
						if (tipoAsiento.equals("Turista")) {
							for (int i = 0; i <= vuelo.getCantAsientoTurista(); i++) {
								comboBoxPasajes.addItem(Integer.toString(i));
								precio=controladorVuelos.getRutaDeVuelo(rutaNombre).getCostoBaseTurista();

							}

						}
						else  if (tipoAsiento.equals("Ejecutivo")) {
							for (int i = 0; i <= vuelo.getCantAsientoEjecutivo(); i++) {
								comboBoxPasajes.addItem(Integer.toString(i));
								precio=controladorVuelos.getRutaDeVuelo(rutaNombre).getCostoBaseEjecutivo();

							}
						}
					}
					String precioTotal=String.valueOf(precio*pasajes+precioEquipajeE);
					lblPrecio.setText(precioTotal);
		    		
		    	}

		    	
		    }
		});
		
		comboBoxPasajes.addItemListener((ItemEvent e) -> {
		    if (e.getStateChange() == ItemEvent.SELECTED) { 
		    	
		    	String nombreCliente = (String)comboBoxCliente.getSelectedItem();
				Cliente cliente = controladorUsuarios.getCliente(nombreCliente);
		    	
		    	
		    	
		    	
		    	String spasajes = (String) comboBoxPasajes.getSelectedItem();
		    	
		        if (spasajes != null) {
					tablaPersonas.setRowCount(0);

		        	
		        	pasajes = Integer.parseInt(spasajes);
					String precioTotal=String.valueOf(precio*pasajes+precioEquipajeE);
		        	lblPrecio.setText(precioTotal);
		        	for (int i = 0; i < pasajes; i++) {		        		
		        		tablaPersonas.addRow(new Object[]{"",  ""});
		        	}

		        }  	
				
		    }
		});
		
    }
	

	private boolean calcularPaqueteDisponible(String nombreCliente,  String nombreRuta,  String tipoAsiento){
		IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();

		Cliente cliente = controladorUsuarios.getCliente(nombreCliente);
		List<CompraPaquete> paquetes =  cliente.getComprasDePaquetes();

		DtFecha fechaActual = new DtFecha();
		for (CompraPaquete cp : paquetes){
			
			for (PaqueteRuta pr :cp.getPaqueteAsociado().getPaquetesRuta()){

				if ( pr.getRutaAsociada().getNombre().equals(nombreRuta) && cp.getRestantes().get(nombreRuta)>0 && pr.getTipoAsiento().equals(EnumAsiento.fromString(tipoAsiento)) && cp.getFechaVencimiento().compararFechas(fechaActual) != -1){
					return true;
				}  
			}
			
		}
		return false;
	}
}
