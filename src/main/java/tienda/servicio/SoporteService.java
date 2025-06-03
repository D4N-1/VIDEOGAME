package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Soporte;
import tienda.repositorio.SoporteRepository;

import java.util.List;

public class SoporteService {
    private final SoporteRepository SoporteRepository;

    public SoporteService(SoporteRepository SoporteRepository) {
        this.SoporteRepository = SoporteRepository;
    }

    private void validarSoporte(Soporte Soporte) throws BadParameterException {
        if (Soporte == null) {
            throw new BadParameterException("Soporte no puede estar vacia");
        }

        if (Soporte.getCliente() == null || Soporte.getCliente().isEmpty()) {
            throw new BadParameterException("El nombre del cliente no puede estar vacio");
        }

        if (Soporte.getDescripcion() == null || Soporte.getDescripcion().isEmpty()){
            throw new BadParameterException("La descripcion aun se encuentra vacia");

        }

        if (Soporte.getEstado() == null || Soporte.getEstado().isEmpty()){
            throw new BadParameterException("ingrese el estado");

        }

        if (Soporte.getFecha() == null || Soporte.getFecha().isEmpty()){
            throw new BadParameterException("Ingrese una fecha valida");

        }

    }

    public void guardarSoporte(Soporte Soporte) {
        this.validarSoporte(Soporte);
        this.SoporteRepository.agregarSoporte(Soporte);
    }

    public void eliminarSoporte(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Soporte");
        }
        Soporte Soporte = this.SoporteRepository.eliminarSoporte(Integer.parseInt(id));
        if (Soporte == null) {
            throw new NotFoundException("No existe el Soporte");
        }
    }

    public void actualizarSoporte(String id, Soporte SoporteActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Soporte");
        }
        this.validarSoporte(SoporteActualizar);
        Soporte Soporte = this.SoporteRepository.actualizarSoporte(Integer.parseInt(id), SoporteActualizar);
        if (Soporte == null) {
            throw new NotFoundException("No existe el Soporte");
        }
    }

    public Soporte obtenerSoporte(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Soporte");
        }

        return this.SoporteRepository.obtenerSoporte(Integer.parseInt(id));
    }

    public List<Soporte> obtenerSoportes() {
        return this.SoporteRepository.obtenerSoportes();
    }
    
    
    
}
