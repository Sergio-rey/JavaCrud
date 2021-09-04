package com.reto5.inventarioapp.vista;

import javax.swing.*;
import java.awt.*;

public class windowBr extends JFrame {

    private JButton buttonDelete;

    private JTextField ID;


    public windowBr(){

        this.add(title());
        this.add(addP());

        this.setTitle("Reto 5 - Borrar Producto");
        this.setSize(new Dimension(420, 170));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }

    private JPanel title() {
        JLabel title = new JLabel("Producto a borrar ", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panel.add(title);
        return panel;
    }

    private JPanel addP() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(addN("Id    "));
        panel.add(addB());

        return panel;
    }

    private JPanel addN(String text) {
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

    private JPanel addB() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Borrar Producto");
        this.buttonDelete = button;
        panel.setMaximumSize(new Dimension(200, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(button);

        return panel;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public String getID() { return ID.getText(); }

}
