package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Factura;
import tienda.repositorio.FacturaRepository;

import java.util.List;

public class FacturaService {
    
    private final FacturaRepository FacturaRepository;

    public FacturaService(FacturaRepository FacturaRepository) {
        this.FacturaRepository = FacturaRepository;
    }

    private void validarFactura(Factura Factura) throws BadParameterException {
        if (Factura == null) {
            throw new BadParameterException("Factura no puede estar vacia");
        }

        if (Factura.getNombre() == null || Factura.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del Factura no puede estar vacio");
        }

         if (Factura.getPrecio() <= 0) {
            throw new BadParameterException("El precio de las Factura no puede ser menor o igual a cero");
        }

         if (Factura.getCantidad() <= 0) {
            throw new BadParameterException("El precio del producto no puede ser menor o igual a cero");
        }

         if (Factura.getCategoria() == null || Factura.getCategoria().isEmpty()) {
            throw new BadParameterException("El getCategoria del Factura no puede estar vacio");
        }

         if (Factura.getDescripcion() == null || Factura.getDescripcion().isEmpty()) {
            throw new BadParameterException("la descripcion de las Factura no puede estar vacio");
        }

    }

    public void guardarFactura(Factura Factura) {
        this.validarFactura(Factura);
        this.FacturaRepository.agregarFactura(Factura);
    }

    public void eliminarFactura(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Factura");
        }
        Factura Factura = this.FacturaRepository.eliminarFactura(Integer.parseInt(id));
        if (Factura == null) {
            throw new NotFoundException("No existe el Factura");
        }
    }

    public void actualizarFactura(String id, Factura FacturaActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Factura");
        }
        this.validarFactura(FacturaActualizar);
        Factura Factura = this.FacturaRepository.actualizarFactura(Integer.parseInt(id), FacturaActualizar);
        if (Factura == null) {
            throw new NotFoundException("No existe el Factura");
        }
    }

    public Factura obtenerFactura(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Factura");
        }

        return this.FacturaRepository.obtenerFactura(Integer.parseInt(id));
    }

    public List<Factura> obtenerFacturas() {
        return this.FacturaRepository.obtenerFacturas();
    }
}

