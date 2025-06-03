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
import tienda.repositorio.DevolucionesRepository;
import tienda.servicio.DevolucionesService;
import tienda.controlador.DevolucionesController;
import tienda.repositorio.PedidoRepository;
import tienda.servicio.PedidoService;
import tienda.controlador.PedidoController;
import tienda.repositorio.FacturaRepository;
import tienda.servicio.FacturaService;
import tienda.controlador.FacturaController;
import tienda.repositorio.ProductoVirtualRepository;
import tienda.servicio.ProductoVirtualService;
import tienda.controlador.ProductoVirtualController;
import tienda.repositorio.ReseñaRepository;
import tienda.servicio.ReseñaService;
import tienda.controlador.ReseñaController;
import tienda.repositorio.ServicioRepository;
import tienda.servicio.ServicioService;
import tienda.controlador.ServicioController;

import tienda.repositorio.CarritoRepository;
import tienda.servicio.CarritoService;
import tienda.controlador.CarritoController;

import tienda.repositorio.ClienteRepository;
import tienda.servicio.ClienteService;
import tienda.controlador.ClienteController;

public class Main {
    public static void main(String[] args) {
        ProductosRepository productosRepository = new ProductosRepository();
        ProductoService productoService = new ProductoService(productosRepository);
        ProductoController productoController = new ProductoController(productoService);

        PlataformaRepository PlataformaRepository = new PlataformaRepository();
        PlataformaService plataformaService = new PlataformaService(PlataformaRepository);
        PlataformaController plataformaController = new PlataformaController(plataformaService);

        DevolucionesRepository DevolucionesRepository = new DevolucionesRepository();
        DevolucionesService devolucionesService = new DevolucionesService(DevolucionesRepository);
        DevolucionesController devolucionesController = new DevolucionesController(devolucionesService);

        PedidoRepository PedidoRepository = new PedidoRepository();
        PedidoService pedidoService = new PedidoService(PedidoRepository);
        PedidoController pedidoController = new PedidoController(pedidoService);


        FacturaRepository facturaRepository = new FacturaRepository();
        FacturaService facturaService = new FacturaService(facturaRepository);
        FacturaController facturaController = new FacturaController(facturaService);

        ProductoVirtualRepository productoVirtualRepository = new ProductoVirtualRepository();
        ProductoVirtualService productoVirtualService = new ProductoVirtualService(productoVirtualRepository);
        ProductoVirtualController productoVirtualController = new ProductoVirtualController(productoVirtualService);

        ReseñaRepository reseñaRepository = new ReseñaRepository();
        ReseñaService reseñaService = new ReseñaService(reseñaRepository);
        ReseñaController reseñaController = new ReseñaController(reseñaService);

        ServicioRepository servicioRepository = new ServicioRepository();
        ServicioService servicioService = new ServicioService(servicioRepository);
        ServicioController servicioController = new ServicioController(servicioService);

        CarritoRepository carritoRepository = new CarritoRepository();
        CarritoService carritoService = new CarritoService(carritoRepository);
        CarritoController carritoController = new CarritoController(carritoService);

        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteService);
        
        
        exceptionController exceptionController = new exceptionController();
        HealthController healthController = new HealthController();
        

        var app = Javalin.create();
        exceptionController.iniciarControl(app);

        healthController.configurarRutas(app);
        productoController.configurarRutas(app);
        plataformaController.configurarRutas(app);
        devolucionesController.configurarRutas(app);
        facturaController.configurarRutas(app);
        pedidoController.configurarRutas(app);
        productoVirtualController.configurarRutas(app);
        reseñaController.configurarRutas(app);
        servicioController.configurarRutas(app);
        carritoController.configurarRutas(app);
        clienteController.configurarRutas(app);
    
    
        app.before(ctx -> ctx.header("Content-Type", "application/json"));

        app.start(7071);
    }
}
