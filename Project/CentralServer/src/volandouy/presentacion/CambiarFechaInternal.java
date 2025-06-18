package volandouy.presentacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import volandouy.datatypes.*;
// public class CambiarFechaInternal extends JInternalFrame {

// 	private static final long serialVersionUID = 1L;


// 	public CambiarFechaInternal() {

//         setTitle("Cambiar Fecha");
//         setClosable(true);
//         setIconifiable(true);
//         setMaximizable(true);
// 		setBounds(100,  100,  310,  300);
// 		getContentPane().setLayout(null);

//         JTextField textFieldFecha = new JTextField();
//         textFieldFecha.setBounds(110,  106,  147,  20);
//         getContentPane().add(textFieldFecha);
//         textFieldFecha.setColumns(10);

//         JButton boton = new

//     }
// }




public class CambiarFechaInternal extends JInternalFrame {

    public CambiarFechaInternal() {
        setTitle("Fecha");
        setBounds(100, 100, 300,  200);
        setClosable(true);
        setIconifiable(true);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JLabel labelDia = new JLabel("Día:");
        JLabel labelMes = new JLabel("Mes:");
        JLabel labelAno = new JLabel("Año:");

        JTextField textDia = new JTextField(10);
        JTextField textMes = new JTextField(10);
        JTextField textAno = new JTextField(10);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dia = Integer.parseInt(textDia.getText());
                int mes = Integer.parseInt(textMes.getText());
                int anio = Integer.parseInt(textAno.getText());
                try{
                    DtFecha f = new DtFecha(dia, mes, anio);
                    FechaActual.getInstancia().setFechaActual(dia, mes, anio);
                    System.out.println("Día: " + dia + ",  Mes: " + mes + ",  Año: " + anio);
                }catch(Exception er){
                    System.out.println("Fecha invalida");
                }

            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,  2,  10,  10)); // 4 filas,  2 columnas

        panel.add(labelDia);
        panel.add(textDia);
        panel.add(labelMes);
        panel.add(textMes);
        panel.add(labelAno);
        panel.add(textAno);

        panel.add(new JLabel()); 
        panel.add(botonAceptar);

        add(panel,  BorderLayout.CENTER);
    }
}