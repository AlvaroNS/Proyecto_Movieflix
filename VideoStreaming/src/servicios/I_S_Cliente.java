package servicios;

import datos.DAOCliente;
import modelo.Cliente;


public interface I_S_Cliente {

	DAOCliente dc = new DAOCliente();
	
	static void altaCliente(Cliente c) {
		dc.altaCliente(c);
	}
	static void bajaCliente(int id) {
		dc.bajaCliente(id);
	}

}
