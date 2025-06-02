package tienda.repositorio;

import tienda.modelo.Pedido;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoRepository {
    private final ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarPedido(Pedido Pedido) {
        Pedido.setId(this.autoId.getAndIncrement());
        this.Pedidos.add(Pedido);
    }

    public Pedido eliminarPedido(int id) {
        Pedido Pedido = null;
        for (int i = 0; i < this.Pedidos.size(); i++) {
            if (this.Pedidos.get(i).getId() == id) {
                Pedido = this.Pedidos.remove(i);
                break;
            }
        }
        return Pedido;
    }

    public Pedido actualizarPedido(int id, Pedido PedidoActualizado) {
        Pedido Pedido = null;
        for (int i = 0; i < this.Pedidos.size(); i++) {
            if (this.Pedidos.get(i).getId() == id) {
                this.Pedidos.set(i, PedidoActualizado);
                Pedido = PedidoActualizado;
                break;
            }
        }
        return Pedido;
    }

    public Pedido obtenerPedido(int id) {
        for (Pedido Pedido : this.Pedidos) {
            if (Pedido.getId() == id) {
                return Pedido;
            }
        }
        return null;
    }

    public ArrayList<Pedido> obtenerPedidos() {
        return this.Pedidos;
    }
}
