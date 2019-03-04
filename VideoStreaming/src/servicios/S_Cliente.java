package servicios;

import datos.DAOCliente;
import datos.I_DAOCliente;
import modelo.Cliente;


public class S_Cliente implements I_S_Cliente{
	
	private static I_DAOCliente col = new DAOCliente();

	public static void altaCliente(Cliente c) {
		// TODO Auto-generated method stub
		col.altaCliente(c);
	}

	public static void bajaCliente(int id) {
		// TODO Auto-generated method stub
		col.bajaCliente(id);
	}
<<<<<<< HEAD

<<<<<<< HEAD
	public void modificarCliente(Cliente c) {
		col.modificarCliente(c);
	}
=======
>>>>>>> 77d836a3fc381c392be1d3bb47aa0ee72ebae656
=======
	
>>>>>>> 923402c3a81c6d4da2acbd847164a152f5249f06
}

	

