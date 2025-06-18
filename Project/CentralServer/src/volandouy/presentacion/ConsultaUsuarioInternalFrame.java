package volandouy.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import volandouy.logica.Aerolinea;
import volandouy.logica.Cliente;
import volandouy.logica.CompraPaquete;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.Reserva;
import volandouy.logica.RutaDeVuelo;
import volandouy.logica.Usuario;

public class ConsultaUsuarioInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable tableUsuarios;
    private JPanel panelAerolinea;
    private JPanel panelCliente;
    private JTable tableAerolineaRutasDeVuelo;
    private JTable tableClienteReservas;
    private JTable tableClientePaquetes;
	private Cliente clienteSeleccionado;
	private Aerolinea aerolineaSeleccionada;
    

	public ConsultaUsuarioInternalFrame(JDesktopPane desktopPane) {
		
		IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		
		setTitle("Consulta Usuario");
        setBounds(100,  100,  678,  560);
        setClosable(true);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JScrollPane scrollPaneUsuarios = new JScrollPane();
		scrollPaneUsuarios.setBounds(15,  5,  627,  137);
		contentPane.add(scrollPaneUsuarios);
		
		        tableUsuarios = new JTable();
		        scrollPaneUsuarios.setViewportView(tableUsuarios);
		        tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panelCliente = new JPanel();
		panelCliente.setBounds(15,  176,  627,  342);
		contentPane.add(panelCliente);
		panelCliente.setLayout(null);
		
		JTextArea lblInformacionCliente = new JTextArea("");
		lblInformacionCliente.setBounds(40,  30,  150,  240);
		panelCliente.add(lblInformacionCliente);
		lblInformacionCliente.setEditable(false);
        lblInformacionCliente.setOpaque(false);
		lblInformacionCliente.setLineWrap(true);
		lblInformacionCliente.setWrapStyleWord(true);

		JScrollPane scrollPaneClienteReservas = new JScrollPane();
		scrollPaneClienteReservas.setBounds(230,  30,  150,  180);
		panelCliente.add(scrollPaneClienteReservas);
		
		tableClienteReservas = new JTable();
		scrollPaneClienteReservas.setViewportView(tableClienteReservas);
		
		JScrollPane scrollPaneClientePaquetes = new JScrollPane();
		scrollPaneClientePaquetes.setBounds(420,  30,  150,  180);
		panelCliente.add(scrollPaneClientePaquetes);
		
		tableClientePaquetes = new JTable();
		scrollPaneClientePaquetes.setViewportView(tableClientePaquetes);
		
		JButton btnConsultarReserva = new JButton("Consultar");
		btnConsultarReserva.setBounds(230,  221,  150,  23);
		panelCliente.add(btnConsultarReserva);
		
		JButton btnConsultarPaquete = new JButton("Consultar");
		btnConsultarPaquete.setBounds(420,  221,  150,  23);
		panelCliente.add(btnConsultarPaquete);
		
		panelAerolinea = new JPanel();
		panelAerolinea.setBounds(15,  176,  627,  342);
		contentPane.add(panelAerolinea);
		panelAerolinea.setLayout(null);
		
		JTextArea lblInformacionAerolinea = new JTextArea("");
		lblInformacionAerolinea.setBounds(40,  30,  150,  240);
		panelAerolinea.add(lblInformacionAerolinea);
		lblInformacionAerolinea.setEditable(false);
        lblInformacionAerolinea.setOpaque(false);
		lblInformacionAerolinea.setLineWrap(true);
		lblInformacionAerolinea.setWrapStyleWord(true);
		
		JScrollPane scrollPaneAerolineaRutasDeVuelo = new JScrollPane();
		scrollPaneAerolineaRutasDeVuelo.setBounds(230,  30,  150,  180);
		panelAerolinea.add(scrollPaneAerolineaRutasDeVuelo);
		
		tableAerolineaRutasDeVuelo = new JTable();
		tableAerolineaRutasDeVuelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneAerolineaRutasDeVuelo.setViewportView(tableAerolineaRutasDeVuelo);
		
		JButton btnConsultarRutaDeVuelo = new JButton("Consultar");
		btnConsultarRutaDeVuelo.setBounds(230,  221,  150,  23);
		panelAerolinea.add(btnConsultarRutaDeVuelo);

		panelCliente.setVisible(false);
		panelAerolinea.setVisible(false);

		tableUsuarios = new JTable();
        scrollPaneUsuarios.setViewportView(tableUsuarios);
        tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableUsuarios.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("deprecation")
			@Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableUsuarios.getSelectedRow();
                if (selectedRow != -1) {
                    String nickname = tableUsuarios.getValueAt(selectedRow,  0).toString();
                    Usuario usr = controladorUsuarios.getUsuario(nickname);

                    if (usr instanceof Cliente) {
                        Cliente cliente = (Cliente) usr;
						clienteSeleccionado = cliente;

                        lblInformacionCliente.setText(
						"Nickname: " + cliente.getNickname() + "\n" +
						"Nombre: " + cliente.getNombre() + "\n" +
						"Correo: " + cliente.getCorreo() + "\n" +
						"Apellido: " + cliente.getApellido() + "\n" +
						"Fecha de Nacimiento: " + cliente.getFechaDeNacimiento().toString() + "\n" +
						"Nacionalidad: " + cliente.getNacionalidad() + "\n" +
						"Tipo de documento: " + cliente.getTipoDocumento().toString() + "\n" +
						"Numero de documento: " + cliente.getNumeroDocumento());

                        panelCliente.setVisible(true);
                        panelAerolinea.setVisible(false);

						cargarDatosReservas(cliente);
						cargarDatosCompraPaquete(cliente);
						

                    } else  if (usr instanceof Aerolinea) {
                        Aerolinea aerolinea = (Aerolinea) usr;
						aerolineaSeleccionada = aerolinea;
						
						lblInformacionAerolinea.setText(
						"Nickname: " + aerolinea.getNickname() + "\n" +
						"Nombre: " + aerolinea.getNombre() + "\n" +
						"Correo: " + aerolinea.getCorreo() + "\n" +
						"Sitio Web: " + aerolinea.getSitioWeb() + "\n" +
						"Descripcion:" + aerolinea.getDescripcionGeneral());

                        panelCliente.setVisible(false);
                        panelAerolinea.setVisible(true);

						cargarDatosRutasDeVuelo(aerolinea);
                    }
                }
            }
        });
		
		btnConsultarRutaDeVuelo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tableAerolineaRutasDeVuelo.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(desktopPane,  "Por favor,  seleccione una ruta de vuelo.",  "Advertencia",  JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        String rutaDeVuelo = tableAerolineaRutasDeVuelo.getValueAt(selectedRow,  0).toString();
		        JInternalFrame frameConsultarRutaVuelo = new ConsultaRutaDeVueloInternal(desktopPane,  controladorVuelos.getRutaDeVuelo(rutaDeVuelo));
		        frameConsultarRutaVuelo.setVisible(true);
		        desktopPane.add(frameConsultarRutaVuelo);
		        frameConsultarRutaVuelo.toFront();
		    }
		});

		btnConsultarPaquete.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tableClientePaquetes.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(desktopPane,  "Por favor,  seleccione un paquete.",  "Advertencia",  JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        String paquete = tableClientePaquetes.getValueAt(selectedRow,  0).toString();   
		        JInternalFrame frameConsultarPaquete = new ConsultaPaqueteInternal(desktopPane,  controladorVuelos.getPaquete(paquete));
		        frameConsultarPaquete.setVisible(true);
		        desktopPane.add(frameConsultarPaquete);
		        frameConsultarPaquete.toFront();
		    }
		});

		btnConsultarReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClienteReservas.getSelectedRow();
				
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(desktopPane,  "Por favor,  seleccione una reserva.",  "Advertencia",  JOptionPane.WARNING_MESSAGE);
		            return;
		        }
				
				String vuelo = tableClienteReservas.getValueAt(selectedRow,  0).toString();
				String idReserva = tableClienteReservas.getValueAt(selectedRow,  1).toString();    
				String cliente = tableUsuarios.getValueAt(tableUsuarios.getSelectedRow(),  0).toString();   
				for (Reserva r : controladorUsuarios.getCliente(cliente).getReservas()) {
					if (r.getId()==Integer.parseInt(idReserva)) {
						JInternalFrame frameConsultarVuelo = new ConsultaVueloInternalFrame(null, r);
						frameConsultarVuelo.setVisible(true);
						desktopPane.add(frameConsultarVuelo);
						frameConsultarVuelo.toFront();
						break;	
					}
				}
			}
		});

        cargarDatosUsuarios();
	}


	private void cargarDatosUsuarios() {
		IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		Map<String,  Usuario> usuarios = controladorUsuarios.getUsuarios();

		String[] columnNames = {"Nickname"};
		Object[][] data = new Object[usuarios.size()][1];

		int i = 0;
		for (String clave : usuarios.keySet()) {
			data[i][0] = clave;
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(data,  columnNames) {
			@Override
			public boolean isCellEditable(int row,  int column) {
				return false; 
			}
		};

		tableUsuarios.setModel(model);
	}

	private void cargarDatosReservas(Cliente cliente) {
		IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		List<Reserva> reservas = cliente.getReservas();

		String[] columnNames = {"Reservas",  "Identificador"};
		Object[][] data = new Object[reservas.size()][2];

		int i = 0;
		for (Reserva r : reservas) {
			data[i][0] = r.getVuelo().getNombre();
			data[i][1] = Integer.toString(r.getId());
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(data,  columnNames) {
			@Override
			public boolean isCellEditable(int row,  int column) {
				return false; 
			}
		};
		
		tableClienteReservas.getTableHeader().setReorderingAllowed(false);
		tableClienteReservas.setModel(model);
	}
	
	private void cargarDatosCompraPaquete(Cliente cliente) {
		IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		List<CompraPaquete> comprasDePaquete = cliente.getComprasDePaquetes();

		String[] columnNames = {"Compras De Paquete",  "Fecha de Compra"};
		Object[][] data = new Object[comprasDePaquete.size()][2];

		int i = 0;
		for (CompraPaquete cp : comprasDePaquete) {
			data[i][0] = cp.getPaqueteAsociado().getNombre();
			data[i][1] = cp.getFechaDeCompra();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(data,  columnNames) {
			@Override
			public boolean isCellEditable(int row,  int column) {
				return false;  
			}
		};

		tableClientePaquetes.getTableHeader().setReorderingAllowed(false);
		tableClientePaquetes.setModel(model);

	}

	private void cargarDatosRutasDeVuelo(Aerolinea aerolinea) {
		IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		Map<String,  RutaDeVuelo> rutasDeVuelo= aerolinea.getRutasDeVuelo();

		String[] columnNames = {"Rutas de vuelo",  "Ciudad Origen",  "Ciudad Destino"};
		Object[][] data = new Object[rutasDeVuelo.size()][3];

		int i = 0;
		for (RutaDeVuelo rv : rutasDeVuelo.values()) {
			data[i][0] = rv.getNombre();
			data[i][1] = rv.getOrigen().getNombre();
			data[i][2] = rv.getDestino().getNombre();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(data,  columnNames) {
			@Override
			public boolean isCellEditable(int row,  int column) {
				return false;  
			}
		};
		tableAerolineaRutasDeVuelo.getTableHeader().setReorderingAllowed(false);
		tableAerolineaRutasDeVuelo.setModel(model);
	}

	




}

