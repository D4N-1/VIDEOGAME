package tienda.controlador;


import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Sucursal;
import tienda.servicio.SucursalService;

public class SucursalController {
    private final SucursalService SucursalService;

    public SucursalController(SucursalService SucursalService) {
        this.SucursalService = SucursalService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Sucursal", this::guardarSucursal);
        app.get("/Sucursal/{id}", this::obtenerSucursal);
        app.delete("/Sucursal/{id}", this::eliminarSucursal);
        app.put("/Sucursal/{id}", this::actualizarSucursal);
        app.get("/Sucursal", this::listarSucursals);
    }

    public void guardarSucursal(Context ctx) {
        ctx.contentType("application/json");
        Sucursal Sucursal = ctx.bodyAsClass(Sucursal.class);

        SucursalService.guardarSucursal(Sucursal);

        Mensaje<Sucursal> mensaje = new Mensaje<Sucursal>("Sucursal agregado", Sucursal);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerSucursal(Context ctx) {
        String id = ctx.pathParam("id");
        Sucursal Sucursal = SucursalService.obtenerSucursal(id);
        ctx.json(Sucursal);
    }

    public void eliminarSucursal(Context ctx) {
        String id = ctx.pathParam("id");
        SucursalService.eliminarSucursal(id);
        Mensaje<String> mensaje = new Mensaje<>("Sucursal eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarSucursal(Context ctx) {
        String id = ctx.pathParam("id");
        Sucursal SucursalActualizado = ctx.bodyAsClass(Sucursal.class);

        SucursalService.actualizarSucursal(id, SucursalActualizado);

        Mensaje<Sucursal> mensaje = new Mensaje<>("Sucursal actualizado", SucursalActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarSucursals(Context ctx) {
        ctx.json(SucursalService.obtenerSucursals());
    }

    
}