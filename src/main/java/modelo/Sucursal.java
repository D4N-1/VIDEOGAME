package main.java.modelo;

public class Sucursal {
    private int id;
    private String direccion;
    private String telefono;
    private String nombreGerente;

    public Sucursal(int id, String direccion, String telefono, String nombreGerente) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreGerente = nombreGerente;
        
    }

    public Sucursal() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

      public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   public String getNombreGerente() {
        return nombreGerente;
    }

    public void setNombreGerente(String nombreGerente) {
        this.nombreGerente = nombreGerente;
    }
}


