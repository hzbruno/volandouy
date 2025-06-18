package volandouy.presentacion;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Map;
import java.util.Calendar;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import volandouy.logica.ControladorUsuarios;
import volandouy.logica.ControladorVuelos;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.Fabrica;
import volandouy.datatypes.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import volandouy.excepciones.SetException;

public class CrearUsuarioInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private JTextField textFieldNickname;
    private JTextField textFieldNombre;
    private JTextField textFieldCorreo;
    private JTextField textFieldDocumento;
    private JTextField textFieldApellido;

    private final JLabel lblTipoDeUsuario;
    private final JLabel lblApellido;
    private final JLabel lblDocumento;
    private final JLabel lblTipoDeDocumento;
    private JComboBox<String> comboBoxTipoDocumento;
    private final JLabel lblFechaNac;
    private final JLabel lblNacionalidad;
    private JComboBox<String> comboBoxNacionalidad;
    private JTextField textFieldSitioWeb;
    private JTextField txtContrasenia2;
    private JLabel lblContrasenia_1;
    private JTextField txtContrasenia1;


    public CrearUsuarioInternalFrame() {
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();

        setTitle("Crear Usuario");
        setClosable(true);
        setResizable(false);
        setBounds(100,  100,  700,  700);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textFieldNickname = new JTextField();
        textFieldNickname.setBounds(110,  40,  147,  20);
        contentPane.add(textFieldNickname);
        textFieldNickname.setColumns(10);

        JLabel lblNickname = new JLabel("Nickname");
        lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
        lblNickname.setBounds(27,  43,  74,  14);
        contentPane.add(lblNickname);

        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        textFieldNombre.setBounds(110,  86,  147,  20);
        contentPane.add(textFieldNombre);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombre.setBounds(27,  89,  74,  14);
        contentPane.add(lblNombre);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setColumns(10);
        textFieldCorreo.setBounds(110,  129,  147,  20);
        contentPane.add(textFieldCorreo);

        JLabel lblCorreo = new JLabel("Correo");
        lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCorreo.setBounds(27,  132,  74,  14);
        contentPane.add(lblCorreo);

        JComboBox<String> comboBoxTipoUsuario = new JComboBox<>();
        comboBoxTipoUsuario.addItem("Cliente");
        comboBoxTipoUsuario.addItem("Aerolinea");
        comboBoxTipoUsuario.setBounds(125,  191,  132,  20);
        contentPane.add(comboBoxTipoUsuario);

        lblTipoDeUsuario = new JLabel("Tipo de usuario");
        lblTipoDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        lblTipoDeUsuario.setBounds(27,  194,  74,  14);
        contentPane.add(lblTipoDeUsuario);

        JPanel panelCliente = new JPanel();
        panelCliente.setBounds(0,  230,  657,  363);
        contentPane.add(panelCliente);
        panelCliente.setLayout(null);

        textFieldDocumento = new JTextField();
        textFieldDocumento.setColumns(10);
        textFieldDocumento.setBounds(110,  202,  147,  20);
        panelCliente.add(textFieldDocumento);

        textFieldApellido = new JTextField();
        textFieldApellido.setColumns(10);
        textFieldApellido.setBounds(110,  35,  147,  20);
        panelCliente.add(textFieldApellido);

        lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(39,  38,  46,  14);
        panelCliente.add(lblApellido);

        lblDocumento = new JLabel("Documento");
        lblDocumento.setBounds(35,  205,  70,  14);
        panelCliente.add(lblDocumento);

        lblTipoDeDocumento = new JLabel("Tipo de documento");
        lblTipoDeDocumento.setHorizontalAlignment(SwingConstants.CENTER);
        lblTipoDeDocumento.setBounds(22,  128,  91,  14);
        panelCliente.add(lblTipoDeDocumento);

        comboBoxTipoDocumento = new JComboBox<>();
        comboBoxTipoDocumento.addItem("DNI");
        comboBoxTipoDocumento.addItem("Pasaporte");
        comboBoxTipoDocumento.setBounds(123,  124,  132,  20);
        panelCliente.add(comboBoxTipoDocumento);

        lblFechaNac = new JLabel("Fecha de nacimiento");
        lblFechaNac.setHorizontalAlignment(SwingConstants.CENTER);
        lblFechaNac.setBounds(436,  109,  132,  14);
        panelCliente.add(lblFechaNac);

        lblNacionalidad = new JLabel("Nacionalidad");
        lblNacionalidad.setBounds(39,  277,  83,  14);
        panelCliente.add(lblNacionalidad);

        comboBoxNacionalidad = new JComboBox<>();
        for (String pais : controladorVuelos.getCiudadesPais().keySet()) {
            comboBoxNacionalidad.addItem(pais);
        }
        comboBoxNacionalidad.setBounds(132,  273,  106,  22);
        panelCliente.add(comboBoxNacionalidad);

        JCalendar calendarNacimiento = new JCalendar();
        calendarNacimiento.setBounds(415,  150,  172,  145);
        panelCliente.add(calendarNacimiento);

        JPanel panelAerolinea = new JPanel();
        panelAerolinea.setBounds(0,  230,  657,  363);
        contentPane.add(panelAerolinea);
        panelAerolinea.setLayout(null);

        textFieldSitioWeb = new JTextField();
        textFieldSitioWeb.setColumns(10);
        textFieldSitioWeb.setBounds(168,  26,  221,  20);
        panelAerolinea.add(textFieldSitioWeb);

        JLabel lblSitioWeb = new JLabel("Sitio web");
        lblSitioWeb.setBounds(37,  29,  66,  14);
        panelAerolinea.add(lblSitioWeb);

        JLabel lblDescGeneral = new JLabel("Descripcion general");
        lblDescGeneral.setBounds(27,  84,  118,  14);
        panelAerolinea.add(lblDescGeneral);

        JTextArea textAreaDescGeneral = new JTextArea();
        textAreaDescGeneral.setBounds(168,  79,  399,  204);
        panelAerolinea.add(textAreaDescGeneral);

        JButton btnCrearUsuario = new JButton("Aceptar");
        btnCrearUsuario.setBounds(199,  616,  89,  23);
        contentPane.add(btnCrearUsuario);

        btnCrearUsuario.addActionListener((ActionEvent e) -> {
            String nickname,  nombre,  correo, contrasenia;
            nickname = textFieldNickname.getText();
            contrasenia = txtContrasenia2.getText();
            
            if (!contrasenia.equals(txtContrasenia1.getText())) {
            	JOptionPane.showMessageDialog(null,  "Contraseñas diferentes",  "Error",  JOptionPane.ERROR_MESSAGE);
            }else  {
            	
            nombre = textFieldNombre.getText();
            correo = textFieldCorreo.getText();
            if ("Cliente".equals((String) comboBoxTipoUsuario.getSelectedItem())) {

                String apellido,  tipoDocumento,  documento,  nacionalidad;
                Date fechaNac;
                
                
                apellido = textFieldApellido.getText();
                tipoDocumento = (String) comboBoxTipoDocumento.getSelectedItem();
                documento = textFieldDocumento.getText();
                fechaNac = calendarNacimiento.getDate();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNac);

                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH) + 1; 
                int anio = calendar.get(Calendar.YEAR);

                nacionalidad = (String) comboBoxNacionalidad.getSelectedItem();

                DtFecha fechaNacimiento = new DtFecha(dia,  mes,  anio);
                EnumDocumento tipoDoc = ("Pasaporte".equals(tipoDocumento)) ? EnumDocumento.PASAPORTE : EnumDocumento.DNI;


                try{   
                    controladorUsuarios.altaCliente(nickname,  nombre,  correo, contrasenia,  apellido,  fechaNacimiento,  nacionalidad,  tipoDoc,  documento);
                    dispose();
                }
                catch (SetException err) {
                    String mensajeError = "Se encontraron errores: \n";
                    for (String mErr : err.getErrorSet()) {
                        mensajeError+=mErr +"\n";
                    }
                    JOptionPane.showMessageDialog(contentPane ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
                }  


            } else  {

                String sitioWeb,  descGeneral;

                sitioWeb = textFieldSitioWeb.getText();
                descGeneral = textAreaDescGeneral.getText();
                

                try {
                    controladorUsuarios.altaAerolinea(nickname,  nombre,  correo,  contrasenia,  descGeneral,  sitioWeb);   
                    dispose();
                } 
                catch (SetException err) {
                    String mensajeError = "Se encontraron errores: \n";
                    for (String mErr : err.getErrorSet()) {
                        mensajeError+=mErr +"\n";
                    }
                    JOptionPane.showMessageDialog(contentPane ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
                }  


            }
            }
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(329,  616,  89,  23);
        contentPane.add(btnCancelar);
        
        JLabel lblContrasenia = new JLabel("Confirmar Contraseña");
        lblContrasenia.setHorizontalAlignment(SwingConstants.LEFT);
        lblContrasenia.setBounds(305,  71,  147,  14);
        contentPane.add(lblContrasenia);
        
        txtContrasenia2 = new JTextField();
        txtContrasenia2.setColumns(10);
        txtContrasenia2.setBounds(442,  68,  147,  20);
        contentPane.add(txtContrasenia2);
        
        lblContrasenia_1 = new JLabel("Contraseña");
        lblContrasenia_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblContrasenia_1.setBounds(305,  43,  74,  14);
        contentPane.add(lblContrasenia_1);
        
        txtContrasenia1 = new JTextField();
        txtContrasenia1.setColumns(10);
        txtContrasenia1.setBounds(442,  40,  147,  20);
        contentPane.add(txtContrasenia1);

        btnCancelar.addActionListener((ActionEvent e) -> {
            dispose(); 
        });

        if ("Cliente".equals((String) comboBoxTipoUsuario.getSelectedItem())) {
            panelCliente.setVisible(true);
            panelAerolinea.setVisible(false);
        } else  {
            panelCliente.setVisible(false);
            panelAerolinea.setVisible(true);
        }

        comboBoxTipoUsuario.addActionListener((ActionEvent e) -> {
            String selectedOption = (String) comboBoxTipoUsuario.getSelectedItem();

            if ("Cliente".equals(selectedOption)) {
                panelCliente.setVisible(true);
                panelAerolinea.setVisible(false);
            } else  if ("Aerolinea".equals(selectedOption)) {
                panelCliente.setVisible(false);
                panelAerolinea.setVisible(true);
            }
        });
    }
}
