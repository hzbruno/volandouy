package volandouy.presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import volandouy.datatypes.*;
import volandouy.excepciones.SetException;
import volandouy.logica.Aerolinea;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.ManUsuarios;
import volandouy.logica.RutaDeVuelo;

public class AceptarRutaInternal extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceptarRutaInternal frame = new AceptarRutaInternal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AceptarRutaInternal() {
		setClosable(true);
		
		
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        
		setBounds(100,  100,  325,  170);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,  0,  315,  140);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(10,  11,  110,  14);
		panel.add(lblAerolinea);
		
		JComboBox<String> cBoxAerolinea = new JComboBox();
		cBoxAerolinea.setBounds(141,  7,  160,  22);
		panel.add(cBoxAerolinea);
		 for (String nickname : controladorUsuarios.getAerolineas().keySet()) {
			 cBoxAerolinea.addItem(nickname);
	      }
		
		JComboBox cBoxRuta = new JComboBox();
		cBoxRuta.setBounds(141,  36,  160,  22);
		panel.add(cBoxRuta);
			
		cBoxAerolinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cBoxRuta.removeAllItems();
                String aerolineaSeleccionada = (String) cBoxAerolinea.getSelectedItem();
                if (aerolineaSeleccionada != null) {
                    Aerolinea aerolinea = ManUsuarios.getInstancia().getAerolinea(aerolineaSeleccionada);
                    if (aerolinea != null) {
                        Map<String,  RutaDeVuelo> rutasDeVuelo = aerolinea.getRutasDeVueloIngresadas();
                        if (rutasDeVuelo != null) {
                            for (String rutaNombre : rutasDeVuelo.keySet()) {
                            	cBoxRuta.addItem(rutaNombre);
                            }
                        }
                    }
                }
            }
        });
		
		
		

		JLabel lblRutaDeVuelo = new JLabel("Ruta de Vuelo");
		lblRutaDeVuelo.setBounds(10,  40,  110,  14);
		panel.add(lblRutaDeVuelo);
		
		JComboBox<EnumEstado> cBoxEstado = new JComboBox();
		cBoxEstado.setBounds(141,  69,  160,  22);
		panel.add(cBoxEstado);
		cBoxEstado.addItem(EnumEstado.CONFIRMADA);
		cBoxEstado.addItem(EnumEstado.RECHAZADA);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10,  73,  110,  14);
		panel.add(lblEstado);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruta = (String) cBoxRuta.getSelectedItem();
				EnumEstado est = (EnumEstado) cBoxEstado.getSelectedItem();
				try {
				controladorVuelos.setEstadoRuta(ruta,  est);
				dispose();
				}
				catch (SetException err) {
	                String mensajeError = "Se encontraron errores: \n";
	                for (String mErr : err.getErrorSet()) {
	                    mensajeError+=mErr +"\n";
	                }
	                JOptionPane.showMessageDialog(panel ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
	            } 
				
			}
		});
		btnAceptar.setBounds(212,  102,  89,  23);
		panel.add(btnAceptar);

	}
}
