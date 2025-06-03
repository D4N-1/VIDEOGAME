package tienda.controlador;


import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Proveedor;
import tienda.servicio.ProveedorService;

public class ProveedorController {
    private final ProveedorService ProveedorService;

    public ProveedorController(ProveedorService ProveedorService) {
        this.ProveedorService = ProveedorService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Proveedor", this::guardarProveedor);
        app.get("/Proveedor/{id}", this::obtenerProveedor);
        app.delete("/Proveedor/{id}", this::eliminarProveedor);
        app.put("/Proveedor/{id}", this::actualizarProveedor);
        app.get("/Proveedor", this::listarProveedor);
    }

    public void guardarProveedor(Context ctx) {
        ctx.contentType("application/json");
        Proveedor Proveedor = ctx.bodyAsClass(Proveedor.class);

        ProveedorService.guardarProveedor(Proveedor);

        Mensaje<Proveedor> mensaje = new Mensaje<Proveedor>("Proveedor agregado", Proveedor);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerProveedor(Context ctx) {
        String id = ctx.pathParam("id");
        Proveedor Proveedor = ProveedorService.obtenerProveedor(id);
        ctx.json(Proveedor);
    }

    public void eliminarProveedor(Context ctx) {
        String id = ctx.pathParam("id");
        ProveedorService.eliminarProveedor(id);
        Mensaje<String> mensaje = new Mensaje<>("Proveedor eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarProveedor(Context ctx) {
        String id = ctx.pathParam("id");
        Proveedor ProveedorActualizado = ctx.bodyAsClass(Proveedor.class);

        ProveedorService.actualizarProveedor(id, ProveedorActualizado);

        Mensaje<Proveedor> mensaje = new Mensaje<>("Proveedor actualizado", ProveedorActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarProveedor(Context ctx) {
        ctx.json(ProveedorService.obtenerProveedors());
    }

    
}