package datos;

import modelo.Pelicula;

public interface I_DAOPelicula {
	
	public void altaPelicula (Pelicula p);
	public void bajaPelicula (int idP);
	public void mostrarPelicula(int idP);
	public void modificarPelicula(Pelicula p);
}
