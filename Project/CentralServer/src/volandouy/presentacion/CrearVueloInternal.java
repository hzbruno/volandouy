package volandouy.presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.logica.Aerolinea;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.RutaDeVuelo;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import volandouy.excepciones.SetException;

public class CrearVueloInternal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    public CrearVueloInternal() {
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        
        setTitle("Crear Vuelo");
        setClosable(true);
        setBounds(100,  100,  460,  520); 
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0,  0,  455,  490);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JComboBox<String> comboBoxAerolinea = new JComboBox<>();
        comboBoxAerolinea.setBounds(96,  11,  168,  22);
        for (String aerolineas : controladorUsuarios.getAerolineas().keySet()) {
            comboBoxAerolinea.addItem(aerolineas);
        }
        panel.add(comboBoxAerolinea);
        
        JLabel lblAerolinea = new JLabel("Aerolinea");
        lblAerolinea.setBounds(10,  15,  65,  14);
        panel.add(lblAerolinea);
        
        JComboBox<String> comboBoxRutasVuelo = new JComboBox<>();
        comboBoxRutasVuelo.setBounds(96,  44,  168,  22);
        
        comboBoxAerolinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxRutasVuelo.removeAllItems();
                
                String aerolineaSeleccionada = (String) comboBoxAerolinea.getSelectedItem();
                
                if (aerolineaSeleccionada != null) {
                    Aerolinea aerolinea = controladorUsuarios.getAerolinea(aerolineaSeleccionada);
                    
                    if (aerolinea != null) {
                        Map<String,  RutaDeVuelo> rutasDeVuelo = aerolinea.getRutasDeVueloAceptadas();
                        
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
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10,  73,  65,  14);
        panel.add(lblNombre);
        
        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setBounds(10,  140,  65,  14);
        panel.add(lblFecha);
        
        JLabel lblDuracion = new JLabel("Duración");
        lblDuracion.setBounds(10,  98,  65,  14);
        panel.add(lblDuracion);
        
        JLabel lblCantidadMximaDe = new JLabel("Cantidad Máxima de asientos turista");
        lblCantidadMximaDe.setBounds(10,  302,  254,  14);
        panel.add(lblCantidadMximaDe);
        
        JLabel lblCantidadMximaDe_2 = new JLabel("Cantidad Máxima de asientos ejecutivo");
        lblCantidadMximaDe_2.setBounds(10,  350,  254,  14);
        panel.add(lblCantidadMximaDe_2);
        
        TextField txtNombre = new TextField();
        txtNombre.setBounds(96,  72,  168,  22);
        panel.add(txtNombre);
        
        JCalendar calendarNacimiento = new JCalendar();
        calendarNacimiento.setBounds(80,  138,  184,  153);
        panel.add(calendarNacimiento);

        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner,  "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setBounds(96,  98,  168,  22);
        panel.add(timeSpinner);
        
        TextField txtCMaxT = new TextField();
        txtCMaxT.setBounds(96,  322,  168,  22);
        panel.add(txtCMaxT);
        
        TextField txtCME = new TextField();
        txtCME.setBounds(96,  370,  168,  22);
        panel.add(txtCME);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(10,  410,  115,  34);
        panel.add(btnAceptar);
        btnAceptar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nombre = txtNombre.getText();
                String maxT = txtCMaxT.getText();
                String maxE = txtCME.getText();
                String rutaDeVuelo = (String) comboBoxRutasVuelo.getSelectedItem();
                
                Calendar calendar = calendarNacimiento.getCalendar();
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                int mes = calendar.get(Calendar.MONTH) + 1; 
                int anio = calendar.get(Calendar.YEAR);
                DtFecha fecha = new DtFecha(dia,  mes,  anio);
                DtFecha fechaAlta = new DtFecha();

                Date horaSeleccionada = (Date) timeSpinner.getValue();
                Calendar calHora = Calendar.getInstance();
                calHora.setTime(horaSeleccionada);
                int hora = calHora.get(Calendar.HOUR_OF_DAY);
                int minutos = calHora.get(Calendar.MINUTE);
                DtHora duracion = new DtHora(hora,  minutos);
                
                try{
                    controladorVuelos.altaVuelo(rutaDeVuelo,  nombre,  fecha,  duracion,  maxT,  maxE,  fechaAlta);
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
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(144,  410,  120,  34);
        panel.add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
