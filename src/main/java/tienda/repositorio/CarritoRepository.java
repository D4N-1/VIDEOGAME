package tienda.repositorio;

import tienda.modelo.Carrito;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CarritoRepository {
    private final ArrayList<Carrito> Carritos = new ArrayList<Carrito>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarCarrito(Carrito Carrito) {
        Carrito.setId(this.autoId.getAndIncrement());
        this.Carritos.add(Carrito);
    }

    public Carrito eliminarCarrito(int id) {
        Carrito Carrito = null;
        for (int i = 0; i < this.Carritos.size(); i++) {
            if (this.Carritos.get(i).getId() == id) {
                Carrito = this.Carritos.remove(i);
                break;
            }
        }
        return Carrito;
    }

    public Carrito actualizarCarrito(int id, Carrito CarritoActualizado) {
        Carrito Carrito = null;
        for (int i = 0; i < this.Carritos.size(); i++) {
            if (this.Carritos.get(i).getId() == id) {
                this.Carritos.set(i, CarritoActualizado);
                Carrito = CarritoActualizado;
                break;
            }
        }
        return Carrito;
    }

    public Carrito obtenerCarrito(int id) {
        for (Carrito Carrito : this.Carritos) {
            if (Carrito.getId() == id) {
                return Carrito;
            }
        }
        return null;
    }

    public ArrayList<Carrito> obtenerCarritos() {
        return this.Carritos;
    }
    
}
