package volandouy.presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import volandouy.logica.*;

public class ConsultaVueloInternalFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldNombre;
    private JTextField textFieldDuracion;
    private JTextField textFieldFecha;
    private JTextField textFieldCMAT;
    private JTextField textFieldCMAE;
    private JTable tableRDV;
    private JTable tableV;
    private JTable tableR;
    private JTable tableP;
    private JTextField textFieldCiudadOrigen;
    private JTextField textFieldCiudadDestino;
	private List<Reserva> reservasGlobal;



    public ConsultaVueloInternalFrame(Vuelo vueloDefault,  Reserva reservaDefault) {
    	
    	reservasGlobal = new ArrayList<>();
    	
        IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();

        
        setTitle("Consultar vuelo");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(false);
        setBounds(100,  100,  900,  700);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Aerolinea");
        lblNewLabel.setBounds(40,  37,  79,  14);
        getContentPane().add(lblNewLabel);

	    JScrollPane scrollPaneRutasDeVuelo = new JScrollPane();
	    scrollPaneRutasDeVuelo.setBounds(26,  76,  627,  106);
	    getContentPane().add(scrollPaneRutasDeVuelo);

	    DefaultTableModel tablaRutasDeVuelo = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row,  int column) {
	            return false;
	        }
	    };
	    
	    tablaRutasDeVuelo.addColumn("Rutas de vuelo");

	    tableRDV = new JTable(tablaRutasDeVuelo);
	    scrollPaneRutasDeVuelo.setViewportView(tableRDV);
	    
	    JScrollPane scrollPaneVuelos = new JScrollPane();
	    scrollPaneVuelos.setBounds(26,  204,  627,  106);
	    getContentPane().add(scrollPaneVuelos);

	    DefaultTableModel tablaVuelos = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row,  int column) {
	            return false;
	        }
	    };
	    tablaVuelos.addColumn("Vuelos");

	    tableV = new JTable(tablaVuelos);
	    scrollPaneVuelos.setViewportView(tableV);


        JComboBox<String> comboBoxAerolinea = new JComboBox<>();
        comboBoxAerolinea.setBounds(116,  33,  137,  22);
        getContentPane().add(comboBoxAerolinea);
        for (String nickname : controladorUsuarios.getAerolineas().keySet()) {
            comboBoxAerolinea.addItem(nickname);
        }


        JPanel panel = new JPanel();
        panel.setBounds(26,  321,  864,  349);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        
        
        

	    DefaultTableModel tablaReservas = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row,  int column) {
	            return false;
	        }
	    };
	    
	    tablaReservas.addColumn("Fecha");
        tablaReservas.addColumn("Equipaje extra");
        tablaReservas.addColumn("Pasajes");
        tablaReservas.addColumn("Tipo asiento");
        tablaReservas.addColumn("Costo");
        tablaReservas.addColumn("Identificador");


	    
	    JScrollPane scrollPaneReservas = new JScrollPane();
	    scrollPaneReservas.setBounds(275,  68,  468,  96);
	    panel.add(scrollPaneReservas);
	    
	    tableR = new JTable(tablaReservas);
	    scrollPaneReservas.setViewportView(tableR);
        tableR.getTableHeader().setReorderingAllowed(false);

        
        JScrollPane scrollPanePasajes = new JScrollPane();
        scrollPanePasajes.setBounds(275,  210,  468,  108);
        panel.add(scrollPanePasajes);

        DefaultTableModel tablaPasajes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row,  int column) {
                return false;
            }
        };
        
        tablaPasajes.addColumn("Nombre");
        tablaPasajes.addColumn("Apellido");

        tableP = new JTable(tablaPasajes);
        scrollPanePasajes.setViewportView(tableP);
	    tableP.getTableHeader().setReorderingAllowed(false);

	    
	    
        
        

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(19,  95,  46,  14);
        panel.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(87,  92,  86,  20);
        panel.add(textFieldNombre);
        textFieldNombre.setColumns(10);
        textFieldNombre.setEditable(false);
        textFieldNombre.setOpaque(false);


        JLabel lblDuracion = new JLabel("Duracion");
        lblDuracion.setBounds(19,  131,  46,  14);
        panel.add(lblDuracion);

        textFieldDuracion = new JTextField();
        textFieldDuracion.setBounds(87,  128,  86,  20);
        panel.add(textFieldDuracion);
        textFieldDuracion.setColumns(10);
        textFieldDuracion.setEditable(false);
        textFieldDuracion.setOpaque(false);

        JLabel lblFecha = new JLabel("Fecha");
        lblFecha.setBounds(19,  168,  46,  14);
        panel.add(lblFecha);

        textFieldFecha = new JTextField();
        textFieldFecha.setBounds(87,  165,  86,  20);
        panel.add(textFieldFecha);
        textFieldFecha.setColumns(10);
        textFieldFecha.setEditable(false);
        textFieldFecha.setOpaque(false);

        JLabel lblCMAT = new JLabel("Cantidad maxima de asientos turista");
        lblCMAT.setBounds(19,  211,  216,  14);
        panel.add(lblCMAT);

        textFieldCMAT = new JTextField();
        textFieldCMAT.setBounds(19,  236,  86,  20);
        panel.add(textFieldCMAT);
        textFieldCMAT.setColumns(10);
        textFieldCMAT.setEditable(false);
        textFieldCMAT.setOpaque(false);

        JLabel lblCMAE = new JLabel("Cantidad maxima de asientos ejecutivo");
        lblCMAE.setBounds(19,  278,  227,  14);
        panel.add(lblCMAE);

        textFieldCMAE = new JTextField();
        textFieldCMAE.setBounds(19,  313,  86,  20);
        panel.add(textFieldCMAE);
        textFieldCMAE.setColumns(10);
        textFieldCMAE.setEditable(false);
        textFieldCMAE.setOpaque(false);
        
        JLabel lblCiudadOrigen = new JLabel("Ciudad origen");
        lblCiudadOrigen.setBounds(19,  14,  86,  14);
        panel.add(lblCiudadOrigen);
        
        JLabel lblNewLabel_1_1 = new JLabel("Ciudad destino");
        lblNewLabel_1_1.setBounds(19,  49,  86,  14);
        panel.add(lblNewLabel_1_1);
        
        textFieldCiudadOrigen = new JTextField();
        textFieldCiudadOrigen.setOpaque(false);
        textFieldCiudadOrigen.setEditable(false);
        textFieldCiudadOrigen.setColumns(10);
        textFieldCiudadOrigen.setBounds(111,  11,  120,  20);
        panel.add(textFieldCiudadOrigen);
        
        textFieldCiudadDestino = new JTextField();
        textFieldCiudadDestino.setOpaque(false);
        textFieldCiudadDestino.setEditable(false);
        textFieldCiudadDestino.setColumns(10);
        textFieldCiudadDestino.setBounds(111,  46,  120,  20);
        panel.add(textFieldCiudadDestino);
        
        JLabel lblNewLabel_1 = new JLabel("Reservas");
        lblNewLabel_1.setFont(new Font("Arial",  Font.BOLD,  15));
        lblNewLabel_1.setBounds(471,  43,  95,  14);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Pasajes");
        lblNewLabel_1_2.setFont(new Font("Arial",  Font.BOLD,  15));
        lblNewLabel_1_2.setBounds(471,  185,  95,  14);
        panel.add(lblNewLabel_1_2);
        
        
 
        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        
        
        
        comboBoxAerolinea.addActionListener((ActionEvent e) -> {
        	setearTexto();
        	tablaRutasDeVuelo.setRowCount(0);
        	tablaVuelos.setRowCount(0);
            tablaReservas.setRowCount(0);
            tablaPasajes.setRowCount(0);
            String nombreAerolinea = (String) comboBoxAerolinea.getSelectedItem();
            Aerolinea aero = controladorUsuarios.getAerolinea(nombreAerolinea);
            for (String rdv : aero.getRutasDeVueloAceptadas().keySet())
            
            
            tablaRutasDeVuelo.addRow(new Object[]{rdv});
        });

        
        
        tableRDV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setearTexto();
              	tablaVuelos.setRowCount(0);
            	tablaReservas.setRowCount(0);
            	tablaPasajes.setRowCount(0);

                int selectedRow = tableRDV.getSelectedRow();
                
                if (selectedRow != -1) {
                    String rutaDeVuelo = (String) tablaRutasDeVuelo.getValueAt(selectedRow,  0);
                    
  
                    for (String vueloNombre : controladorVuelos.getRutaDeVuelo(rutaDeVuelo).getVuelos().keySet()) {
                        tablaVuelos.addRow(new Object[]{vueloNombre});
                    }
                    
                }
            }
        });
        
        tableV.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                tablaReservas.setRowCount(0);
                tablaPasajes.setRowCount(0);
                

                int selectedRow = tableV.getSelectedRow();
                
                if (selectedRow != -1) {
                    String vueloNombre = (String) tablaVuelos.getValueAt(selectedRow,  0);
                    Vuelo vuelo = controladorVuelos.getVuelo(vueloNombre);
                    RutaDeVuelo rutaDeVuelo = controladorVuelos.getRutaDeVuelo((String) tablaRutasDeVuelo.getValueAt(tableRDV.getSelectedRow(), 0));
                    
                    textFieldNombre.setText(vueloNombre);
                    textFieldDuracion.setText(vuelo.getDuracion().toString());
                    textFieldFecha.setText(vuelo.getFecha().toString());
                    textFieldCMAE.setText(Integer.toString(vuelo.getCantMaxAsientoEjecutivo()));
                    textFieldCMAT.setText(Integer.toString(vuelo.getCantMaxAsientoTurista()));
                    textFieldCiudadOrigen.setText(rutaDeVuelo.getOrigen().getNombre());
                    textFieldCiudadDestino.setText(rutaDeVuelo.getDestino().getNombre());


                    List<Reserva> reservas = vuelo.getReservas();
                    reservasGlobal = new ArrayList<>(reservas);

                    for (Reserva reserva : reservas){
                        String fecha = reserva.getFecha().toString();
                        String equipajeExtra = Integer.toString(reserva.getUnidadesEquipExtra());
                        String pasajes = Integer.toString(reserva.getCantPasajes());
                        String tipoAsiento = reserva.getTipoAsiento().name();
                        String costo = Double.toString(reserva.getCosto());
                        String identificador = Integer.toString(reserva.getId());
                        tablaReservas.addRow(new Object[]{fecha, equipajeExtra, pasajes, tipoAsiento, costo, identificador});
                    }
      
                    
                }
            }
        });
        
        
        tableR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
                int selectedRow = tableR.getSelectedRow();
                if (selectedRow != -1) {
                    tablaPasajes.setRowCount(0);
                    
                    String idS =(String) tablaReservas.getValueAt(selectedRow,  5);
                    int id = Integer.parseInt(idS);
                    Vuelo v = controladorVuelos.getVuelo((String) tableV.getValueAt(tableV.getSelectedRow(),  0));
                    for (Reserva r : v.getReservas() ) {
                        if (r.getId()==id) {
                            
                            ArrayList<Pasaje> pasajes = r.getPasajes();
                            for (Pasaje pasaje : pasajes) {
                                tablaPasajes.addRow(new Object[]{pasaje.getNombre(), pasaje.getApellido()});
                            }

                        }
                    }


                }
                    
                
            }
        });
        
        
        if (vueloDefault != null || reservaDefault != null) {
            Vuelo vuelo;
            if (reservaDefault!=null) {
                vuelo=reservaDefault.getVuelo();
            }else {
                vuelo=vueloDefault;
            }

            comboBoxAerolinea.setSelectedItem(vuelo.getRutaDeVuelo().getAerolinea());
            boolean encontrado=false;
            for (int row = 0; row < tableRDV.getRowCount(); row++) {
                for (int col = 0; col < tableRDV.getColumnCount(); col++) {
                    if (tableRDV.getValueAt(row,  col).equals(vuelo.getRutaDeVuelo().getNombre())) {
                        tableRDV.setRowSelectionInterval(row,  row);
                        tableRDV.setColumnSelectionInterval(col,  col);
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) break;
            }

            for (String vueloNombre : vuelo.getRutaDeVuelo().getVuelos().keySet()) {
                tablaVuelos.addRow(new Object[]{vueloNombre});
            }
            encontrado = false;
            for (int row = 0; row < tableV.getRowCount(); row++) {
                for (int col = 0; col < tableV.getColumnCount(); col++) {
                    if (tableV.getValueAt(row,  col).equals(vuelo.getNombre())) {
                        tableV.setRowSelectionInterval(row,  row);
                        tableV.setColumnSelectionInterval(col,  col);
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) break;
            }  
            textFieldNombre.setText(vuelo.getNombre());
            textFieldDuracion.setText(vuelo.getDuracion().toString());
            textFieldFecha.setText(vuelo.getFecha().toString());
            textFieldCMAE.setText(Integer.toString(vuelo.getCantMaxAsientoEjecutivo()));
            textFieldCMAT.setText(Integer.toString(vuelo.getCantMaxAsientoTurista()));
            textFieldCiudadOrigen.setText( vuelo.getRutaDeVuelo().getOrigen().getNombre());
            textFieldCiudadDestino.setText( vuelo.getRutaDeVuelo().getDestino().getNombre());

            List<Reserva> reservas = vuelo.getReservas();
            for (Reserva reserva : reservas){
                String fecha = reserva.getFecha().toString();
                String equipajeExtra = Integer.toString(reserva.getUnidadesEquipExtra());
                String pasajes = Integer.toString(reserva.getCantPasajes());
                String tipoAsiento = reserva.getTipoAsiento().name();
                String costo = Double.toString(reserva.getCosto());
                String identificador = Integer.toString(reserva.getId());
                tablaReservas.addRow(new Object[]{fecha, equipajeExtra, pasajes, tipoAsiento, costo, identificador});
                if (reservaDefault!=null && reserva.equals(reservaDefault)) {
                    tableR.setRowSelectionInterval(tableR.getRowCount()-1, tableR.getRowCount()-1);
                }
            }
            if (reservaDefault!=null ) {
                for (Pasaje p : reservaDefault.getPasajes()){
                    String nombre = p.getNombre();
                    String apellido = p.getApellido();
                    tablaPasajes.addRow(new Object[]{nombre, apellido});
                }


            }


        }


    }

public void setearTexto() {

    textFieldNombre.setText("");
    textFieldDuracion.setText("");
    textFieldFecha.setText("");
    textFieldCMAE.setText("");
    textFieldCMAT.setText("");
    textFieldCiudadOrigen.setText("");
    textFieldCiudadDestino.setText("");
}





}