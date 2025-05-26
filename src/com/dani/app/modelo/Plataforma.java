package com.dani.app.modelo;

public class Plataforma {
    private int id;
    private String nombre;
    private String fabricante;
    private String tipo;

    public Plataforma(int id, String nombre, String fabricante, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.tipo = tipo;
        
    }

    public Plataforma() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


