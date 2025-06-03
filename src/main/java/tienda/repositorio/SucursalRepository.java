package tienda.repositorio;

import tienda.modelo.Sucursal;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SucursalRepository {
    private final ArrayList<Sucursal> Sucursals = new ArrayList<Sucursal>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarSucursal(Sucursal Sucursal) {
        Sucursal.setId(this.autoId.getAndIncrement());
        this.Sucursals.add(Sucursal);
    }

    public Sucursal eliminarSucursal(int id) {
        Sucursal Sucursal = null;
        for (int i = 0; i < this.Sucursals.size(); i++) {
            if (this.Sucursals.get(i).getId() == id) {
                Sucursal = this.Sucursals.remove(i);
                break;
            }
        }
        return Sucursal;
    }

    public Sucursal actualizarSucursal(int id, Sucursal SucursalActualizado) {
        Sucursal Sucursal = null;
        for (int i = 0; i < this.Sucursals.size(); i++) {
            if (this.Sucursals.get(i).getId() == id) {
                this.Sucursals.set(i, SucursalActualizado);
                Sucursal = SucursalActualizado;
                break;
            }
        }
        return Sucursal;
    }

    public Sucursal obtenerSucursal(int id) {
        for (Sucursal Sucursal : this.Sucursals) {
            if (Sucursal.getId() == id) {
                return Sucursal;
            }
        }
        return null;
    }

    public ArrayList<Sucursal> obtenerSucursals() {
        return this.Sucursals;
    }
    
}
