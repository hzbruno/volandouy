package volandouy.presentacion;
import volandouy.logica.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;



public class ConsultaPaqueteInternal extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtDuracion;
	private JTextField txtDescuento;
	private JTextField txtCosto;
	private JTextField txtFecha;
	private JTable tablePaquetes;


	public ConsultaPaqueteInternal(JDesktopPane desktopPane,  Paquete paqueteDefault) {
		IControladorUsuarios controladorUsuarios=Fabrica.getControladorUsuarios();
		IControladorVuelos controladorVuelos=Fabrica.getControladorVuelos();

		setTitle("Consultar Paquete");
        setBounds(100,  100,  558,  421);
        setClosable(true);
		setResizable(false);


		JPanel contentPane = new JPanel();
		contentPane.setBounds(0,  0,  549,  380);
		getContentPane().add(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20,  93,  75,  14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(20,  134,  75,  14);
		contentPane.add(lblDescripcion);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(20,  181,  75,  14);
		contentPane.add(lblDuracion);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(20,  223,  75,  14);
		contentPane.add(lblDescuento);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setBounds(20,  262,  75,  14);
		contentPane.add(lblCosto);
		
		JLabel lblFechaAlta = new JLabel("Fecha de Alta");
		lblFechaAlta.setBounds(20,  301,  75,  14);
		contentPane.add(lblFechaAlta);

		JLabel lblRutaDeVuelo = new JLabel("Rutas de Vuelo");
		lblRutaDeVuelo.setBounds(284,  93,  84,  14);
		contentPane.add(lblRutaDeVuelo);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(105,  90,  150,  20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(105,  131,  150,  20);
		contentPane.add(txtDescripcion);
		
		txtDuracion = new JTextField();
		txtDuracion.setEditable(false);
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(105,  178,  150,  20);
		contentPane.add(txtDuracion);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(105,  220,  150,  20);
		contentPane.add(txtDescuento);
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setColumns(10);
		txtCosto.setBounds(105,  259,  150,  20);
		contentPane.add(txtCosto);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(105,  298,  150,  20);
		contentPane.add(txtFecha);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(378,  93,  150,  100);
		contentPane.add(scrollPane);

		tablePaquetes = new JTable();
		scrollPane.setViewportView(tablePaquetes);
		
		JComboBox comboPaquetes = new JComboBox();
		comboPaquetes.setBounds(105,  29,  150,  31);
		for (String paquete:controladorVuelos.getPaquetes().keySet()){
			comboPaquetes.addItem(paquete);
		}
		contentPane.add(comboPaquetes);

		comboPaquetes.addActionListener((ActionEvent e) -> {
			String paquete = (String) comboPaquetes.getSelectedItem();
            Paquete paqueteActual = controladorVuelos.getPaquete(paquete);
            
            txtNombre.setText(paqueteActual.getNombre());
            txtDescripcion.setText(paqueteActual.getDescripcion());
            txtCosto.setText(String.valueOf(paqueteActual.getCosto()));
            txtDescuento.setText(String.valueOf(paqueteActual.getDescuento()));
            txtFecha.setText(paqueteActual.getFechaDeAlta().toString());
            txtDuracion.setText(String.valueOf(paqueteActual.getDuracionDias()));
            

            Set<PaqueteRuta> rutasDeVuelo = controladorVuelos.getPaquete(paqueteActual.getNombre()).getPaquetesRuta();

			String[] columnNames = {"Rutas de vuelo",  "Cantidad",  "Tipo de asiento"};
			Object[][] data = new Object[rutasDeVuelo.size()][3];

			int i = 0;
			for (PaqueteRuta pr : rutasDeVuelo) {
				data[i][0] = pr.getRutaAsociada().getNombre();
				data[i][1] = Integer.toString(pr.getCantidad());
				data[i][2] = String.valueOf(pr.getTipoAsiento());
				i++;
			}

			DefaultTableModel model = new DefaultTableModel(data,  columnNames) {
			@Override
				public boolean isCellEditable(int row,  int column) {
					return false; 
				}
			};
			tablePaquetes.getTableHeader().setReorderingAllowed(false);
			tablePaquetes.setModel(model);
					
			
		});
		
		
		JLabel lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setBounds(21,  37,  74,  14);
		contentPane.add(lblPaquetes);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(439,  346,  89,  23);
		contentPane.add(btnConsultar);
		
		btnConsultar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tablePaquetes.getSelectedRow();
				
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(desktopPane,  "Por favor,  seleccione un paquete.",  "Advertencia",  JOptionPane.WARNING_MESSAGE);
		            return;
		        }				
				String rutaDeVuelo = tablePaquetes.getValueAt(selectedRow,  0).toString();
				JInternalFrame frameConsultarRutaVuelo = new ConsultaRutaDeVueloInternal(desktopPane,  controladorVuelos.getRutaDeVuelo(rutaDeVuelo));
				desktopPane.add(frameConsultarRutaVuelo);
				frameConsultarRutaVuelo.toFront();
				frameConsultarRutaVuelo.setVisible(true);
			
			}
		});
		
		if (paqueteDefault != null){
            comboPaquetes.setSelectedItem(paqueteDefault.getNombre());

        }
		
	}	
}


