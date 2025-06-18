package volandouy.presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import volandouy.logica.Aerolinea;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.ManUsuarios;
import volandouy.logica.RutaDeVuelo;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class FinalizarRutaDeVueloInternal extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalizarRutaDeVueloInternal frame = new FinalizarRutaDeVueloInternal();
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
	public FinalizarRutaDeVueloInternal() {
		
		setClosable(true);
		
		
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		setBounds(100, 100, 320, 143);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 307, 110);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox<String> cBoxAerolinea = new JComboBox();
		cBoxAerolinea.setBounds(141, 11, 160, 22);
		panel.add(cBoxAerolinea);
		for (String nickname : controladorUsuarios.getAerolineas().keySet()) {
			 cBoxAerolinea.addItem(nickname);
	      }
		
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		lblAerolinea.setBounds(10, 15, 110, 14);
		panel.add(lblAerolinea);
		
		JLabel lblRutaDeVuelo = new JLabel("Ruta de Vuelo");
		lblRutaDeVuelo.setBounds(10, 44, 110, 14);
		panel.add(lblRutaDeVuelo);
		
		JComboBox<String> cBoxRuta = new JComboBox();
		cBoxRuta.setBounds(141, 40, 160, 22);
		panel.add(cBoxRuta);
		
		cBoxAerolinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cBoxRuta.removeAllItems();
                String aerolineaSeleccionada = (String) cBoxAerolinea.getSelectedItem();
                if (aerolineaSeleccionada != null) {
                    Aerolinea aerolinea = ManUsuarios.getInstancia().getAerolinea(aerolineaSeleccionada);
                    if (aerolinea != null) {
                        Map<String,  RutaDeVuelo> rutasDeVuelo = aerolinea.getRutasDeVueloAceptadas();
                        if (rutasDeVuelo != null) {
                            for (RutaDeVuelo ruta : rutasDeVuelo.values()) {
                            	if(ruta.noTieneVuelosVigentes() && !controladorVuelos.estaRutaEnAlgunPaquete(ruta.getNombre()))cBoxRuta.addItem(ruta.getNombre());
                            }
                        }
                    }
                }
            }
        });
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorVuelos.finalizarRuta((String)cBoxRuta.getSelectedItem());
				dispose();
			}
		});
		btnNewButton.setBounds(217, 73, 86, 22);
		panel.add(btnNewButton);

	}
}
