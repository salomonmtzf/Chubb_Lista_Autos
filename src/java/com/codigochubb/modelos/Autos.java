package com.codigochubb.modelos;

public class Autos 
{
    private int id;
    private String marca,cantidad,inventario;

    public Autos() {
    }

    public Autos(String marca, String cantidad, String inventario) {
        this.marca = marca;
        this.cantidad = cantidad;
        this.inventario = inventario;
    }

    public Autos(int id, String marca, String cantidad, String inventario) {
        this.id = id;
        this.marca = marca;
        this.cantidad = cantidad;
        this.inventario = inventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    
}
