package tienda.controlador;

import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Factura;
import tienda.servicio.FacturaService;

public class FacturaController {

    private final FacturaService FacturaService;

    public FacturaController(FacturaService FacturaService) {
        this.FacturaService = FacturaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Facturas", this::guardarFactura);
        app.get("/Facturas/{id}", this::obtenerFactura);
        app.delete("/Facturas/{id}", this::eliminarFactura);
        app.put("/Facturas/{id}", this::actualizarFactura);
        app.get("/Facturas", this::listarFacturas);
    }

    public void guardarFactura(Context ctx) {
        ctx.contentType("application/json");
        Factura Factura = ctx.bodyAsClass(Factura.class);

        FacturaService.guardarFactura(Factura);

        Mensaje<Factura> mensaje = new Mensaje<Factura>("Factura agregado", Factura);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerFactura(Context ctx) {
        String id = ctx.pathParam("id");
        Factura Factura = FacturaService.obtenerFactura(id);
        ctx.json(Factura);
    }

    public void eliminarFactura(Context ctx) {
        String id = ctx.pathParam("id");
        FacturaService.eliminarFactura(id);
        Mensaje<String> mensaje = new Mensaje<>("Factura eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarFactura(Context ctx) {
        String id = ctx.pathParam("id");
        Factura FacturaActualizado = ctx.bodyAsClass(Factura.class);

        FacturaService.actualizarFactura(id, FacturaActualizado);

        Mensaje<Factura> mensaje = new Mensaje<>("Factura actualizado", FacturaActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarFacturas(Context ctx) {
        ctx.json(FacturaService.obtenerFacturas());
    }
}
