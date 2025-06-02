package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Pedido;
import tienda.servicio.PedidoService;

public class PedidoController {

    private final PedidoService PedidoService;

    public PedidoController(PedidoService PedidoService) {
        this.PedidoService = PedidoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Pedidos", this::guardarPedido);
        app.get("/Pedidos/{id}", this::obtenerPedido);
        app.delete("/Pedidos/{id}", this::eliminarPedido);
        app.put("/Pedidos/{id}", this::actualizarPedido);
        app.get("/Pedidos", this::listarPedidos);
    }

    public void guardarPedido(Context ctx) {
        ctx.contentType("application/json");
        Pedido Pedido = ctx.bodyAsClass(Pedido.class);

        PedidoService.guardarPedido(Pedido);

        Mensaje<Pedido> mensaje = new Mensaje<Pedido>("Pedido agregado", Pedido);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerPedido(Context ctx) {
        String id = ctx.pathParam("id");
        Pedido Pedido = PedidoService.obtenerPedido(id);
        ctx.json(Pedido);
    }

    public void eliminarPedido(Context ctx) {
        String id = ctx.pathParam("id");
        PedidoService.eliminarPedido(id);
        Mensaje<String> mensaje = new Mensaje<>("Pedido eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarPedido(Context ctx) {
        String id = ctx.pathParam("id");
        Pedido PedidoActualizado = ctx.bodyAsClass(Pedido.class);

        PedidoService.actualizarPedido(id, PedidoActualizado);

        Mensaje<Pedido> mensaje = new Mensaje<>("Pedido actualizado", PedidoActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarPedidos(Context ctx) {
        ctx.json(PedidoService.obtenerPedidos());
    }
}
