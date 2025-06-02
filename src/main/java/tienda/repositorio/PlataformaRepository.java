package tienda.repositorio;

import tienda.modelo.Plataforma;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PlataformaRepository {
    private final ArrayList<Plataforma> Plataformas = new ArrayList<Plataforma>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarPlataforma(Plataforma Plataforma) {
        Plataforma.setId(this.autoId.getAndIncrement());
        this.Plataformas.add(Plataforma);
    }

    public Plataforma eliminarPlataforma(int id) {
        Plataforma Plataforma = null;
        for (int i = 0; i < this.Plataformas.size(); i++) {
            if (this.Plataformas.get(i).getId() == id) {
                Plataforma = this.Plataformas.remove(i);
                break;
            }
        }
        return Plataforma;
    }

    public Plataforma actualizarPlataforma(int id, Plataforma PlataformaActualizado) {
        Plataforma Plataforma = null;
        for (int i = 0; i < this.Plataformas.size(); i++) {
            if (this.Plataformas.get(i).getId() == id) {
                this.Plataformas.set(i, PlataformaActualizado);
                Plataforma = PlataformaActualizado;
                break;
            }
        }
        return Plataforma;
    }

    public Plataforma obtenerPlataforma(int id) {
        for (Plataforma Plataforma : this.Plataformas) {
            if (Plataforma.getId() == id) {
                return Plataforma;
            }
        }
        return null;
    }

    public ArrayList<Plataforma> obtenerPlataformas() {
        return this.Plataformas;
    }
}
