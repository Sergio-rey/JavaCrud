package com.reto5.inventarioapp.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Productos")
public class Producto {

    @Id
    @Column("ID")
    private int codigo;
    @Column("NOMBRE")
    private String name;
    @Column("PRECIO")
    private float precio;
    @Column("INVENTARIO")
    private int inventario;

    public Producto() {
        super();
    }

    public Producto( String name, float precio, int inventario) {
        super();
        this.name = name;
        this.precio = precio;
        this.inventario = inventario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}