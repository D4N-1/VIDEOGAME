package tienda.repositorio;

import tienda.modelo.Proveedor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ProveedorRepository {
    private final ArrayList<Proveedor> Proveedors = new ArrayList<Proveedor>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarProveedor(Proveedor Proveedor) {
        Proveedor.setId(this.autoId.getAndIncrement());
        this.Proveedors.add(Proveedor);
    }

    public Proveedor eliminarProveedor(int id) {
        Proveedor Proveedor = null;
        for (int i = 0; i < this.Proveedors.size(); i++) {
            if (this.Proveedors.get(i).getId() == id) {
                Proveedor = this.Proveedors.remove(i);
                break;
            }
        }
        return Proveedor;
    }

    public Proveedor actualizarProveedor(int id, Proveedor ProveedorActualizado) {
        Proveedor Proveedor = null;
        for (int i = 0; i < this.Proveedors.size(); i++) {
            if (this.Proveedors.get(i).getId() == id) {
                this.Proveedors.set(i, ProveedorActualizado);
                Proveedor = ProveedorActualizado;
                break;
            }
        }
        return Proveedor;
    }

    public Proveedor obtenerProveedor(int id) {
        for (Proveedor Proveedor : this.Proveedors) {
            if (Proveedor.getId() == id) {
                return Proveedor;
            }
        }
        return null;
    }

    public ArrayList<Proveedor> obtenerProveedors() {
        return this.Proveedors;
    }
    
}
