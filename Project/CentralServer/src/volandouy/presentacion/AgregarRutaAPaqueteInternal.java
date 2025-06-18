package volandouy.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import volandouy.datatypes.*;
import volandouy.excepciones.SetException;
import volandouy.logica.Aerolinea;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.ManUsuarios;
import volandouy.logica.Paquete;
import volandouy.logica.RutaDeVuelo;

public class AgregarRutaAPaqueteInternal extends JInternalFrame {

	private static final long serialVersionUID = 1L;


	public AgregarRutaAPaqueteInternal() {
		IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
		setBounds(100,  100,  330, 350);
		getContentPane().setLayout(null);

		setTitle("Agregar ruta de vuelo a paquete");
        setClosable(true);
        setBounds(100,  100,  330, 350);
		setResizable(false);
        getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,  0,  315,  315);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paquetes");
		lblNewLabel.setBounds(10,  11,  70,  14);
		panel.add(lblNewLabel);
		
		JComboBox comboPaquetes = new JComboBox();
		DtFecha fechaActual= new DtFecha();
        DtFecha fecha = new DtFecha();
		for (Paquete p : controladorVuelos.getPaquetes().values()) {
            fecha.setDia(fechaActual.getDia());
            fecha.setMes(fechaActual.getMes());
            fecha.setAnio(fechaActual.getAnio());
            fecha.sumarDias(p.getDuracionDias());
            if (!p.getComprado() && !(fecha.compararFechas(fechaActual)==-1 )) {
			    comboPaquetes.addItem(p.getNombre());
                
            }
		}

		comboPaquetes.setBounds(120,  11,  150,  22);
		panel.add(comboPaquetes);
		
		JComboBox comboAerolineas = new JComboBox();
		for (String aerolineas : controladorUsuarios.getAerolineas().keySet()) {
			comboAerolineas.addItem(aerolineas);
		}
		comboAerolineas.setBounds(120,  44,  150,  22);
		panel.add(comboAerolineas);
		
		JLabel lblAerolineas = new JLabel("Aerolineas");
		lblAerolineas.setBounds(10,  44,  70,  14);
		panel.add(lblAerolineas);

                JSpinner spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
		spinnerCantidad.setBounds(120,  110,  41,  20);
		panel.add(spinnerCantidad);

		
		JComboBox comboRutas = new JComboBox();
                
		comboAerolineas.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboRutas.removeAllItems();	        
	        String aerolineaSeleccionada = (String) comboAerolineas.getSelectedItem();	      
	        if (aerolineaSeleccionada != null) {	           
	            Aerolinea aerolinea = ManUsuarios.getInstancia().getAerolinea(aerolineaSeleccionada);	            	            
	            if (aerolinea != null) {	                
	                Map<String,  RutaDeVuelo> rutasDeVuelo = aerolinea.getRutasDeVueloAceptadas();
	                if (rutasDeVuelo != null) {
	                    for (String rutaNombre : rutasDeVuelo.keySet()) {
	                    	comboRutas.addItem(rutaNombre);
	                    }
	                }
	            }
	        }
	    }
	});
		
		
		comboRutas.setBounds(120,  77,  150,  22);
		panel.add(comboRutas);
		
		JLabel lblRutasDeVuelo = new JLabel("Rutas de Vuelo");
		lblRutasDeVuelo.setBounds(10,  77,  100,  14);
		panel.add(lblRutasDeVuelo);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10,  116,  100,  14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo Asiento");
		lblNewLabel_1_1.setBounds(10,  145,  100,  14);
		panel.add(lblNewLabel_1_1);
		
		JComboBox comboAsientos = new JComboBox();
		comboAsientos.addItem("Turista");
		comboAsientos.addItem("Ejecutivo");
		comboAsientos.setBounds(120,  141,  150,  22);
		panel.add(comboAsientos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(216,  281,  89,  23);
		panel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String paquete = (String)comboPaquetes.getSelectedItem();
				String ruta = (String)comboRutas.getSelectedItem();
				Integer cantidad = (Integer) spinnerCantidad.getValue();
				String asiento = (String)comboAsientos.getSelectedItem();
				EnumAsiento asientos = EnumAsiento.ejecutivo;
				if (asiento.equals("Turista")) {
					asientos = EnumAsiento.turista;
				}
				
				
				try {
					controladorVuelos.agregarRutaVueloPaquete(paquete,  ruta,  cantidad,  asientos);
					dispose();
				}
				catch(SetException err) {
                    String mensajeError = "Se encontraron errores: \n";
                    for (String mErr : err.getErrorSet()) {
                        mensajeError+=mErr +"\n";
                    }
                    JOptionPane.showMessageDialog(panel ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
				}


			}
		});
		btnAceptar.setBounds(108,  281,  89,  23);
		panel.add(btnAceptar);
		

	}
}
