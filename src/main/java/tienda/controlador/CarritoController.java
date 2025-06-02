package tienda.controlador;


import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Carrito;
import tienda.servicio.CarritoService;

public class CarritoController {

    private final CarritoService CarritoService;

    public CarritoController(CarritoService CarritoService) {
        this.CarritoService = CarritoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Carritos", this::guardarCarrito);
        app.get("/Carritos/{id}", this::obtenerCarrito);
        app.delete("/Carritos/{id}", this::eliminarCarrito);
        app.put("/Carritos/{id}", this::actualizarCarrito);
        app.get("/Carritos", this::listarCarritos);
    }

    public void guardarCarrito(Context ctx) {
        ctx.contentType("application/json");
        Carrito Carrito = ctx.bodyAsClass(Carrito.class);

        CarritoService.guardarCarrito(Carrito);

        Mensaje<Carrito> mensaje = new Mensaje<Carrito>("Carrito agregado", Carrito);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerCarrito(Context ctx) {
        String id = ctx.pathParam("id");
        Carrito Carrito = CarritoService.obtenerCarrito(id);
        ctx.json(Carrito);
    }

    public void eliminarCarrito(Context ctx) {
        String id = ctx.pathParam("id");
        CarritoService.eliminarCarrito(id);
        Mensaje<String> mensaje = new Mensaje<>("Carrito eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarCarrito(Context ctx) {
        String id = ctx.pathParam("id");
        Carrito CarritoActualizado = ctx.bodyAsClass(Carrito.class);

        CarritoService.actualizarCarrito(id, CarritoActualizado);

        Mensaje<Carrito> mensaje = new Mensaje<>("Carrito actualizado", CarritoActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarCarritos(Context ctx) {
        ctx.json(CarritoService.obtenerCarritos());
    }
}