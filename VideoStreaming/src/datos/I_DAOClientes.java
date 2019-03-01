package datos;

import modelo.Cliente;

public interface I_DAOClientes {
	
	public void Alta(Cliente c);
	public void Baja (int id);
	
}
