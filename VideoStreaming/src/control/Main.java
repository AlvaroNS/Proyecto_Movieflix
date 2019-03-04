package control;

import datos.ConexionBD;
import datos.DAOClientes;
import modelo.Cliente;
import servicios.S_Cliente;
import servicios.S_ClienteImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/** modificar cliente testing/
		 */
		Cliente d1 = new Cliente();
		S_Cliente s1 = new S_ClienteImpl();
		s1.modificarCliente(d1);
		
		
	}

}
