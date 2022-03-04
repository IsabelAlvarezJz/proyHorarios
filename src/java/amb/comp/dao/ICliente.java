package amb.comp.dao;

import amb.comp.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Isabel
 */
public interface ICliente {
    //TODOS LOS METODOS NECESARIOS PARA EL CRUD
    public List<Cliente> buscarClientes();
    public Cliente buscarPorId(int idCliente);
    public boolean insertarCliente(Cliente client);
    public boolean actualizarCliente(Cliente cliente);
    public boolean eliminarCliente(int identificador);
}
