package servicios;

import modelo.Cliente;

public interface S_ClienteImpl {

	public void altaCliente(Cliente c);
	public void bajaCliente(Cliente c);
	public void modificarCliente(Cliente c) throws Exception;
}
