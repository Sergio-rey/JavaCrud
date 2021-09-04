package com.reto5.inventarioapp.vista;

import javax.swing.*;
import java.awt.*;

public class windowDa extends JFrame {

    public windowDa(String productoMy, String productoMn, Double promedio, Double valorIn) {
        this.add(title());
        this.add(addP(productoMy, productoMn, promedio, valorIn));

        this.setTitle("Reto 5 - Informe");
        this.setVisible(true);
        this.setSize(new Dimension(420, 230));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }

    private JPanel title() {
        JLabel title = new JLabel("¡ Informe ! ", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panel.add(title);
        return panel;
    }

    private JPanel addP(String productoMy, String productoMn, Double promedio, Double valorIn) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(addT("Producto precio mayor:   " + productoMy));
        panel.add(addT("Producto precio menor:   " + productoMn));
        panel.add(addT("Promedio precios:   " + promedio ));
        panel.add(addT("Valor del inventario:   " + valorIn ));

        return panel;
    }

    private  JPanel addT(String text){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(200, 24));

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.add(label);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        return panel;
    }

}
