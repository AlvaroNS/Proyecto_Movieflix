package datos;

import modelo.Pelicula;

/** Inferfaz que indica los métodos a implementar en DAO Pelicula */
public interface I_DAOPelicula {
	
	public void altaPelicula (Pelicula p);
	public void bajaPelicula (int idP);
	public void mostrarPelicula(int idP);
	public void modificarPelicula(Pelicula p);
	public void listaCategoria ();
	public void listaMasValorada ();
	public void listaMasVistas ();
}
