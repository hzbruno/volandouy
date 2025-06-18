package volandouy.presentacion;

import volandouy.logica.Usuario;
import volandouy.logica.Aerolinea;
import volandouy.logica.Cliente;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.Fabrica;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.EnumDocumento;
import volandouy.excepciones.SetException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class ModificarDatosInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldDocumento;
    private JTextField textFieldNombreAerolinea;
    private JTextField textFieldSitioWeb;
    private JTextArea textAreaDescripcion;
    private JComboBox<String> comboBoxNacionalidad;
    private String nicknameG;
    private JTextField txtContraseniaA;
    private JTextField txtContraseniaC;

    public ModificarDatosInternalFrame() {
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();

        setTitle("Modificar Datos");
        setBounds(100,  100,  678,  560);
        setClosable(true);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(455,  447,  91,  23);
        contentPane.add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(15,  5,  627,  137);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panelAerolinea = new JPanel();
        panelAerolinea.setBounds(15,  153,  627,  357);
        contentPane.add(panelAerolinea);
        panelAerolinea.setLayout(null);

        JLabel lblNombreAerolinea = new JLabel("Nombre");
        lblNombreAerolinea.setBounds(57,  23,  90,  14);
        panelAerolinea.add(lblNombreAerolinea);

        textFieldNombreAerolinea = new JTextField();
        textFieldNombreAerolinea.setBounds(130,  20,  200,  20);
        panelAerolinea.add(textFieldNombreAerolinea);
        textFieldNombreAerolinea.setColumns(10);

        JLabel lblSitioWeb = new JLabel("SitioWeb");
        lblSitioWeb.setBounds(57,  73,  90,  14);
        panelAerolinea.add(lblSitioWeb);

        textFieldSitioWeb = new JTextField();
        textFieldSitioWeb.setBounds(130,  70,  200,  20);
        panelAerolinea.add(textFieldSitioWeb);
        textFieldSitioWeb.setColumns(10);

        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setBounds(57,  123,  90,  14);
        panelAerolinea.add(lblDescripcion);

        JButton btnAceptarAerolinea = new JButton("Aceptar");
        btnAceptarAerolinea.setBounds(258,  294,  91,  23);
        panelAerolinea.add(btnAceptarAerolinea);

        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setBounds(130,  120,  279,  115);
        panelAerolinea.add(textAreaDescripcion);
        
        JLabel lblNewLabel = new JLabel("Contraseña");
        lblNewLabel.setBounds(57, 249, 78, 14);
        panelAerolinea.add(lblNewLabel);
        
        txtContraseniaA = new JTextField();
        txtContraseniaA.setColumns(10);
        txtContraseniaA.setBounds(130, 246, 200, 20);
        panelAerolinea.add(txtContraseniaA);

        JPanel panelCliente = new JPanel();
        panelCliente.setBounds(15,  153,  627,  357);
        contentPane.add(panelCliente);
        panelCliente.setLayout(null);

        JLabel lblNombreCliente = new JLabel("Nombre");
        lblNombreCliente.setBounds(33,  43,  60,  14);
        panelCliente.add(lblNombreCliente);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(110,  40,  125,  19);
        panelCliente.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldApellido = new JTextField();
        textFieldApellido.setBounds(110,  90,  125,  18);
        panelCliente.add(textFieldApellido);
        textFieldApellido.setColumns(10);

        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(33,  93,  60,  13);
        panelCliente.add(lblApellido);

        JComboBox<String> comboBoxTipoDocumento = new JComboBox<>();
        comboBoxTipoDocumento.setBounds(135,  140,  100,  18);
        panelCliente.add(comboBoxTipoDocumento);
        comboBoxTipoDocumento.addItem("DNI");
        comboBoxTipoDocumento.addItem("Pasaporte");

        JLabel lblTipodoc = new JLabel("Tipo documento");
        lblTipodoc.setBounds(34,  143,  100,  13);
        panelCliente.add(lblTipodoc);

        textFieldDocumento = new JTextField();
        textFieldDocumento.setBounds(110,  190,  125,  18);
        panelCliente.add(textFieldDocumento);
        textFieldDocumento.setColumns(10);

        JLabel lblDocumento = new JLabel("Documento");
        lblDocumento.setBounds(33,  193,  100,  13);
        panelCliente.add(lblDocumento);

        comboBoxNacionalidad = new JComboBox<>();
        comboBoxNacionalidad.setBounds(110,  240,  125,  20);
        for (String pais : controladorVuelos.getCiudadesPais().keySet()) {
            comboBoxNacionalidad.addItem(pais);
        }
        panelCliente.add(comboBoxNacionalidad);

        JLabel lblNacionalidad = new JLabel("Nacionalidad");
        lblNacionalidad.setBounds(33,  243,  100,  13);
        panelCliente.add(lblNacionalidad);

        JCalendar calendarNacimiento = new JCalendar();
        calendarNacimiento.setBounds(387,  77,  184,  153);
        panelCliente.add(calendarNacimiento);

        JLabel lblCambiarFecha = new JLabel("Cambiar Fecha");
        lblCambiarFecha.setBounds(437,  57,  106,  14);
        panelCliente.add(lblCambiarFecha);

        JButton btnAceptarCliente = new JButton("Aceptar");
        btnAceptarCliente.setBounds(258,  305,  91,  23);
        panelCliente.add(btnAceptarCliente);
        
        txtContraseniaC = new JTextField();
        txtContraseniaC.setColumns(10);
        txtContraseniaC.setBounds(110, 277, 200, 20);
        panelCliente.add(txtContraseniaC);
        
        JLabel lblNewLabel_2_1 = new JLabel("Contraseña");
        lblNewLabel_2_1.setBounds(33, 277, 78, 14);
        panelCliente.add(lblNewLabel_2_1);

        panelCliente.setVisible(false);
        panelAerolinea.setVisible(false);

        btnAceptarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String apellido = textFieldApellido.getText();
                String nroDoc = textFieldDocumento.getText();
                String tipoDoc = (String) comboBoxTipoDocumento.getSelectedItem();
                String nacionalidad = (String) comboBoxNacionalidad.getSelectedItem();
                EnumDocumento tipoDocE = ("Pasaporte".equals(tipoDoc)) ? EnumDocumento.PASAPORTE : EnumDocumento.DNI;
                Date fechaNac = calendarNacimiento.getDate();
                String contrasenia = txtContraseniaC.getText();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNac);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH) + 1; 
                int anio = calendar.get(Calendar.YEAR);
                DtFecha fechaNacimiento = new DtFecha(dia,  mes,  anio);

                try{
                    controladorUsuarios.modificarCliente(nicknameG,  nombre, contrasenia,  apellido,  fechaNacimiento,  nacionalidad,  tipoDocE,  nroDoc);
                    dispose();
                }
                catch(SetException err){
                    String mensajeError = "Se encontraron errores: \n";
                    for (String mErr : err.getErrorSet()) {
                        mensajeError+=mErr +"\n";
                    }
                    JOptionPane.showMessageDialog(contentPane ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        btnAceptarAerolinea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombreAerolinea.getText();
                String sitioWeb = textFieldSitioWeb.getText();
                String descripcion = textAreaDescripcion.getText();
                String contrasenia = txtContraseniaA.getText();

                try {
                    controladorUsuarios.modificarAerolinea(nicknameG,  nombre,contrasenia,  sitioWeb,  descripcion);
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

        table.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("deprecation")
			@Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nickname = table.getValueAt(selectedRow,  0).toString();
                    Usuario usr = controladorUsuarios.getUsuario(nickname);
                    nicknameG = nickname;

                    if (usr instanceof Cliente) {
                        Cliente cliente = (Cliente) usr;
                        panelCliente.setVisible(true);
                        panelAerolinea.setVisible(false);

                        textFieldNombre.setText(cliente.getNombre());
                        textFieldApellido.setText(cliente.getApellido());
                        textFieldDocumento.setText(cliente.getNumeroDocumento());
                        comboBoxTipoDocumento.setSelectedItem(cliente.getTipoDocumento().toString());
                        comboBoxNacionalidad.setSelectedItem(cliente.getNacionalidad());
                        DtFecha fechaNacimiento = cliente.getFechaDeNacimiento();
						Date d = new Date(fechaNacimiento.getAnio() - 1900,  fechaNacimiento.getMes(),  fechaNacimiento.getDia());
                        calendarNacimiento.setDate(d);

                    } else  if (usr instanceof Aerolinea) {
                        Aerolinea aerolinea = (Aerolinea) usr;
                        panelCliente.setVisible(false);
                        panelAerolinea.setVisible(true);

                        textFieldNombreAerolinea.setText(aerolinea.getNombre());
                        textFieldSitioWeb.setText(aerolinea.getSitioWeb());
                        textAreaDescripcion.setText(aerolinea.getDescripcionGeneral());
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
            data[i][0] = usuarios.get(clave).getNickname();
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(data,  columnNames) {
            @Override
            public boolean isCellEditable(int row,  int column) {
                return false;  
            }
        };

        table.setModel(model);
    }
}
