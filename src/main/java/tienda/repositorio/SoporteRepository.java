package tienda.repositorio;

import tienda.modelo.Soporte;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SoporteRepository {
    private final ArrayList<Soporte> Soportes = new ArrayList<Soporte>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarSoporte(Soporte Soporte) {
        Soporte.setId(this.autoId.getAndIncrement());
        this.Soportes.add(Soporte);
    }

    public Soporte eliminarSoporte(int id) {
        Soporte Soporte = null;
        for (int i = 0; i < this.Soportes.size(); i++) {
            if (this.Soportes.get(i).getId() == id) {
                Soporte = this.Soportes.remove(i);
                break;
            }
        }
        return Soporte;
    }

    public Soporte actualizarSoporte(int id, Soporte SoporteActualizado) {
        Soporte Soporte = null;
        for (int i = 0; i < this.Soportes.size(); i++) {
            if (this.Soportes.get(i).getId() == id) {
                this.Soportes.set(i, SoporteActualizado);
                Soporte = SoporteActualizado;
                break;
            }
        }
        return Soporte;
    }

    public Soporte obtenerSoporte(int id) {
        for (Soporte Soporte : this.Soportes) {
            if (Soporte.getId() == id) {
                return Soporte;
            }
        }
        return null;
    }

    public ArrayList<Soporte> obtenerSoportes() {
        return this.Soportes;
    }
    
}
