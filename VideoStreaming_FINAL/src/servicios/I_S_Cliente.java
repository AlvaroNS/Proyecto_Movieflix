package servicios;

import datos.DAOCliente;
import modelo.Cliente;


public interface I_S_Cliente {

	public void altaCliente(Cliente c);
	public void bajaCliente(Cliente c);
	public void modificarCliente(Cliente c) throws Exception;
	
	

}
