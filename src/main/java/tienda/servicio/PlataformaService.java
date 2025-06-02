package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Plataforma;
import tienda.repositorio.PlataformaRepository;

import java.util.List;

public class PlataformaService {
    
    private final PlataformaRepository PlataformaRepository;

    public PlataformaService(PlataformaRepository PlataformaRepository) {
        this.PlataformaRepository = PlataformaRepository;
    }

    private void validarPlataforma(Plataforma Plataforma) throws BadParameterException {
        if (Plataforma == null) {
            throw new BadParameterException("Plataforma no puede estar vacia");
        }

        if (Plataforma.getNombre() == null || Plataforma.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del Plataforma no puede estar vacio");
        }

        if (Plataforma.getFabricante() == null || Plataforma.getFabricante().isEmpty()){
            throw new BadParameterException("EL fabricante de la Plataforma no puede estar vacia");

        }

        if (Plataforma.getTipo() == null || Plataforma.getTipo().isEmpty()){
            throw new BadParameterException("EL Tipo de la Plataforma no puede estar vacio");

        }

    }

    public void guardarPlataforma(Plataforma Plataforma) {
        this.validarPlataforma(Plataforma);
        this.PlataformaRepository.agregarPlataforma(Plataforma);
    }

    public void eliminarPlataforma(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Plataforma");
        }
        Plataforma Plataforma = this.PlataformaRepository.eliminarPlataforma(Integer.parseInt(id));
        if (Plataforma == null) {
            throw new NotFoundException("No existe el Plataforma");
        }
    }

    public void actualizarPlataforma(String id, Plataforma PlataformaActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Plataforma");
        }
        this.validarPlataforma(PlataformaActualizar);
        Plataforma Plataforma = this.PlataformaRepository.actualizarPlataforma(Integer.parseInt(id), PlataformaActualizar);
        if (Plataforma == null) {
            throw new NotFoundException("No existe el Plataforma");
        }
    }

    public Plataforma obtenerPlataforma(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Plataforma");
        }

        return this.PlataformaRepository.obtenerPlataforma(Integer.parseInt(id));
    }

    public List<Plataforma> obtenerPlataformas() {
        return this.PlataformaRepository.obtenerPlataformas();
    }
}
