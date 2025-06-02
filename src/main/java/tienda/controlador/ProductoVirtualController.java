package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.ProductoVirtual;
import tienda.servicio.ProductoVirtualService;

public class ProductoVirtualController {

    private final ProductoVirtualService ProductoVirtualService;

    public ProductoVirtualController(ProductoVirtualService ProductoVirtualService) {
        this.ProductoVirtualService = ProductoVirtualService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/ProductoVirtuals", this::guardarProductoVirtual);
        app.get("/ProductoVirtuals/{id}", this::obtenerProductoVirtual);
        app.delete("/ProductoVirtuals/{id}", this::eliminarProductoVirtual);
        app.put("/ProductoVirtuals/{id}", this::actualizarProductoVirtual);
        app.get("/ProductoVirtuals", this::listarProductoVirtuals);
    }

    public void guardarProductoVirtual(Context ctx) {
        ctx.contentType("application/json");
        ProductoVirtual ProductoVirtual = ctx.bodyAsClass(ProductoVirtual.class);

        ProductoVirtualService.guardarProductoVirtual(ProductoVirtual);

        Mensaje<ProductoVirtual> mensaje = new Mensaje<ProductoVirtual>("ProductoVirtual agregado", ProductoVirtual);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerProductoVirtual(Context ctx) {
        String id = ctx.pathParam("id");
        ProductoVirtual ProductoVirtual = ProductoVirtualService.obtenerProductoVirtual(id);
        ctx.json(ProductoVirtual);
    }

    public void eliminarProductoVirtual(Context ctx) {
        String id = ctx.pathParam("id");
        ProductoVirtualService.eliminarProductoVirtual(id);
        Mensaje<String> mensaje = new Mensaje<>("ProductoVirtual eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarProductoVirtual(Context ctx) {
        String id = ctx.pathParam("id");
        ProductoVirtual ProductoVirtualActualizado = ctx.bodyAsClass(ProductoVirtual.class);

        ProductoVirtualService.actualizarProductoVirtual(id, ProductoVirtualActualizado);

        Mensaje<ProductoVirtual> mensaje = new Mensaje<>("ProductoVirtual actualizado", ProductoVirtualActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarProductoVirtuals(Context ctx) {
        ctx.json(ProductoVirtualService.obtenerProductoVirtuals());
    }
}
