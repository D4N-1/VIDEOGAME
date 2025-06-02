package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Reseña;
import tienda.servicio.ReseñaService;

public class ReseñaController {

    private final ReseñaService ReseñaService;

    public ReseñaController(ReseñaService ReseñaService) {
        this.ReseñaService = ReseñaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Reseñas", this::guardarReseña);
        app.get("/Reseñas/{id}", this::obtenerReseña);
        app.delete("/Reseñas/{id}", this::eliminarReseña);
        app.put("/Reseñas/{id}", this::actualizarReseña);
        app.get("/Reseñas", this::listarReseñas);
    }

    public void guardarReseña(Context ctx) {
        ctx.contentType("application/json");
        Reseña Reseña = ctx.bodyAsClass(Reseña.class);

        ReseñaService.guardarReseña(Reseña);

        Mensaje<Reseña> mensaje = new Mensaje<Reseña>("Reseña agregado", Reseña);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerReseña(Context ctx) {
        String id = ctx.pathParam("id");
        Reseña Reseña = ReseñaService.obtenerReseña(id);
        ctx.json(Reseña);
    }

    public void eliminarReseña(Context ctx) {
        String id = ctx.pathParam("id");
        ReseñaService.eliminarReseña(id);
        Mensaje<String> mensaje = new Mensaje<>("Reseña eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarReseña(Context ctx) {
        String id = ctx.pathParam("id");
        Reseña ReseñaActualizado = ctx.bodyAsClass(Reseña.class);

        ReseñaService.actualizarReseña(id, ReseñaActualizado);

        Mensaje<Reseña> mensaje = new Mensaje<>("Reseña actualizado", ReseñaActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarReseñas(Context ctx) {
        ctx.json(ReseñaService.obtenerReseñas());
    }
}
