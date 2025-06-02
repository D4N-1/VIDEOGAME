package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Reseña;
import tienda.repositorio.ReseñaRepository;

import java.util.List;

public class ReseñaService {
    
    private final ReseñaRepository ReseñaRepository;

    public ReseñaService(ReseñaRepository ReseñaRepository) {
        this.ReseñaRepository = ReseñaRepository;
    }

    private void validarReseña(Reseña Reseña) throws BadParameterException {
        if (Reseña == null) {
            throw new BadParameterException("Reseña no puede estar vacia");
        }

        if (Reseña.getNombre() == null || Reseña.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del Reseña no puede estar vacio");
        }

         if (Reseña.getPrecio() <= 0) {
            throw new BadParameterException("El precio de las Reseña no puede ser menor o igual a cero");
        }

         if (Reseña.getCantidad() <= 0) {
            throw new BadParameterException("El precio del producto no puede ser menor o igual a cero");
        }

         if (Reseña.getCategoria() == null || Reseña.getCategoria().isEmpty()) {
            throw new BadParameterException("El getCategoria del Reseña no puede estar vacio");
        }

         if (Reseña.getDescripcion() == null || Reseña.getDescripcion().isEmpty()) {
            throw new BadParameterException("la descripcion de las Reseña no puede estar vacio");
        }

    }

    public void guardarReseña(Reseña Reseña) {
        this.validarReseña(Reseña);
        this.ReseñaRepository.agregarReseña(Reseña);
    }

    public void eliminarReseña(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Reseña");
        }
        Reseña Reseña = this.ReseñaRepository.eliminarReseña(Integer.parseInt(id));
        if (Reseña == null) {
            throw new NotFoundException("No existe el Reseña");
        }
    }

    public void actualizarReseña(String id, Reseña ReseñaActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Reseña");
        }
        this.validarReseña(ReseñaActualizar);
        Reseña Reseña = this.ReseñaRepository.actualizarReseña(Integer.parseInt(id), ReseñaActualizar);
        if (Reseña == null) {
            throw new NotFoundException("No existe el Reseña");
        }
    }

    public Reseña obtenerReseña(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Reseña");
        }

        return this.ReseñaRepository.obtenerReseña(Integer.parseInt(id));
    }

    public List<Reseña> obtenerReseñas() {
        return this.ReseñaRepository.obtenerReseñas();
    }
}
