package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Pedido;
import tienda.repositorio.PedidoRepository;

import java.util.List;

public class PedidoService {
    
    private final PedidoRepository PedidoRepository;

    public PedidoService(PedidoRepository PedidoRepository) {
        this.PedidoRepository = PedidoRepository;
    }

    private void validarPedido(Pedido Pedido) throws BadParameterException {
        if (Pedido == null) {
            throw new BadParameterException("Pedido no puede estar vacia");
        }

        if (Pedido.getNombre() == null || Pedido.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del Pedido no puede estar vacio");
        }

         if (Pedido.getPrecio() <= 0) {
            throw new BadParameterException("El precio de las Pedido no puede ser menor o igual a cero");
        }

         if (Pedido.getCantidad() <= 0) {
            throw new BadParameterException("El precio del producto no puede ser menor o igual a cero");
        }

         if (Pedido.getCategoria() == null || Pedido.getCategoria().isEmpty()) {
            throw new BadParameterException("El getCategoria del Pedido no puede estar vacio");
        }

         if (Pedido.getDescripcion() == null || Pedido.getDescripcion().isEmpty()) {
            throw new BadParameterException("la descripcion de las Pedido no puede estar vacio");
        }

         if (Pedido.getCliente() == null || Pedido.getCliente().isEmpty()) {
            throw new BadParameterException("El Cliente de la Devolucion no puede estar vacio");
        }


    }

    public void guardarPedido(Pedido Pedido) {
        this.validarPedido(Pedido);
        this.PedidoRepository.agregarPedido(Pedido);
    }

    public void eliminarPedido(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Pedido");
        }
        Pedido Pedido = this.PedidoRepository.eliminarPedido(Integer.parseInt(id));
        if (Pedido == null) {
            throw new NotFoundException("No existe el Pedido");
        }
    }

    public void actualizarPedido(String id, Pedido PedidoActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Pedido");
        }
        this.validarPedido(PedidoActualizar);
        Pedido Pedido = this.PedidoRepository.actualizarPedido(Integer.parseInt(id), PedidoActualizar);
        if (Pedido == null) {
            throw new NotFoundException("No existe el Pedido");
        }
    }

    public Pedido obtenerPedido(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Pedido");
        }

        return this.PedidoRepository.obtenerPedido(Integer.parseInt(id));
    }

    public List<Pedido> obtenerPedidos() {
        return this.PedidoRepository.obtenerPedidos();
    }
}
