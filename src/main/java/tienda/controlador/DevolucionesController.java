package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Devoluciones;
import tienda.servicio.DevolucionesService;

public class DevolucionesController {

    private final DevolucionesService DevolucionesService;

    public DevolucionesController(DevolucionesService DevolucionesService) {
        this.DevolucionesService = DevolucionesService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Devolucioness", this::guardarDevoluciones);
        app.get("/Devolucioness/{id}", this::obtenerDevoluciones);
        app.delete("/Devolucioness/{id}", this::eliminarDevoluciones);
        app.put("/Devolucioness/{id}", this::actualizarDevoluciones);
        app.get("/Devolucioness", this::listarDevolucioness);
    }

    public void guardarDevoluciones(Context ctx) {
        ctx.contentType("application/json");
        Devoluciones Devoluciones = ctx.bodyAsClass(Devoluciones.class);

        DevolucionesService.guardarDevoluciones(Devoluciones);

        Mensaje<Devoluciones> mensaje = new Mensaje<Devoluciones>("Devoluciones agregado", Devoluciones);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerDevoluciones(Context ctx) {
        String id = ctx.pathParam("id");
        Devoluciones Devoluciones = DevolucionesService.obtenerDevoluciones(id);
        ctx.json(Devoluciones);
    }

    public void eliminarDevoluciones(Context ctx) {
        String id = ctx.pathParam("id");
        DevolucionesService.eliminarDevoluciones(id);
        Mensaje<String> mensaje = new Mensaje<>("Devoluciones eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarDevoluciones(Context ctx) {
        String id = ctx.pathParam("id");
        Devoluciones DevolucionesActualizado = ctx.bodyAsClass(Devoluciones.class);

        DevolucionesService.actualizarDevoluciones(id, DevolucionesActualizado);

        Mensaje<Devoluciones> mensaje = new Mensaje<>("Devoluciones actualizado", DevolucionesActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarDevolucioness(Context ctx) {
        ctx.json(DevolucionesService.obtenerDevolucioness());
    }
}
