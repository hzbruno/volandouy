package volandouy.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.excepciones.SetException;
import volandouy.logica.Ciudad;
import volandouy.logica.Fabrica;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;

public class CrearRutaDeVueloInternal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtCostoTurista;
    private JTextField txtCostoEjecutivo;
    private JTextField txtCostoUnidad;
    private JTextField txtDescripcionCorta;

    public CrearRutaDeVueloInternal() {
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        
        setTitle("Crear Ruta de Vuelo");
        setClosable(true);
        setResizable(false);
        setBounds(100,  100,  600,  550);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,  5,  5,  5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,  0,  584,  511);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblAerolinea = new JLabel("Aerolinea");
        lblAerolinea.setBounds(21,  15,  65,  14);
        panel.add(lblAerolinea);

        txtNombre = new JTextField();
        txtNombre.setBounds(107,  48,  168,  20);
        txtNombre.setColumns(10);
        panel.add(txtNombre);

        JComboBox<String> comboBoxAerolinea = new JComboBox<>();
        comboBoxAerolinea.setBounds(107,  11,  168,  22);
        for (String aerolineas : controladorUsuarios.getAerolineas().keySet()) {
            comboBoxAerolinea.addItem(aerolineas);
        }
        panel.add(comboBoxAerolinea);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(21,  51,  46,  14);
        panel.add(lblNombre);

        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setBounds(21,  96,  77,  14);
        panel.add(lblDescripcion);

        JTextArea txtAreaDescripcion = new JTextArea();
        txtAreaDescripcion.setBounds(107,  91,  260,  80);
        panel.add(txtAreaDescripcion);

        JLabel lblHora = new JLabel("Hora");
        lblHora.setBounds(318,  223,  28,  14);
        panel.add(lblHora);

        JLabel lblCostoTurista = new JLabel("Costo turista");
        lblCostoTurista.setBounds(21,  223,  123,  14);
        panel.add(lblCostoTurista);

        txtCostoTurista = new JTextField();
        txtCostoTurista.setBounds(154,  220,  94,  20);
        panel.add(txtCostoTurista);
        txtCostoTurista.setColumns(10);

        JLabel lblCostoEjecutivo = new JLabel("Costo ejecutivo");
        lblCostoEjecutivo.setBounds(21,  283,  123,  14);
        panel.add(lblCostoEjecutivo);

        txtCostoEjecutivo = new JTextField();
        txtCostoEjecutivo.setBounds(154,  280,  94,  20);
        panel.add(txtCostoEjecutivo);
        txtCostoEjecutivo.setColumns(10);

        txtCostoUnidad = new JTextField();
        txtCostoUnidad.setBounds(154,  340,  94,  20);
        panel.add(txtCostoUnidad);
        txtCostoUnidad.setColumns(10);

        JLabel lblCiudadOrigen = new JLabel("Ciudad origen");
        lblCiudadOrigen.setBounds(268,  261,  78,  14);
        panel.add(lblCiudadOrigen);

        JComboBox<String> comboBoxCiudadOrigen = new JComboBox<>();
        Map<String,  Map<String,  Ciudad>> mapaOrdenado = new TreeMap<>(controladorVuelos.getCiudadesPais());
        comboBoxCiudadOrigen.setBounds(369,  257,  150,  22);
        for (String pais : mapaOrdenado.keySet()) {
            for (String ciudad : mapaOrdenado.get(pais).keySet()) {
                comboBoxCiudadOrigen.addItem(pais + ",  " + ciudad);
            }
        }
        panel.add(comboBoxCiudadOrigen);

        JLabel lblCiudadDestino = new JLabel("Ciudad destino");
        lblCiudadDestino.setBounds(268,  299,  88,  14);
        panel.add(lblCiudadDestino);

        JComboBox<String> comboBoxCiudadDestino = new JComboBox<>();
        comboBoxCiudadDestino.setBounds(369,  295,  150,  22);
        for (String pais : mapaOrdenado.keySet()) {
            for (String ciudad : mapaOrdenado.get(pais).keySet()) {
                comboBoxCiudadDestino.addItem(pais + ",  " + ciudad);
            }
        }
        panel.add(comboBoxCiudadDestino);

        JLabel lblCategoria = new JLabel("Categoria");
        lblCategoria.setBounds(268,  349,  88,  14);
        panel.add(lblCategoria);

        JComboBox<String> comboBoxHora = new JComboBox<>();
        comboBoxHora.setBounds(369,  219,  45,  22);
        for (int i = 0; i < 24; i++) {
            comboBoxHora.addItem(Integer.toString(i));
        }
        panel.add(comboBoxHora);
        
        JComboBox<String> comboBoxMinuto = new JComboBox<>();
        comboBoxMinuto.setBounds(424,  219,  45,  22);
        for (int i = 0; i < 60; i++) {
            comboBoxMinuto.addItem(Integer.toString(i));
        }
        panel.add(comboBoxMinuto);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String cat : controladorVuelos.getCategorias()) {
            listModel.addElement(cat);
        }
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(369,  349,  150,  68);
        panel.add(scrollPane);
        
        JList<String> listCategoria = new JList<>(listModel);
        scrollPane.setViewportView(listCategoria);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String aerolinea = (String) comboBoxAerolinea.getSelectedItem();
                String nombre = txtNombre.getText();
                String descripcion = txtAreaDescripcion.getText();
                String costoTurista = txtCostoTurista.getText();
                String costoEjecutivo = txtCostoEjecutivo.getText();
                String costoEqExtra = txtCostoUnidad.getText();
                String descCorta = txtDescripcionCorta.getText();
                String ciudadOrigen = (String) comboBoxCiudadOrigen.getSelectedItem();
                String ciudadDestino = (String) comboBoxCiudadDestino.getSelectedItem();
                List<String> categoria = listCategoria.getSelectedValuesList();

                int hora = Integer.parseInt((String) comboBoxHora.getSelectedItem());
                int minuto = Integer.parseInt((String) comboBoxMinuto.getSelectedItem());

                DtHora hs = new DtHora(hora,  minuto);
                DtFecha fechaAlta = new DtFecha();

                try {
                    controladorVuelos.altaRutaDeVuelo(
                        aerolinea,  nombre,  descripcion,  hs,  costoTurista,  costoEjecutivo,  costoEqExtra,  
                        ciudadOrigen,  ciudadDestino,  fechaAlta,  categoria, descCorta);
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
        btnAceptar.setBounds(293,  450,  115,  34);
        panel.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(427,  450,  120,  34);
        panel.add(btnCancelar);
        
        JLabel label = new JLabel(":");
        label.setBounds(417,  223,  4,  14);
        panel.add(label);
        
        JLabel lblCostoEquipaje = new JLabel("Costo equipaje extra");
        lblCostoEquipaje.setBounds(21,  343,  123,  14);
        panel.add(lblCostoEquipaje);
        
        JLabel lblDescripcionCorta = new JLabel("Descripcion Corta");
        lblDescripcionCorta.setBounds(379,  35,  121,  14);
        panel.add(lblDescripcionCorta);
        
        txtDescripcionCorta = new JTextField();
        txtDescripcionCorta.setColumns(10);
        txtDescripcionCorta.setBounds(379,  48,  168,  20);
        panel.add(txtDescripcionCorta);
    }
}
