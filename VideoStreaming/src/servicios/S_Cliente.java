package servicios;

import datos.DAOCliente;
import datos.I_DAOCliente;
import modelo.Cliente;


public class S_Cliente implements Impl_S_Cliente{
	
	private I_DAOCliente col = new DAOCliente();

	public void altaCliente(Cliente c) {
		// TODO Auto-generated method stub
		col.altaCliente(c);
	}

	public void bajaCliente(int id) {
		// TODO Auto-generated method stub
		col.bajaCliente(id);
	}

<<<<<<< HEAD
	public void modificarCliente(Cliente c) {
		col.modificarCliente(c);
	}
=======
>>>>>>> 77d836a3fc381c392be1d3bb47aa0ee72ebae656
}
