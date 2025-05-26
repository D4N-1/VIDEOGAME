package main.java.modelo;

public class Carrito {
    private int id;
    private String cliente;
    private String lista;
    private String total;

    public Carrito(int id, String cliente, String lista, String total) {
        this.id = id;
        this.cliente = cliente;
        this.lista = lista;
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

    public String getlista() {
        return lista;
    }

    public void sedlista(String lista) {
        this.lista = lista;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   
}

