package main.java.modelo;

public class Carrito {
    private int id;
    private String cliente;
    private String listaVideojuegos;
    private String total;

    public Carrito(int id, String cliente, String listaVideojuegos, String total) {
        this.id = id;
        this.cliente = cliente;
        this listaVideojuegos = listaVideojuegos;
        this.total = total;
        
    }

    public Carrito() {}

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

    public String getlistaVideojuegos() {
        return listaVideojuegos;
    }

    public void sedlistaVideojuegos(String listaVideojuegos) {
        this listaVideojuegos = listaVideojuegos;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   
}

