package servicios;

import datos.DAOPelicula;
import modelo.Pelicula;


public interface I_S_Pelicula {

	public void altaPelicula(Pelicula p);
	public void bajaPelicula(Pelicula p);
	public void modificarPelicula(Pelicula p);
	public void mostrarPelicula(Pelicula p);
}
