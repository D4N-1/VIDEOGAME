package tienda.controlador;
import io.javalin.Javalin;

public class UsuarioController {

    public void registerRoutes(Javalin app) {
        app.get("/usuarios", ctx -> {
            ctx.result("Lista de usuarios");
        });

        app.post("/usuarios", ctx -> {
            // Aquí iría la lógica para crear un usuario
            ctx.result("Usuario creado");
        });
    }
}
