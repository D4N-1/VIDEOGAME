package tienda.exception;


public class BadParameterException extends RuntimeException {
    public BadParameterException(String mensaje) {
        super(mensaje);
    }
}
