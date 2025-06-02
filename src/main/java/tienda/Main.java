package tienda;

import io.javalin.Javalin;
import tienda.controlador.UsuarioController;  // <--- Aquí va el punto y coma
import tienda.controlador.exceptionController;
//import tienda.controlador.HealthController;
//import tienda.controlador.ProductoController;
import tienda.repositorio.ProductosRepository;
//import tienda.service.ProductoService;
import tienda.servicio.ProductoService;

public class Main {
    public static void main(String[] args) {
        ProductosRepository productosRepository = new ProductosRepository();
        ProductoService productoService = new ProductoService(productosRepository);
        /*ProductoController productoController = new ProductoController(productoService);
        ExceptionController exceptionController = new ExceptionController();
        HealthController healthController = new HealthController();
        */

        var app = Javalin.create();

        /*
        exceptionController.iniciarControl(app);

        healthController.configurarRutas(app);
        productoController.configurarRutas(app);
        */

        app.before(ctx -> ctx.header("Content-Type", "application/json"));

        app.start(7000);
    }
}
