package com.reto5.inventarioapp.vista;

import javax.swing.*;
import java.awt.*;

public class windowAc extends JFrame {

    private JButton buttonUpgrade;

    private JTextField ID;
    private JTextField Nombre;
    private JTextField Precio;
    private JTextField Inventario;

    public windowAc(){

        this.add(title());
        this.add(addP());

        this.setTitle("Reto 5 - Actualizar Producto");
        this.setSize(new Dimension(420, 270));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }

    private JPanel title() {
        JLabel title = new JLabel("Ingrese los nuevos valores ", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panel.add(title);
        return panel;
    }

    private JPanel addP() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(addID("ID               "));
        panel.add(addN("Nombre    "));
        panel.add(addP("Precio       "));
        panel.add(addI("Inventario "));
        panel.add(addB());

        return panel;
    }

    private JPanel addID(String text) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(text);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        label.setPreferredSize(new Dimension(50, 24));

        JTextField textField = new JTextField();
        this.ID = textField;
        textField.setMaximumSize(new Dimension(110, 24));

        panel.add(label);
        panel.add(textField);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        return panel;
    }

    private JPanel addN(String text) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(text);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        label.setPreferredSize(new Dimension(50, 24));

        JTextField textField = new JTextField();
        this.Nombre = textField;
        textField.setMaximumSize(new Dimension(110, 24));

        panel.add(label);
        panel.add(textField);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        return panel;
    }

    private JPanel addP(String text) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(text);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        label.setPreferredSize(new Dimension(50, 24));

        JTextField textField = new JTextField();
        this.Precio = textField;
        textField.setMaximumSize(new Dimension(110, 24));

        panel.add(label);
        panel.add(textField);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        return panel;
    }

    private JPanel addI(String text) {
        JPanel panel = new JPanel();

        JLabel label = new JLabel(text);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        label.setPreferredSize(new Dimension(50, 24));

        JTextField textField = new JTextField();
        this.Inventario = textField;
        textField.setMaximumSize(new Dimension(110, 24));

        panel.add(label);
        panel.add(textField);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        return panel;
    }

    private JPanel addB() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Actualizar Producto");
        this.buttonUpgrade = button;
        panel.setMaximumSize(new Dimension(200, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        panel.add(button);

        return panel;
    }

    public JButton getButtonUpgrade() {
        return buttonUpgrade;
    }

    public String getID() { return ID.getText(); }

    public String getNombre() { return Nombre.getText(); }

    public String getPrecio() { return Precio.getText(); }

    public String getInventario() { return Inventario.getText(); }

}
