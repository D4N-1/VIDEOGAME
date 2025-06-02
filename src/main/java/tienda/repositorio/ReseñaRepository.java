package tienda.repositorio;

import tienda.modelo.Reseña;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReseñaRepository {
    private final ArrayList<Reseña> Reseñas = new ArrayList<Reseña>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarReseña(Reseña Reseña) {
        Reseña.setId(this.autoId.getAndIncrement());
        this.Reseñas.add(Reseña);
    }

    public Reseña eliminarReseña(int id) {
        Reseña Reseña = null;
        for (int i = 0; i < this.Reseñas.size(); i++) {
            if (this.Reseñas.get(i).getId() == id) {
                Reseña = this.Reseñas.remove(i);
                break;
            }
        }
        return Reseña;
    }

    public Reseña actualizarReseña(int id, Reseña ReseñaActualizado) {
        Reseña Reseña = null;
        for (int i = 0; i < this.Reseñas.size(); i++) {
            if (this.Reseñas.get(i).getId() == id) {
                this.Reseñas.set(i, ReseñaActualizado);
                Reseña = ReseñaActualizado;
                break;
            }
        }
        return Reseña;
    }

    public Reseña obtenerReseña(int id) {
        for (Reseña Reseña : this.Reseñas) {
            if (Reseña.getId() == id) {
                return Reseña;
            }
        }
        return null;
    }

    public ArrayList<Reseña> obtenerReseñas() {
        return this.Reseñas;
    }
}
