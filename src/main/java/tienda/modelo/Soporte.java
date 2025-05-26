package main.java.tienda.modelo;

public class Soporte {
    private int id;
    private String cliente;
    private String descripcion;
    private String estado;
    private String fecha;

    public Soporte(int id, String cliente, String descripcion, String estado, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        
    }

    public Soporte() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
}


