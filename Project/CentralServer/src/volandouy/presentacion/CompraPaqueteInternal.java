package volandouy.presentacion;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import volandouy.datatypes.*;
import volandouy.excepciones.SetException;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.Paquete;

public class CompraPaqueteInternal extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	
	public CompraPaqueteInternal() {
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();

        setTitle("Comprar paquete");
        setClosable(true);
		setBounds(100,  100,  310,  300);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0,  0,  300,  300);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox comboPaquetes = new JComboBox();
        DtFecha fechaActual= new DtFecha();
        DtFecha fecha = new DtFecha();
		for (Paquete p : controladorVuelos.getPaquetes().values()) {
            fecha.setDia(fechaActual.getDia());
            fecha.setMes(fechaActual.getMes());
            fecha.setAnio(fechaActual.getAnio());
            fecha.sumarDias(p.getDuracionDias());
            if (!(p.getPaquetesRuta().isEmpty()) && !(fecha.compararFechas(fechaActual)==-1 )) {
			    comboPaquetes.addItem(p.getNombre());
                
            }
		}
		comboPaquetes.setSelectedItem(-1);
		comboPaquetes.setBounds(119,  11,  150,  31);
		panel.add(comboPaquetes);
		
		JLabel lblNewLabel = new JLabel("Paquetes");
		lblNewLabel.setBounds(32,  19,  46,  14);
		panel.add(lblNewLabel);
		
		JComboBox comboClientes = new JComboBox();
		for (String clientes : controladorUsuarios.getClientes().keySet()) {
			comboClientes.addItem(clientes);
		}
		comboClientes.setSelectedItem(-1);
		comboClientes.setBounds(119,  115,  150,  31);
		panel.add(comboClientes);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(32,  68,  60,  14);
		panel.add(lblCosto);

		JLabel lblPrecio = new JLabel("---");
		lblPrecio.setBounds(120,  68,  120,  14);
		panel.add(lblPrecio);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(32,  123,  46,  14);
		panel.add(lblClientes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(201,  200,  89,  23);
		panel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
                try {
                    controladorVuelos.altaCompraPaquete((String)comboPaquetes.getSelectedItem(), (String)comboClientes.getSelectedItem(),  fechaActual);
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
		
		comboPaquetes.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String paqueteNombre = (String) comboPaquetes.getSelectedItem();
			lblPrecio.setText(Double.toString(controladorVuelos.getPaquete(paqueteNombre).getCosto()));


		}
	});



		btnAceptar.setBounds(96,  200,  89,  23);
		panel.add(btnAceptar);

	}
}
