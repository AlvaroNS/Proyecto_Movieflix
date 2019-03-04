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
	
}

	

