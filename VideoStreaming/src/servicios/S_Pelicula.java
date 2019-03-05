package servicios;

import datos.DAOPelicula;
import datos.I_DAOPelicula;
import modelo.Pelicula;


/** Clase servicios de Pelicula con la implementación del interfaz, que indica
los métodos de conexión entre la capa Datos y el Control */
public class S_Pelicula implements I_S_Pelicula{
	
	private static I_DAOPelicula col = new DAOPelicula();

	public static void altaPelicula(Pelicula p) {
		col.altaPelicula(p);
	}

	public static void bajaPelicula(int idP) {
		col.bajaPelicula(idP);
	}
	
	public static void mostrarPelicula (int idP) {
		col.mostrarPelicula(idP);
	}
	
	public static void modificarPelicula (int idP) {
		col.mostrarPelicula(idP);
	}
	
	public static void listaCategoria() {
		col.listaCategoria();
	}
	public static void listaMasValorada() {
		col.listaMasValorada();
	}
	public static void listaMasVistas() {
		col.listaMasVistas();
	}
}

	

