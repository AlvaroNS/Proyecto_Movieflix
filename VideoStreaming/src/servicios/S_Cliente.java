package servicios;

import datos.DAOCliente;
import datos.I_DAOCliente;
import modelo.Cliente;


public class S_Cliente implements I_S_Cliente{
	
	private I_DAOCliente col = new DAOCliente();

	public void altaCliente(Cliente c) {
		// TODO Auto-generated method stub
		col.altaCliente(c);
	}


	public void modificarCliente(Cliente c) {
		col.modificarCliente(c);
	}

	@Override
	public void bajaCliente(Cliente c) {
		// TODO Auto-generated method stub
		
	}

}

	

