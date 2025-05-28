package tienda.modelo;

public class Mensaje {
    private String mensaje;
    private Object detalles;

    public Mensaje(String mensaje, Object detalles) {
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Object getDetalles() {
        return detalles;
    }
}    