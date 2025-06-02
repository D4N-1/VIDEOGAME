package tienda.controlador;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Mensaje;

public class exceptionController {

    public void iniciarControl(Javalin app) {
app.exception(NotFoundResponse.class, (e, ctx) -> {
    Mensaje<Object> mensaje = new Mensaje<>(e.getMessage(), null);
    ctx.status(404);
    ctx.json(mensaje);
});

app.exception(BadParameterException.class, (e, ctx) -> {
    Mensaje<Object> mensaje = new Mensaje<>(e.getMessage(), null);
    ctx.status(400);
    ctx.json(mensaje);
});

app.exception(NotFoundException.class, (e, ctx) -> {
    Mensaje<Object> mensaje = new Mensaje<>(e.getMessage(), null);
    ctx.status(400);
    ctx.json(mensaje);
});

    }
}

