package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Plataforma;
import tienda.servicio.PlataformaService;

public class PlataformaController {

    private final PlataformaService PlataformaService;

    public PlataformaController(PlataformaService PlataformaService) {
        this.PlataformaService = PlataformaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Plataformas", this::guardarPlataforma);
        app.get("/Plataformas/{id}", this::obtenerPlataforma);
        app.delete("/Plataformas/{id}", this::eliminarPlataforma);
        app.put("/Plataformas/{id}", this::actualizarPlataforma);
        app.get("/Plataformas", this::listarPlataformas);
    }

    public void guardarPlataforma(Context ctx) {
        ctx.contentType("application/json");
        Plataforma Plataforma = ctx.bodyAsClass(Plataforma.class);

        PlataformaService.guardarPlataforma(Plataforma);

        Mensaje<Plataforma> mensaje = new Mensaje<Plataforma>("Plataforma agregado", Plataforma);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerPlataforma(Context ctx) {
        String id = ctx.pathParam("id");
        Plataforma Plataforma = PlataformaService.obtenerPlataforma(id);
        ctx.json(Plataforma);
    }

    public void eliminarPlataforma(Context ctx) {
        String id = ctx.pathParam("id");
        PlataformaService.eliminarPlataforma(id);
        Mensaje<String> mensaje = new Mensaje<>("Plataforma eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarPlataforma(Context ctx) {
        String id = ctx.pathParam("id");
        Plataforma PlataformaActualizado = ctx.bodyAsClass(Plataforma.class);

        PlataformaService.actualizarPlataforma(id, PlataformaActualizado);

        Mensaje<Plataforma> mensaje = new Mensaje<>("Plataforma actualizado", PlataformaActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarPlataformas(Context ctx) {
        ctx.json(PlataformaService.obtenerPlataformas());
    }
}
