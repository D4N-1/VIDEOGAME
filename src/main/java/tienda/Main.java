package tienda;

import io.javalin.Javalin;
import tienda.controlador.UsuarioController;  // <--- Aquí va el punto y coma

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        UsuarioController usuarioController = new UsuarioController();
        usuarioController.registerRoutes(app);
    }
}
