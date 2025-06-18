package volandouy.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import volandouy.datatypes.DtFecha;
import volandouy.excepciones.SetException;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorVuelos;

public class CrearPaqueteDeRutasDeVueloInternal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textNombre;
    private JTextField textPeriodo;
    private JTextField textDescuento;

    public CrearPaqueteDeRutasDeVueloInternal() {
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();

        setTitle("Crear Paquete de Rutas de Vuelo");
        setClosable(true);
        setResizable(false);
        setBounds(100,  100,  504,  461);
        SpringLayout springLayout = new SpringLayout();
        getContentPane().setLayout(springLayout);
        
        
        textNombre = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH,  textNombre,  38,  SpringLayout.NORTH,  getContentPane());
        springLayout.putConstraint(SpringLayout.EAST,  textNombre,  -236,  SpringLayout.EAST,  getContentPane());
        getContentPane().add(textNombre);
        textNombre.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre");
        springLayout.putConstraint(SpringLayout.EAST,  lblNombre,  -382,  SpringLayout.EAST,  getContentPane());
        springLayout.putConstraint(SpringLayout.WEST,  textNombre,  58,  SpringLayout.EAST,  lblNombre);
        springLayout.putConstraint(SpringLayout.NORTH,  lblNombre,  2,  SpringLayout.NORTH,  textNombre);
        getContentPane().add(lblNombre);
        
        JTextArea textArea = new JTextArea();
        springLayout.putConstraint(SpringLayout.NORTH,  textArea,  17,  SpringLayout.SOUTH,  textNombre);
        springLayout.putConstraint(SpringLayout.EAST,  textArea,  -158,  SpringLayout.EAST,  getContentPane());
        getContentPane().add(textArea);
        
        JLabel lblDescripcion = new JLabel("Descripcion");
        springLayout.putConstraint(SpringLayout.WEST,  textArea,  41,  SpringLayout.EAST,  lblDescripcion);
        springLayout.putConstraint(SpringLayout.NORTH,  lblDescripcion,  0,  SpringLayout.NORTH,  textArea);
        springLayout.putConstraint(SpringLayout.WEST,  lblDescripcion,  0,  SpringLayout.WEST,  lblNombre);
        getContentPane().add(lblDescripcion);
        
        textPeriodo = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH,  textPeriodo,  189,  SpringLayout.NORTH,  getContentPane());
        springLayout.putConstraint(SpringLayout.EAST,  textPeriodo,  -222,  SpringLayout.EAST,  getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH,  textArea,  -18,  SpringLayout.NORTH,  textPeriodo);
        getContentPane().add(textPeriodo);
        textPeriodo.setColumns(10);
        
        JLabel lblPeriodoDeValidez = new JLabel("Periodo De Validez");
        springLayout.putConstraint(SpringLayout.WEST,  textPeriodo,  13,  SpringLayout.EAST,  lblPeriodoDeValidez);
        springLayout.putConstraint(SpringLayout.NORTH,  lblPeriodoDeValidez,  2,  SpringLayout.NORTH,  textPeriodo);
        springLayout.putConstraint(SpringLayout.WEST,  lblPeriodoDeValidez,  0,  SpringLayout.WEST,  lblNombre);
        getContentPane().add(lblPeriodoDeValidez);
        
        textDescuento = new JTextField();
        springLayout.putConstraint(SpringLayout.NORTH,  textDescuento,  17,  SpringLayout.SOUTH,  textPeriodo);
        springLayout.putConstraint(SpringLayout.WEST,  textDescuento,  0,  SpringLayout.WEST,  textPeriodo);
        springLayout.putConstraint(SpringLayout.EAST,  textDescuento,  4,  SpringLayout.EAST,  textNombre);
        getContentPane().add(textDescuento);
        textDescuento.setColumns(10);
        
        JLabel lblDescuento = new JLabel("Descuento");
        springLayout.putConstraint(SpringLayout.NORTH,  lblDescuento,  2,  SpringLayout.NORTH,  textDescuento);
        springLayout.putConstraint(SpringLayout.WEST,  lblDescuento,  0,  SpringLayout.WEST,  lblNombre);
        getContentPane().add(lblDescuento);
        
        JButton btnAceptar = new JButton("Aceptar");
        springLayout.putConstraint(SpringLayout.NORTH,  btnAceptar,  60,  SpringLayout.SOUTH,  lblDescuento);
        springLayout.putConstraint(SpringLayout.WEST,  btnAceptar,  0,  SpringLayout.WEST,  lblNombre);
        getContentPane().add(btnAceptar);
        btnAceptar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombre.getText();
                String descripcion = textArea.getText();
                String descuento = textDescuento.getText();
                String periodo = textPeriodo.getText();
                DtFecha fechaAlta = new DtFecha();

                try {
                    controladorVuelos.altaPaquete(nombre,  descripcion,  periodo,  descuento,  fechaAlta);
                    dispose();
                } 
                catch (SetException err) {
                    String mensajeError = "Se encontraron errores: \n";
                    for (String mErr : err.getErrorSet()) {
                        mensajeError+=mErr +"\n";
                    }
                    JOptionPane.showMessageDialog(getContentPane() ,  mensajeError,  "Error" ,  JOptionPane.ERROR_MESSAGE);
                }  
            }
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        springLayout.putConstraint(SpringLayout.NORTH,  btnCancelar,  0,  SpringLayout.NORTH,  btnAceptar);
        springLayout.putConstraint(SpringLayout.WEST,  btnCancelar,  0,  SpringLayout.WEST,  textNombre);
        getContentPane().add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}

