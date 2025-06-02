package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Servicio;
import tienda.repositorio.ServicioRepository;

import java.util.List;

public class ServicioService {
    
    private final ServicioRepository ServicioRepository;

    public ServicioService(ServicioRepository ServicioRepository) {
        this.ServicioRepository = ServicioRepository;
    }

    private void validarServicio(Servicio Servicio) throws BadParameterException {
        if (Servicio == null) {
            throw new BadParameterException("Servicio no puede estar vacia");
        }

        if (Servicio.getNombre() == null || Servicio.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del Servicio no puede estar vacio");
        }

         if (Servicio.getPrecio() <= 0) {
            throw new BadParameterException("El precio de las Reseña no puede ser menor o igual a cero");
        }

         if (Servicio.getCategoria() == null || Servicio.getCategoria().isEmpty()) {
            throw new BadParameterException("El nombre del Servicio no puede estar vacio");
        }

         if (Servicio.getDescripcion() == null || Servicio.getDescripcion().isEmpty()) {
            throw new BadParameterException("El nombre del Servicio no puede estar vacio");
        }



    }

    public void guardarServicio(Servicio Servicio) {
        this.validarServicio(Servicio);
        this.ServicioRepository.agregarServicio(Servicio);
    }

    public void eliminarServicio(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Servicio");
        }
        Servicio Servicio = this.ServicioRepository.eliminarServicio(Integer.parseInt(id));
        if (Servicio == null) {
            throw new NotFoundException("No existe el Servicio");
        }
    }

    public void actualizarServicio(String id, Servicio ServicioActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Servicio");
        }
        this.validarServicio(ServicioActualizar);
        Servicio Servicio = this.ServicioRepository.actualizarServicio(Integer.parseInt(id), ServicioActualizar);
        if (Servicio == null) {
            throw new NotFoundException("No existe el Servicio");
        }
    }

    public Servicio obtenerServicio(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Servicio");
        }

        return this.ServicioRepository.obtenerServicio(Integer.parseInt(id));
    }

    public List<Servicio> obtenerServicios() {
        return this.ServicioRepository.obtenerServicios();
    }
}
