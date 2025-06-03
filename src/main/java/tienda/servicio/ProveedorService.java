package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Proveedor;
import tienda.repositorio.ProveedorRepository;

import java.util.List;

public class ProveedorService {
    private final ProveedorRepository ProveedorRepository;

    public ProveedorService(ProveedorRepository ProveedorRepository) {
        this.ProveedorRepository = ProveedorRepository;
    }

    private void validarProveedor(Proveedor Proveedor) throws BadParameterException {
        if (Proveedor == null) {
            throw new BadParameterException("Proveedor no puede estar vacia");
        }

        if (Proveedor.getNombre() == null || Proveedor.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del proveedor no puede estar vacio");
        }

        if (Proveedor.getCorreo() == null || Proveedor.getCorreo().isEmpty()){
            throw new BadParameterException("El correo del Proveedor aun se encuentra vacia");

        }

        if (Proveedor.getTelefono() == null || Proveedor.getTelefono().isEmpty()){
            throw new BadParameterException("El telefono del proveedor esta vacio");

        }

        if (Proveedor.getDireccion() == null || Proveedor.getDireccion().isEmpty()){
            throw new BadParameterException("Ingrese una direccion");

        }

    }

    public void guardarProveedor(Proveedor Proveedor) {
        this.validarProveedor(Proveedor);
        this.ProveedorRepository.agregarProveedor(Proveedor);
    }

    public void eliminarProveedor(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Proveedor");
        }
        Proveedor Proveedor = this.ProveedorRepository.eliminarProveedor(Integer.parseInt(id));
        if (Proveedor == null) {
            throw new NotFoundException("No existe el Proveedor");
        }
    }

    public void actualizarProveedor(String id, Proveedor ProveedorActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Proveedor");
        }
        this.validarProveedor(ProveedorActualizar);
        Proveedor Proveedor = this.ProveedorRepository.actualizarProveedor(Integer.parseInt(id), ProveedorActualizar);
        if (Proveedor == null) {
            throw new NotFoundException("No existe el Proveedor");
        }
    }

    public Proveedor obtenerProveedor(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Proveedor");
        }

        return this.ProveedorRepository.obtenerProveedor(Integer.parseInt(id));
    }

    public List<Proveedor> obtenerProveedors() {
        return this.ProveedorRepository.obtenerProveedors();
    }
    
    
    
}
