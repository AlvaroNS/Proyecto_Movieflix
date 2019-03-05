package servicios;

import datos.DAOCliente;
import modelo.Cliente;

/** interface de la capa servicios de Cliente, con los métodos a implementar */
public interface I_S_Cliente {

	DAOCliente dc = new DAOCliente();
	
	static void altaCliente(Cliente c) {
		dc.altaCliente(c);
	}
	
	static void bajaCliente(int id) {
		dc.bajaCliente(id);
	}

	static void modificarCliente(Cliente c) {
		dc.modificarCliente(c);
	}
	
	static void mostrarCliente(Cliente c) {
		dc.modificarCliente(c);
	}
	
}
