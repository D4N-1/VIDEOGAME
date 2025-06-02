package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.ProductoVirtual;
import tienda.repositorio.ProductoVirtualRepository;

import java.util.List;

public class ProductoVirtualService {
    
    private final ProductoVirtualRepository ProductoVirtualsRepository;

    public ProductoVirtualService(ProductoVirtualRepository ProductoVirtualsRepository) {
        this.ProductoVirtualsRepository = ProductoVirtualsRepository;
    }

    private void validarProductoVirtual(ProductoVirtual ProductoVirtual) throws BadParameterException {
        if (ProductoVirtual == null) {
            throw new BadParameterException("ProductoVirtual no puede estar vacio");
        }

        if (ProductoVirtual.getNombre() == null || ProductoVirtual.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del ProductoVirtual no puede estar vacio");
        }

        if (ProductoVirtual.getDescripcion() == null || ProductoVirtual.getDescripcion().isEmpty()) {
            throw new BadParameterException("La categoria del ProductoVirtual no puede estar vacia");
        }
    }

    public void guardarProductoVirtual(ProductoVirtual ProductoVirtual) {
        this.validarProductoVirtual(ProductoVirtual);
        this.ProductoVirtualsRepository.agregarProductoVirtual(ProductoVirtual);
    }

    public void eliminarProductoVirtual(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el ProductoVirtual");
        }
        ProductoVirtual ProductoVirtual = this.ProductoVirtualsRepository.eliminarProductoVirtual(Integer.parseInt(id));
        if (ProductoVirtual == null) {
            throw new NotFoundException("No existe el ProductoVirtual");
        }
    }

    public void actualizarProductoVirtual(String id, ProductoVirtual ProductoVirtualActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el ProductoVirtual");
        }
        this.validarProductoVirtual(ProductoVirtualActualizar);
        ProductoVirtual ProductoVirtual = this.ProductoVirtualsRepository.actualizarProductoVirtual(Integer.parseInt(id), ProductoVirtualActualizar);
        if (ProductoVirtual == null) {
            throw new NotFoundException("No existe el ProductoVirtual");
        }
    }

    public ProductoVirtual obtenerProductoVirtual(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el ProductoVirtual");
        }

        return this.ProductoVirtualsRepository.obtenerProductoVirtual(Integer.parseInt(id));
    }

    public List<ProductoVirtual> obtenerProductoVirtuals() {
        return this.ProductoVirtualsRepository.obtenerProductoVirtuals();
    }
}
