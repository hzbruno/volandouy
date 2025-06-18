package volandouy.presentacion;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import volandouy.datatypes.DtFecha;
import volandouy.excepciones.SetException;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorVuelos;

public class CrearCiudadInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    private final JTextField textFieldCiudad;
    private final JTextField textFieldAeropuerto;
    private final JTextField textFieldSitioWeb;


    public CrearCiudadInternalFrame() {
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        
        setTitle("Crear Ciudad");
        setClosable(true);
        setResizable(false);

        setBounds(100,  100,  600,  650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblLabelPais = new JLabel("Pais");
        lblLabelPais.setBounds(22,  43,  46,  14);
        contentPane.add(lblLabelPais);

        textFieldCiudad = new JTextField();
        textFieldCiudad.setBounds(110,  106,  147,  20);
        contentPane.add(textFieldCiudad);
        textFieldCiudad.setColumns(10);
        
        JLabel lblLabelCiudad = new JLabel("Ciudad");
        lblLabelCiudad.setBounds(22,  109,  46,  14);
        contentPane.add(lblLabelCiudad);
        
        JLabel lblLabelAeropuerto = new JLabel("Aeropuerto");
        lblLabelAeropuerto.setBounds(22,  177,  78,  14);
        contentPane.add(lblLabelAeropuerto);
        
        textFieldAeropuerto = new JTextField();
        textFieldAeropuerto.setBounds(110,  174,  147,  20);
        contentPane.add(textFieldAeropuerto);
        textFieldAeropuerto.setColumns(10);
        
        JTextArea textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setBounds(110,  238,  248,  91);
        contentPane.add(textAreaDescripcion);
        textAreaDescripcion.setColumns(10);
        
        JLabel lblLabelDescripcion = new JLabel("Descripcion");
        lblLabelDescripcion.setBounds(22,  243,  78,  14);
        contentPane.add(lblLabelDescripcion);
        
        JLabel lblLabelSitioWeb = new JLabel("SitioWeb");
        lblLabelSitioWeb.setBounds(22,  373,  62,  14);
        contentPane.add(lblLabelSitioWeb);
        
        textFieldSitioWeb = new JTextField();
        textFieldSitioWeb.setBounds(110,  370,  248,  20);
        contentPane.add(textFieldSitioWeb);
        textFieldSitioWeb.setColumns(10);
        
        JComboBox<String> comboBoxPais = new JComboBox<>();
        comboBoxPais.setBounds(110,  39,  147,  22);
        for (String pais : controladorVuelos.getCiudadesPais().keySet()) {
            comboBoxPais.addItem(pais);
        }
        contentPane.add(comboBoxPais);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener((ActionEvent e) -> {
            String pais,  ciudad,  aeropuerto,  descripcion,  sitioWeb;
            pais = (String) comboBoxPais.getSelectedItem();
            ciudad = textFieldCiudad.getText();
            aeropuerto = textFieldAeropuerto.getText();
            descripcion = textAreaDescripcion.getText();
            sitioWeb = textFieldSitioWeb.getText();
            DtFecha fechaAlta = new DtFecha();
            
            try {

                controladorVuelos.altaCiudad(ciudad,  pais,  aeropuerto,  descripcion,  sitioWeb,  fechaAlta);
                dispose();

            } 
            catch (SetException err) {
                String mensajeError = "Se encontraron errores: \n";
                for (String mErr : err.getErrorSet()) {
                    mensajeError+=mErr +"\n";
                }
                JOptionPane.showMessageDialog(contentPane ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
            }  

        });
        btnAceptar.setBounds(167,  484,  115,  34);
        contentPane.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(292,  484,  120,  34);
        contentPane.add(btnCancelar);

        btnCancelar.addActionListener((ActionEvent e) -> {
            setVisible(false); 
        });
    }
}
