package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Servicio;
import tienda.servicio.ServicioService;

public class ServicioController {

    private final ServicioService ServicioService;

    public ServicioController(ServicioService ServicioService) {
        this.ServicioService = ServicioService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Servicios", this::guardarServicio);
        app.get("/Servicios/{id}", this::obtenerServicio);
        app.delete("/Servicios/{id}", this::eliminarServicio);
        app.put("/Servicios/{id}", this::actualizarServicio);
        app.get("/Servicios", this::listarServicios);
    }

    public void guardarServicio(Context ctx) {
        ctx.contentType("application/json");
        Servicio Servicio = ctx.bodyAsClass(Servicio.class);

        ServicioService.guardarServicio(Servicio);

        Mensaje<Servicio> mensaje = new Mensaje<Servicio>("Servicio agregado", Servicio);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerServicio(Context ctx) {
        String id = ctx.pathParam("id");
        Servicio Servicio = ServicioService.obtenerServicio(id);
        ctx.json(Servicio);
    }

    public void eliminarServicio(Context ctx) {
        String id = ctx.pathParam("id");
        ServicioService.eliminarServicio(id);
        Mensaje<String> mensaje = new Mensaje<>("Servicio eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarServicio(Context ctx) {
        String id = ctx.pathParam("id");
        Servicio ServicioActualizado = ctx.bodyAsClass(Servicio.class);

        ServicioService.actualizarServicio(id, ServicioActualizado);

        Mensaje<Servicio> mensaje = new Mensaje<>("Servicio actualizado", ServicioActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarServicios(Context ctx) {
        ctx.json(ServicioService.obtenerServicios());
    }
}
