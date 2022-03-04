
package amb.comp.servicio;

import amb.comp.dao.ClienteMetodos;
import amb.comp.modelo.Cliente;
import java.util.List;

public class ClienteServicio {   
    public List<Cliente> buscarClientes() {
        return new ClienteMetodos().buscarClientes();
    }
    
    public Cliente buscarPorId(int idCliente) {
        return new ClienteMetodos().buscarPorId(idCliente);
    }
  
    public boolean insertarCliente(Cliente client) {
        return new ClienteMetodos().insertarCliente(client);
    }  
    
    public boolean actualizarCliente(Cliente cliente) {
         return new ClienteMetodos().actualizarCliente(cliente);
    }
   
    public boolean eliminarCliente(int identificador) {
         return new ClienteMetodos().eliminarCliente(identificador);
    }
}
