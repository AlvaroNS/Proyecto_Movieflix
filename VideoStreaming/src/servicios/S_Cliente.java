package servicios;

import datos.DAOCliente;
import datos.I_DAOCliente;
import modelo.Cliente;


/** Clase servicios de Cliente con la implementación del interfaz, que indica
 los métodos de conexión entre la capa Datos y el Control */
public class S_Cliente implements I_S_Cliente{
	
	private static I_DAOCliente col = new DAOCliente();

	public static void altaCliente(Cliente c) {
		col.altaCliente(c);
	}

	public static void bajaCliente(int id) {
		col.bajaCliente(id);
	}
	
	public static void modificarCliente(Cliente c) {
		col.modificarCliente(c);
	}
	
	public static void mostrarCliente(int idC) {
		col.mostrarCliente(idC);
	}
}

	

