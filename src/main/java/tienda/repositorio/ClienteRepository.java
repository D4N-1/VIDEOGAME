package tienda.repositorio;

import tienda.modelo.Cliente;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteRepository {
    private final ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarCliente(Cliente Cliente) {
        Cliente.setId(this.autoId.getAndIncrement());
        this.Clientes.add(Cliente);
    }

    public Cliente eliminarCliente(int id) {
        Cliente Cliente = null;
        for (int i = 0; i < this.Clientes.size(); i++) {
            if (this.Clientes.get(i).getId() == id) {
                Cliente = this.Clientes.remove(i);
                break;
            }
        }
        return Cliente;
    }

    public Cliente actualizarCliente(int id, Cliente ClienteActualizado) {
        Cliente Cliente = null;
        for (int i = 0; i < this.Clientes.size(); i++) {
            if (this.Clientes.get(i).getId() == id) {
                this.Clientes.set(i, ClienteActualizado);
                Cliente = ClienteActualizado;
                break;
            }
        }
        return Cliente;
    }

    public Cliente obtenerCliente(int id) {
        for (Cliente Cliente : this.Clientes) {
            if (Cliente.getId() == id) {
                return Cliente;
            }
        }
        return null;
    }

    public ArrayList<Cliente> obtenerClientes() {
        return this.Clientes;
    }
    
}
