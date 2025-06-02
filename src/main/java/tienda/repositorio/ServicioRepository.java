package tienda.repositorio;

import tienda.modelo.Servicio;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ServicioRepository {
    private final ArrayList<Servicio> Servicios = new ArrayList<Servicio>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarServicio(Servicio Servicio) {
        Servicio.setId(this.autoId.getAndIncrement());
        this.Servicios.add(Servicio);
    }

    public Servicio eliminarServicio(int id) {
        Servicio Servicio = null;
        for (int i = 0; i < this.Servicios.size(); i++) {
            if (this.Servicios.get(i).getId() == id) {
                Servicio = this.Servicios.remove(i);
                break;
            }
        }
        return Servicio;
    }

    public Servicio actualizarServicio(int id, Servicio ServicioActualizado) {
        Servicio Servicio = null;
        for (int i = 0; i < this.Servicios.size(); i++) {
            if (this.Servicios.get(i).getId() == id) {
                this.Servicios.set(i, ServicioActualizado);
                Servicio = ServicioActualizado;
                break;
            }
        }
        return Servicio;
    }

    public Servicio obtenerServicio(int id) {
        for (Servicio Servicio : this.Servicios) {
            if (Servicio.getId() == id) {
                return Servicio;
            }
        }
        return null;
    }

    public ArrayList<Servicio> obtenerServicios() {
        return this.Servicios;
    }
}
