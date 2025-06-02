package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Carrito;
import tienda.repositorio.CarritoRepository;

import java.util.List;

public class CarritoService {
    private final CarritoRepository CarritoRepository;

    public CarritoService(CarritoRepository CarritoRepository) {
        this.CarritoRepository = CarritoRepository;
    }

    private void validarCarrito(Carrito Carrito) throws BadParameterException {
        if (Carrito == null) {
            throw new BadParameterException("Carrito no puede estar vacia");
        }

        if (Carrito.getCliente() == null || Carrito.getCliente().isEmpty()) {
            throw new BadParameterException("El nombre del cliente no puede estar vacio");
        }

        if (Carrito.getlista() == null || Carrito.getlista().isEmpty()){
            throw new BadParameterException("La lista del Carrito aun se encuentra vacia");

        }

        if (Carrito.getTotal() == null || Carrito.getTotal().isEmpty()){
            throw new BadParameterException("Hay un error en el total");

        }

    }

    public void guardarCarrito(Carrito Carrito) {
        this.validarCarrito(Carrito);
        this.CarritoRepository.agregarCarrito(Carrito);
    }

    public void eliminarCarrito(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Carrito");
        }
        Carrito Carrito = this.CarritoRepository.eliminarCarrito(Integer.parseInt(id));
        if (Carrito == null) {
            throw new NotFoundException("No existe el Carrito");
        }
    }

    public void actualizarCarrito(String id, Carrito CarritoActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Carrito");
        }
        this.validarCarrito(CarritoActualizar);
        Carrito Carrito = this.CarritoRepository.actualizarCarrito(Integer.parseInt(id), CarritoActualizar);
        if (Carrito == null) {
            throw new NotFoundException("No existe el Carrito");
        }
    }

    public Carrito obtenerCarrito(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Carrito");
        }

        return this.CarritoRepository.obtenerCarrito(Integer.parseInt(id));
    }

    public List<Carrito> obtenerCarritos() {
        return this.CarritoRepository.obtenerCarritos();
    }
    
    
    
}
