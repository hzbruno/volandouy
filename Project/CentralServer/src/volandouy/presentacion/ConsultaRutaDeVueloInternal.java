package volandouy.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.table.DefaultTableModel;
import volandouy.logica.Aerolinea;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.ManUsuarios;
import volandouy.logica.RutaDeVuelo;
import volandouy.logica.Vuelo;

public class ConsultaRutaDeVueloInternal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtCostoTurista;
    private JTextField txtCostoEjecutivo;
    private JTextField txtCostoEquipajeExtra;
    private JTextField txtHora;
    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JTextArea txtAreaDescripcion;
    private JComboBox comboBoxAerolinea;
    private JComboBox comboBoxRutasVuelo;
    private JTable tableCategorias;
    private JTable tableV;
    private DefaultTableModel tablaCategorias;
    private Vuelo vuelo;
    private JTextField txtEstado;


    public ConsultaRutaDeVueloInternal(JDesktopPane desktopPane, RutaDeVuelo rutaDefault) {

        this.vuelo = null;
        
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();

        setTitle("Consulta Ruta de Vuelo");
        setBounds(100,  100,  600,  450);
        setClosable(true);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,  0,  584,  411);
        contentPane.add(panel);
        panel.setLayout(null);

        comboBoxAerolinea = new JComboBox<>();
        comboBoxAerolinea.setBounds(96,  11,  168,  22);
        for (String aerolineas : controladorUsuarios.getAerolineas().keySet()) {
            comboBoxAerolinea.addItem(aerolineas);
        }
        panel.add(comboBoxAerolinea);

        JLabel lblAerolinea = new JLabel("Aerolinea");
        lblAerolinea.setBounds(10,  15,  65,  14);
        panel.add(lblAerolinea);

        comboBoxRutasVuelo = new JComboBox<>();
        comboBoxRutasVuelo.setBounds(96,  44,  168,  22);
        comboBoxAerolinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxRutasVuelo.removeAllItems();
                String aerolineaSeleccionada = (String) comboBoxAerolinea.getSelectedItem();
                if (aerolineaSeleccionada != null) {
                    Aerolinea aerolinea = ManUsuarios.getInstancia().getAerolinea(aerolineaSeleccionada);
                    if (aerolinea != null) {
                        Map<String,  RutaDeVuelo> rutasDeVuelo = aerolinea.getRutasDeVuelo();
                        if (rutasDeVuelo != null) {
                            for (String rutaNombre : rutasDeVuelo.keySet()) {
                                comboBoxRutasVuelo.addItem(rutaNombre);
                            }
                        }
                    }
                }
            }
        });
        panel.add(comboBoxRutasVuelo);

        JLabel lblRutasDeVuelo = new JLabel("Rutas de Vuelo");
        lblRutasDeVuelo.setBounds(10,  48,  89,  14);
        panel.add(lblRutasDeVuelo);

        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setColumns(10);
        txtNombre.setBounds(96,  99,  168,  20);
        panel.add(txtNombre);
        
        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setBounds(10, 342, 123, 14);
        panel.add(lblEstado);
        
        txtEstado = new JTextField();
        txtEstado.setText("..");
        txtEstado.setEditable(false);
        txtEstado.setColumns(10);
        txtEstado.setBounds(96, 339, 168, 20);
        panel.add(txtEstado);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10,  102,  46,  14);
        panel.add(lblNombre);

        txtAreaDescripcion = new JTextArea();
        txtAreaDescripcion.setBounds(96,  130,  168,  80);
        txtAreaDescripcion.setEditable(false);
        txtAreaDescripcion.setOpaque(false);
        txtAreaDescripcion.setLineWrap(true);
        txtAreaDescripcion.setWrapStyleWord(true);
        panel.add(txtAreaDescripcion);

        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setBounds(10,  135,  77,  14);
        panel.add(lblDescripcion);


        JLabel lblCostoTurista = new JLabel("Costo turista");
        lblCostoTurista.setBounds(10,  224,  123,  14);
        panel.add(lblCostoTurista);

        txtCostoTurista = new JTextField();
        txtCostoTurista.setEditable(false);
        txtCostoTurista.setColumns(10);
        txtCostoTurista.setBounds(96,  221,  168,  20);
        panel.add(txtCostoTurista);

        txtCostoEjecutivo = new JTextField();
        txtCostoEjecutivo.setEditable(false);
        txtCostoEjecutivo.setColumns(10);
        txtCostoEjecutivo.setBounds(96,  252,  168,  20);
        panel.add(txtCostoEjecutivo);

        JLabel lblCostoEjecutivo = new JLabel("Costo ejecutivo");
        lblCostoEjecutivo.setBounds(10,  252,  123,  14);
        panel.add(lblCostoEjecutivo);

        txtCostoEquipajeExtra = new JTextField();
        txtCostoEquipajeExtra.setEditable(false);
        txtCostoEquipajeExtra.setColumns(10);
        txtCostoEquipajeExtra.setBounds(141,  277,  123,  20);
        panel.add(txtCostoEquipajeExtra);

        JLabel lblCostoEquipaje = new JLabel("Costo equipaje extra");
        lblCostoEquipaje.setBounds(10,  280,  123,  14);
        panel.add(lblCostoEquipaje);

        JLabel lblHora = new JLabel("Hora");
        lblHora.setBounds(10,  305,  28,  14);
        panel.add(lblHora);

        txtHora = new JTextField();
        txtHora.setEditable(false);
        txtHora.setColumns(10);
        txtHora.setBounds(96,  305,  168,  20);
        panel.add(txtHora);

        JLabel lblCiudadOrigen = new JLabel("Ciudad origen");
        lblCiudadOrigen.setBounds(304,  18,  78,  14);
        panel.add(lblCiudadOrigen);

        JLabel lblCiudadDestino = new JLabel("Ciudad destino");
        lblCiudadDestino.setBounds(304,  56,  88,  14);
        panel.add(lblCiudadDestino);

        JLabel lblCategoria = new JLabel("Categorias");
        lblCategoria.setBounds(304,  84,  88,  14);
        panel.add(lblCategoria);

        txtOrigen = new JTextField();
        txtOrigen.setEditable(false);
        txtOrigen.setColumns(10);
        txtOrigen.setBounds(392,  18,  168,  20);
        panel.add(txtOrigen);

        txtDestino = new JTextField();
        txtDestino.setEditable(false);
        txtDestino.setColumns(10);
        txtDestino.setBounds(392,  51,  168,  20);
        panel.add(txtDestino);

        JScrollPane scrollPaneCategorias = new JScrollPane();
        scrollPaneCategorias.setBounds(392,  81,  168,  108);
        panel.add(scrollPaneCategorias);

        tablaCategorias = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row,  int column) {
                return false;
            }
        };
        
        tablaCategorias.addColumn("Categorias");
        
        tableCategorias = new JTable(tablaCategorias);
        scrollPaneCategorias.setViewportView(tableCategorias);
        
        
        
	    JScrollPane scrollPaneVuelos = new JScrollPane();
	    scrollPaneVuelos.setBounds(392,  213,  168,  106);
	    panel.add(scrollPaneVuelos);

	    DefaultTableModel tablaVuelos = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row,  int column) {
	            return false;
	        }
	    };
	    
	    tablaVuelos.addColumn("Nombre");
	    tablaVuelos.addColumn("Fecha");

	    tableV = new JTable(tablaVuelos);
	    scrollPaneVuelos.setViewportView(tableV);
	    
        JLabel lblVuelo= new JLabel("Vuelos");
        lblVuelo.setBounds(310,  214,  82,  14);
        panel.add(lblVuelo);
        
        JButton btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(430,  356,  89,  29);
        panel.add(btnConsultar);

        tableV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            
                int selectedRow = tableV.getSelectedRow();
                if (selectedRow != -1){

                    String vueloNombre = (String) tablaVuelos.getValueAt(selectedRow,  0);
                    vuelo = controladorVuelos.getVuelo(vueloNombre);

                }
            }

        });
        
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if (vuelo != null){
            	    JInternalFrame frameConsultarVuelo =  new ConsultaVueloInternalFrame(vuelo, null);
					frameConsultarVuelo.setVisible(true);
                    desktopPane.add(frameConsultarVuelo);
					frameConsultarVuelo.toFront();
                }
            	else {
                    JOptionPane.showMessageDialog(
                        panel,                       
                        "Debes seleccionar un vuelo.",  
                        "Error",                    
                        JOptionPane.ERROR_MESSAGE  
                    );
                }
            }
        });
    


        comboBoxRutasVuelo.addActionListener((ActionEvent e) -> {
        	vuelo = null;
            String rutaNombre = (String) comboBoxRutasVuelo.getSelectedItem();
            if (rutaNombre == null || rutaNombre.equals("")) return;
            RutaDeVuelo rdv = controladorVuelos.getRutaDeVuelo(rutaNombre);
        
            txtNombre.setText(rdv.getNombre());
            txtAreaDescripcion.setText(rdv.getDescripcion());
            txtCostoTurista.setText(Double.toString(rdv.getCostoBaseTurista()));
            txtCostoEjecutivo.setText(Double.toString(rdv.getCostoBaseEjecutivo()));
            txtCostoEquipajeExtra.setText(Double.toString(rdv.getCostoEquipajeExtra()));
            txtHora.setText(rdv.getHora().toString());
            txtOrigen.setText(rdv.getOrigen().getNombre());
            txtDestino.setText(rdv.getDestino().getNombre());
            txtEstado.setText(rdv.getEstado().toString());
            
            
            

            tablaCategorias.setRowCount(0); // Limpiar filas existentes
            tablaVuelos.setRowCount(0);
            
            List<String> categorias = rdv.getCategorias();
            Map<String, Vuelo> vuelos = rdv.getVuelos();
            
            for (Vuelo vuelo : vuelos.values()) {
                tablaVuelos.addRow(new Object[]{vuelo.getNombre(), vuelo.getFecha().toString()});
            }
            
            for (String categoria : categorias) {
                tablaCategorias.addRow(new Object[]{categoria});
            }
        });


        cargarDataDefault(rutaDefault);
        
    }

    private void cargarDataDefault(RutaDeVuelo rutaDefault) {


        if (rutaDefault != null) {
            
            comboBoxAerolinea.setSelectedItem(rutaDefault.getAerolinea());
            comboBoxRutasVuelo.setSelectedItem(rutaDefault.getNombre());

            tablaCategorias.setRowCount(0);
            
            txtNombre.setText(rutaDefault.getNombre());
            txtAreaDescripcion.setText(rutaDefault.getDescripcion());
            txtCostoTurista.setText(Double.toString(rutaDefault.getCostoBaseTurista()));
            txtCostoEjecutivo.setText(Double.toString(rutaDefault.getCostoBaseEjecutivo()));
            txtCostoEquipajeExtra.setText(Double.toString(rutaDefault.getCostoEquipajeExtra()));
            txtHora.setText(rutaDefault.getHora().toString());
            txtOrigen.setText(rutaDefault.getOrigen().getNombre());
            txtDestino.setText(rutaDefault.getDestino().getNombre());
            
            List<String> categorias = rutaDefault.getCategorias();


            for (String categoria : categorias){
                tablaCategorias.addRow(new Object[]{categoria});
            }

        }
    }
}