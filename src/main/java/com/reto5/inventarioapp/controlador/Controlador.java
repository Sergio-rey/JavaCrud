package com.reto5.inventarioapp.controlador;

import com.reto5.inventarioapp.modelo.Producto;
import com.reto5.inventarioapp.modelo.RepositorioProducto;
import com.reto5.inventarioapp.vista.window;
import com.reto5.inventarioapp.vista.windowAc;
import com.reto5.inventarioapp.vista.windowBr;
import com.reto5.inventarioapp.vista.windowDa;
import org.springframework.beans.factory.annotation.Autowired;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Esta clase se encargara de los eventos y el manejo de datos
public class Controlador {

    private window vn;
    private windowAc vnAC;
    private windowBr vnBr;
    private String[][] data;

    @Autowired
    private ControladorProducto controladorProducto;

    // Implementa los eventos a las vistas
    public Controlador(window vn, RepositorioProducto repositorioProducto) {

        ControladorProducto controladorProducto = new ControladorProducto(repositorioProducto);
        this.controladorProducto = controladorProducto;

        this.vn = vn;
        vn.getButtonAdd().addActionListener(eventAdd());
        vn.getButtonUpgrade().addActionListener(eventUpgrade());
        vn.getButtonDelete().addActionListener(eventDelete());
        vn.getButtonData().addActionListener(eventData());

        windowAc vnAc = new windowAc();
        this.vnAC = vnAc;
        vnAC.getButtonUpgrade().addActionListener(eventUpgrade2());

        windowBr vnBr = new windowBr();
        this.vnBr = vnBr;
        vnBr.getButtonDelete().addActionListener(eventDelete2());

        tableUpgrade();
    }

    // Se crea el evento para el boton de Agregar producto
    private ActionListener eventAdd() {
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean b = vn.getNombre().isEmpty() || vn.getPrecio().isEmpty() || vn.getInventario().isEmpty();
                if (b) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    try{
                        System.out.println(vn.getNombre());
                        Producto producto = new Producto(vn.getNombre(), Float.parseFloat(vn.getPrecio()), Integer.parseInt(vn.getInventario()));

                        try {
                            controladorProducto.guardarProducto(vn.getNombre(), Float.parseFloat(vn.getPrecio()), Integer.parseInt(vn.getInventario()));
                            JOptionPane.showMessageDialog(null, "Se logro guardar el producto con exito");
                            tableUpgrade();
                        } catch (Exception o){
                            JOptionPane.showMessageDialog(null, "Error al guardar el producto");
                        }
                    } catch (Exception i){
                        JOptionPane.showMessageDialog(null, "Error en los datos");
                    }
                }
            }
        };
        return buttonAction;
    }

    // Se crea el evento para el boton de borrar producto 1
    private ActionListener eventDelete() {
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vnBr.setVisible(true);
            }
        };
        return buttonAction;
    }

    // Se crea el evento para el boton de borrar producto 2
    private ActionListener eventDelete2() {
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vnBr.getID().isEmpty() || controladorProducto.existeProducto(Integer.parseInt(vnBr.getID()))){
                    try {
                        controladorProducto.borrarProducto(Integer.parseInt(vnBr.getID()));
                        tableUpgrade();
                    } catch (Exception i){
                        JOptionPane.showMessageDialog(null,"No se pudo borrar el producto");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"El producto no existe");
                }
            }
        };
        return buttonAction;
    }

    // Se crea el evento para el boton de actualizar producto 1
    private ActionListener eventUpgrade() {
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vnAC.setVisible(true);
            }
        };
        return buttonAction;
    }

    // Se crea el evento para el boton de actualizar producto 2
    private ActionListener eventUpgrade2() {
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean b = vnAC.getID().isEmpty() || vnAC.getNombre().isEmpty() || vnAC.getPrecio().isEmpty() || vnAC.getInventario().isEmpty() || controladorProducto.existeProducto(Integer.parseInt(vnAC.getID()));
                if (!b) {
                    JOptionPane.showMessageDialog(null, "El producto no existe");
                } else {
                    try{
                        Producto producto = new Producto(vnAC.getNombre(), Float.parseFloat(vnAC.getPrecio()), Integer.parseInt(vnAC.getInventario()));

                        try {
                            controladorProducto.actualizarProducto(Integer.parseInt(vnAC.getID()), vnAC.getNombre(), Float.parseFloat(vnAC.getPrecio()), Integer.parseInt(vnAC.getInventario()));
                            JOptionPane.showMessageDialog(null, "Se logro actualizar el producto con exito");
                            tableUpgrade();
                        } catch (Exception o){
                            JOptionPane.showMessageDialog(null, "Error al actualizar el producto");
                        }
                    } catch (Exception i){
                        JOptionPane.showMessageDialog(null, "Error en los datos");
                    }
                }
            }
        };
        return buttonAction;
    }

    // Se crea el evento para el boton de generar informe
    private ActionListener eventData() {
        ActionListener buttonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    windowDa vnDa = new windowDa(setMayor(data), setMenor(data), setPromedio(data), setValor(data));

                } catch (Exception i){
                    JOptionPane.showMessageDialog(null,"Error al generar el informe ");
                }

            }
        };
        return buttonAction;
    }

    // Dice cual es el producto de precio mayor
    public String setMayor(String[][] data) {
        String mayor = null;
        Double x = 0.0;
        for (int j = 0; j < data.length; j++) {
            if (x < Double.parseDouble(data[j][2])){
                x = Double.parseDouble(data[j][2]);
                mayor = data[j][1];
            }
        }
        return mayor;
    }

    // Dice cual es el producto de precio menor
    public String setMenor(String[][] data) {
        String menor = null;
        Double x = 90000.0;
        for (int j = 0; j < data.length; j++) {
            if (x > Double.parseDouble(data[j][2])){
                x = Double.parseDouble(data[j][2]);
                menor = data[j][1];
            }
        }
        return menor;
    }

    // Dice cual es el promedio
    private Double setPromedio(String[][] data) {
         Double promedio = 0.0;
         Double x = 0.0;
         for (int j = 0; j < data.length; j++) {
             x = x + Double.parseDouble(data[j][2]);
         }
         promedio = x / data.length;
         return promedio;
    }

    // Dice cual es el valor total
    private Double setValor(String[][] data) {
        Double valor = 0.0;
        for (int j = 0; j < data.length; j++) {
            valor = valor + (Double.parseDouble(data[j][2]) + Double.parseDouble(data[j][3]));
        }
         return valor;
     }

    // Actualiza la tabla
    private void tableUpgrade(){

        DefaultTableModel tableModel = (DefaultTableModel) vn.getTable().getModel();
        tableModel.setRowCount(0);

        try {
            ArrayList<Producto> productos = controladorProducto.obtenerProductos();
            String[][] data = new String[productos.size()][4];

            for (int i = 0; i < productos.size(); i++) {
                data[i][0] = String.valueOf(productos.get(i).getCodigo());
                data[i][1] = productos.get(i).getName();
                data[i][2] = String.valueOf(productos.get(i).getPrecio());
                data[i][3] = String.valueOf(productos.get(i).getInventario());

                tableModel.addRow(data[i]);
            }

            this.data = data;

            vn.getTable().setModel(tableModel);
            tableModel.fireTableDataChanged();

        } catch (Exception i){
            JOptionPane.showMessageDialog(null,"Error al actualizar la Tabla " + i);
        }
    }

}
