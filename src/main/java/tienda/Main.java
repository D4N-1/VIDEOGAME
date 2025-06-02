package tienda;

import io.javalin.Javalin;
import tienda.controlador.exceptionController;
import tienda.controlador.HealthController;
import tienda.repositorio.ProductosRepository;
import tienda.servicio.ProductoService;
import tienda.controlador.ProductoController;
import tienda.repositorio.PlataformaRepository;
import tienda.servicio.PlataformaService;
import tienda.controlador.PlataformaController;


public class Main {
    public static void main(String[] args) {
        ProductosRepository productosRepository = new ProductosRepository();
        ProductoService productoService = new ProductoService(productosRepository);
        ProductoController productoController = new ProductoController(productoService);

        PlataformaRepository PlataformaRepository = new PlataformaRepository();
        PlataformaService plataformaService = new PlataformaService(PlataformaRepository);
        PlataformaController plataformaController = new PlataformaController(plataformaService);
        
        exceptionController exceptionController = new exceptionController();
        HealthController healthController = new HealthController();
        

        var app = Javalin.create();
        exceptionController.iniciarControl(app);

        healthController.configurarRutas(app);
        productoController.configurarRutas(app);
        plataformaController.configurarRutas(app);
    
        app.before(ctx -> ctx.header("Content-Type", "application/json"));

        app.start(7000);
    }
}
