package tienda.controlador;


import io.javalin.Javalin;
import io.javalin.http.Context;
import tienda.modelo.Mensaje;
import tienda.modelo.Cliente;
import tienda.servicio.ClienteService;

public class ClienteController {
    private final ClienteService ClienteService;

    public ClienteController(ClienteService ClienteService) {
        this.ClienteService = ClienteService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/Clientes", this::guardarCliente);
        app.get("/Clientes/{id}", this::obtenerCliente);
        app.delete("/Clientes/{id}", this::eliminarCliente);
        app.put("/Clientes/{id}", this::actualizarCliente);
        app.get("/Clientes", this::listarClientes);
    }

    public void guardarCliente(Context ctx) {
        ctx.contentType("application/json");
        Cliente Cliente = ctx.bodyAsClass(Cliente.class);

        ClienteService.guardarCliente(Cliente);

        Mensaje<Cliente> mensaje = new Mensaje<Cliente>("Cliente agregado", Cliente);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerCliente(Context ctx) {
        String id = ctx.pathParam("id");
        Cliente Cliente = ClienteService.obtenerCliente(id);
        ctx.json(Cliente);
    }

    public void eliminarCliente(Context ctx) {
        String id = ctx.pathParam("id");
        ClienteService.eliminarCliente(id);
        Mensaje<String> mensaje = new Mensaje<>("Cliente eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarCliente(Context ctx) {
        String id = ctx.pathParam("id");
        Cliente ClienteActualizado = ctx.bodyAsClass(Cliente.class);

        ClienteService.actualizarCliente(id, ClienteActualizado);

        Mensaje<Cliente> mensaje = new Mensaje<>("Cliente actualizado", ClienteActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarClientes(Context ctx) {
        ctx.json(ClienteService.obtenerClientes());
    }

    
}