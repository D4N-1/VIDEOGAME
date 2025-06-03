package tienda.controlador;


import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Soporte;
import tienda.servicio.SoporteService;

public class SoporteController {
    private final SoporteService SoporteService;

    public SoporteController(SoporteService SoporteService) {
        this.SoporteService = SoporteService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Soportes", this::guardarSoporte);
        app.get("/Soportes/{id}", this::obtenerSoporte);
        app.delete("/Soportes/{id}", this::eliminarSoporte);
        app.put("/Soportes/{id}", this::actualizarSoporte);
        app.get("/Soportes", this::listarSoportes);
    }

    public void guardarSoporte(Context ctx) {
        ctx.contentType("application/json");
        Soporte Soporte = ctx.bodyAsClass(Soporte.class);

        SoporteService.guardarSoporte(Soporte);

        Mensaje<Soporte> mensaje = new Mensaje<Soporte>("Soporte agregado", Soporte);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerSoporte(Context ctx) {
        String id = ctx.pathParam("id");
        Soporte Soporte = SoporteService.obtenerSoporte(id);
        ctx.json(Soporte);
    }

    public void eliminarSoporte(Context ctx) {
        String id = ctx.pathParam("id");
        SoporteService.eliminarSoporte(id);
        Mensaje<String> mensaje = new Mensaje<>("Soporte eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarSoporte(Context ctx) {
        String id = ctx.pathParam("id");
        Soporte SoporteActualizado = ctx.bodyAsClass(Soporte.class);

        SoporteService.actualizarSoporte(id, SoporteActualizado);

        Mensaje<Soporte> mensaje = new Mensaje<>("Soporte actualizado", SoporteActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarSoportes(Context ctx) {
        ctx.json(SoporteService.obtenerSoportes());
    }

    
}