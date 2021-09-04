package com.reto5.inventarioapp.controlador;


import com.reto5.inventarioapp.modelo.Producto;
import com.reto5.inventarioapp.modelo.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ControladorProducto {

    @Autowired
    RepositorioProducto repositorioProducto;

    public ControladorProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public ArrayList<Producto> obtenerProductos(){
        return (ArrayList<Producto>) repositorioProducto.findAll();
    }

    public void guardarProducto(String nombre, float precio, int inventario){
        System.out.println(nombre);
        Producto producto = new Producto(nombre, precio, inventario);
        repositorioProducto.save(producto);
    }

    public void actualizarProducto(int id, String nombre, float precio, int inventario){
        Producto producto = new Producto( nombre, precio, inventario);
        producto.setCodigo(id);
        repositorioProducto.save(producto);
    }

    public boolean existeProducto(int id){
        return repositorioProducto.existsById(id);
    }

    public void borrarProducto(int id){
        repositorioProducto.deleteById(id);
    }

}
