package servicios;

import datos.DAOClientes;
import datos.I_DAOClientes;
import modelo.Cliente;

public class S_Cliente {
	
	private I_DAOClientes col = new DAOClientes();
	
	public void addCliente(Cliente c){
		col.altaCliente(c);
	}
	
	public void deleteCliente(int id) {
		col.bajaCliente(id);
	}

	public void modificarCliente(Cliente c) {
		col.modificarCliente(c);
	}
}
