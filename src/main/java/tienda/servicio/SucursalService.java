package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Sucursal;
import tienda.repositorio.SucursalRepository;

import java.util.List;

public class SucursalService {
    private final SucursalRepository SucursalRepository;

    public SucursalService(SucursalRepository SucursalRepository) {
        this.SucursalRepository = SucursalRepository;
    }

    private void validarSucursal(Sucursal Sucursal) throws BadParameterException {
        if (Sucursal == null) {
            throw new BadParameterException("Sucursal no puede estar vacia");
        }

        if (Sucursal.getDireccion() == null || Sucursal.getDireccion().isEmpty()) {
            throw new BadParameterException("Porfavor ingrese una direccion");
        }

        if (Sucursal.getTelefono() == null || Sucursal.getTelefono().isEmpty()){
            throw new BadParameterException("No se ha ingresado un telefono");

        }

        if (Sucursal.getNombreGerente() == null || Sucursal.getNombreGerente().isEmpty()){
            throw new BadParameterException("El nombre el gerente no puede estar vacia");

        }

    }

    public void guardarSucursal(Sucursal Sucursal) {
        this.validarSucursal(Sucursal);
        this.SucursalRepository.agregarSucursal(Sucursal);
    }

    public void eliminarSucursal(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Sucursal");
        }
        Sucursal Sucursal = this.SucursalRepository.eliminarSucursal(Integer.parseInt(id));
        if (Sucursal == null) {
            throw new NotFoundException("No existe el Sucursal");
        }
    }

    public void actualizarSucursal(String id, Sucursal SucursalActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Sucursal");
        }
        this.validarSucursal(SucursalActualizar);
        Sucursal Sucursal = this.SucursalRepository.actualizarSucursal(Integer.parseInt(id), SucursalActualizar);
        if (Sucursal == null) {
            throw new NotFoundException("No existe el Sucursal");
        }
    }

    public Sucursal obtenerSucursal(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Sucursal");
        }

        return this.SucursalRepository.obtenerSucursal(Integer.parseInt(id));
    }

    public List<Sucursal> obtenerSucursals() {
        return this.SucursalRepository.obtenerSucursals();
    }
    
    
    
}
