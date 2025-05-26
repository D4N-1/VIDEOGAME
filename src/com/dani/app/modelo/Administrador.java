package com.dani.app.modelo;

public class Administrador {
    private int id;
    private String nombre;
    private String usuario;
    private String password;
    private String rol;
    private boolean activo;
    private String descripcion;

    public Administrador(String nombre, String usuario, String password, String rol, boolean activo, String descripcion) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.activo = activo;
        this.descripcion = descripcion;
    }

    public Administrador() {}

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

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getpassword() {
        return password;
    }
    

    public void setpassword(String password) {
        this.password = password;
    }

    
    
    public String getrol() {
        return rol;
    }
    

    public void setrol(String rol) {
        this.rol = rol;
    }

    public boolean getactivo() {
        return activo;
    }

    public void setactivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}




