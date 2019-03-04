package servicios;

import datos.DAOPelicula;
import modelo.Pelicula;


public interface I_S_Pelicula {

	DAOPelicula dc = new DAOPelicula();
	
	static void altaPelicula(Pelicula p) {
		dc.altaPelicula(p);
	}
	
	static void bajaPelicula(int idP) {
		dc.bajaPelicula(idP);
	}

	static void mostrarPelicula (int idP) {
		dc.mostrarPelicula(idP);
	}
}
