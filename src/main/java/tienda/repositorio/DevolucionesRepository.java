package tienda.repositorio;

import tienda.modelo.Devoluciones;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DevolucionesRepository {
    private final ArrayList<Devoluciones> Devolucioness = new ArrayList<Devoluciones>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarDevoluciones(Devoluciones Devoluciones) {
        Devoluciones.setId(this.autoId.getAndIncrement());
        this.Devolucioness.add(Devoluciones);
    }

    public Devoluciones eliminarDevoluciones(int id) {
        Devoluciones Devoluciones = null;
        for (int i = 0; i < this.Devolucioness.size(); i++) {
            if (this.Devolucioness.get(i).getId() == id) {
                Devoluciones = this.Devolucioness.remove(i);
                break;
            }
        }
        return Devoluciones;
    }

    public Devoluciones actualizarDevoluciones(int id, Devoluciones DevolucionesActualizado) {
        Devoluciones Devoluciones = null;
        for (int i = 0; i < this.Devolucioness.size(); i++) {
            if (this.Devolucioness.get(i).getId() == id) {
                this.Devolucioness.set(i, DevolucionesActualizado);
                Devoluciones = DevolucionesActualizado;
                break;
            }
        }
        return Devoluciones;
    }

    public Devoluciones obtenerDevoluciones(int id) {
        for (Devoluciones Devoluciones : this.Devolucioness) {
            if (Devoluciones.getId() == id) {
                return Devoluciones;
            }
        }
        return null;
    }

    public ArrayList<Devoluciones> obtenerDevolucioness() {
        return this.Devolucioness;
    }
}
