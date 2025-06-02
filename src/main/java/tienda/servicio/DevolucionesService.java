package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Devoluciones;
import tienda.repositorio.DevolucionesRepository;

import java.util.List;

public class DevolucionesService {
    
    private final DevolucionesRepository DevolucionesRepository;

    public DevolucionesService(DevolucionesRepository DevolucionesRepository) {
        this.DevolucionesRepository = DevolucionesRepository;
    }

    private void validarDevoluciones(Devoluciones Devoluciones) throws BadParameterException {
        if (Devoluciones == null) {
            throw new BadParameterException("Devoluciones no puede estar vacia");
        }

        if (Devoluciones.getNombre() == null || Devoluciones.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del Devoluciones no puede estar vacio");
        }

         if (Devoluciones.getPrecio() <= 0) {
            throw new BadParameterException("El precio de las devoluciones no puede ser menor o igual a cero");
        }

         if (Devoluciones.getCantidad() <= 0) {
            throw new BadParameterException("El precio del producto no puede ser menor o igual a cero");
        }

         if (Devoluciones.getCategoria() == null || Devoluciones.getCategoria().isEmpty()) {
            throw new BadParameterException("El getCategoria del Devoluciones no puede estar vacio");
        }

         if (Devoluciones.getDescripcion() == null || Devoluciones.getDescripcion().isEmpty()) {
            throw new BadParameterException("la descripcion de las Devoluciones no puede estar vacio");
        }

         if (Devoluciones.getCliente() == null || Devoluciones.getCliente().isEmpty()) {
            throw new BadParameterException("El Cliente de la Devolucion no puede estar vacio");
        }


    }

    public void guardarDevoluciones(Devoluciones Devoluciones) {
        this.validarDevoluciones(Devoluciones);
        this.DevolucionesRepository.agregarDevoluciones(Devoluciones);
    }

    public void eliminarDevoluciones(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Devoluciones");
        }
        Devoluciones Devoluciones = this.DevolucionesRepository.eliminarDevoluciones(Integer.parseInt(id));
        if (Devoluciones == null) {
            throw new NotFoundException("No existe el Devoluciones");
        }
    }

    public void actualizarDevoluciones(String id, Devoluciones DevolucionesActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Devoluciones");
        }
        this.validarDevoluciones(DevolucionesActualizar);
        Devoluciones Devoluciones = this.DevolucionesRepository.actualizarDevoluciones(Integer.parseInt(id), DevolucionesActualizar);
        if (Devoluciones == null) {
            throw new NotFoundException("No existe el Devoluciones");
        }
    }

    public Devoluciones obtenerDevoluciones(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Devoluciones");
        }

        return this.DevolucionesRepository.obtenerDevoluciones(Integer.parseInt(id));
    }

    public List<Devoluciones> obtenerDevolucioness() {
        return this.DevolucionesRepository.obtenerDevolucioness();
    }
}
