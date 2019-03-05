package datos;

import modelo.Cliente;

/** Inferfaz que indica los m�todos a implementar en DAO Cliente */
public interface I_DAOCliente {
	
	public void altaCliente(Cliente c);
	public void bajaCliente (int id);
	public void modificarCliente (Cliente c);
	public void mostrarCliente (int idC);
	
}
