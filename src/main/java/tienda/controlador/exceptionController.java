package tienda.controlador;
import io.javalin.Javalin;
import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Mensaje;

public class exceptionController {

    public void iniciarControl(Javalin app) {
        app.exception(NotFoundException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), null);
            ctx.status(404);
            ctx.json(mensaje);
        });

        app.exception(BadParameterException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), null);
            ctx.status(400);
            ctx.json(mensaje);
        });
    }
}

