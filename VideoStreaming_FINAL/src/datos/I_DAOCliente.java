package datos;

import modelo.Cliente;

public interface I_DAOCliente {
	
	public void altaCliente(Cliente c);
	public void bajaCliente (int id);
	public void modificarCliente(Cliente c);
}
