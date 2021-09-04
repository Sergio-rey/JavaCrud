package com.reto5.inventarioapp.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class window extends JFrame {

    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonUpgrade;
    private JButton buttonData;
    private JTextField Nombre;
    private JTextField Precio;
    private JTextField Inventario;
    private JTable table;

    public window() {


        this.add(title());
        this.add(addP());
        this.add(table());
        this.add(buttons());

        this.setTitle("Reto 5 - Sergio Rey");
        this.setVisible(true);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    }



    private JPanel title() {
        JLabel title = new JLabel("¡Bienvenido a la APP de Inventario!", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 19));
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
        panel.add(title);
        return panel;
    }

    private JPanel addP() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Agregar Producto"));

        panel.add(addN("Nombre    "));
        panel.add(addP("Precio       "));
        panel.add(addI("Inventario "));
        panel.add(addB());

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
        JButton button = new JButton("Agregar Producto");

        this.buttonAdd = button;

        panel.setMaximumSize(new Dimension(200, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        panel.add(button);

        return panel;
    }

    private JPanel table() {
        JPanel panel = new JPanel();

        String[] titulos = {"Id", "Nombre", "Precio", "Inventario"};

        JTable table = new JTable(){
            public boolean isCellEditable(int nRow, int nCol) {
                return false;
            }
        };

        DefaultTableModel contactTableModel = (DefaultTableModel) table
                .getModel();

        contactTableModel.setColumnIdentifiers(titulos);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.table = table;

        panel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 230));
        panel.add(scrollPane);

        return panel;
    }

    private JPanel buttons() {
        JPanel panel = new JPanel();

        JButton buttonB = new JButton("Borrar Producto");
        JButton buttonA = new JButton("Actualizar Producto");
        JButton buttonI = new JButton("Informes");

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        this.buttonDelete = buttonB;
        this.buttonUpgrade = buttonA;
        this.buttonData = buttonI;

        panel.add(buttonB);
        panel.add(buttonA);
        panel.add(buttonI);

        return panel;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JButton getButtonUpgrade() {
        return buttonUpgrade;
    }

    public JButton getButtonData() {
        return buttonData;
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public String getNombre() {
        return (String)Nombre.getText(); }

    public String getPrecio() { return Precio.getText(); }

    public String getInventario() { return Inventario.getText(); }

    public JTable getTable() {
        return table;
    }
}
