package volandouy.presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import volandouy.datatypes.*;




public class FechaInternalFrame extends JInternalFrame {

    public FechaInternalFrame() {
        setTitle("Fecha");
        setSize(300,  200);
        setClosable(true);
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

                FechaActual.getInstancia().setFechaActual(dia, mes, anio);

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