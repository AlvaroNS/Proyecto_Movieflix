package servicios;

import datos.DAOClientes;
import datos.I_DAOClientes;
import modelo.Cliente;

public class S_Cliente {
	
	private I_DAOClientes col = new DAOClientes();
	
	public void add(Cliente c){
		col.Alta(c);
	}


}
