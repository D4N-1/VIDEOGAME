package tienda.servicio;

import tienda.exception.BadParameterException;
import tienda.exception.NotFoundException;
import tienda.modelo.Cliente;
import tienda.repositorio.ClienteRepository;

import java.util.List;

public class ClienteService {
    private final ClienteRepository ClienteRepository;

    public ClienteService(ClienteRepository ClienteRepository) {
        this.ClienteRepository = ClienteRepository;
    }

    private void validarCliente(Cliente Cliente) throws BadParameterException {
        if (Cliente == null) {
            throw new BadParameterException("Cliente no puede estar vacia");
        }

        if (Cliente.getNombre() == null || Cliente.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del cliente no puede estar vacio");
        }

        if (Cliente.getCorreo() == null || Cliente.getCorreo().isEmpty()){
            throw new BadParameterException("El correo del Cliente no puede estar vacio");

        }

        if (Cliente.getTelefono() == null || Cliente.getTelefono().isEmpty()){
            throw new BadParameterException("El telefono del cliente no puede estar vacio");

        }

    }

    public void guardarCliente(Cliente Cliente) {
        this.validarCliente(Cliente);
        this.ClienteRepository.agregarCliente(Cliente);
    }

    public void eliminarCliente(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Cliente");
        }
        Cliente Cliente = this.ClienteRepository.eliminarCliente(Integer.parseInt(id));
        if (Cliente == null) {
            throw new NotFoundException("No existe el Cliente");
        }
    }

    public void actualizarCliente(String id, Cliente ClienteActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el Cliente");
        }
        this.validarCliente(ClienteActualizar);
        Cliente Cliente = this.ClienteRepository.actualizarCliente(Integer.parseInt(id), ClienteActualizar);
        if (Cliente == null) {
            throw new NotFoundException("No existe el Cliente");
        }
    }

    public Cliente obtenerCliente(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el Cliente");
        }

        return this.ClienteRepository.obtenerCliente(Integer.parseInt(id));
    }

    public List<Cliente> obtenerClientes() {
        return this.ClienteRepository.obtenerClientes();
    }
    
    
    
}
