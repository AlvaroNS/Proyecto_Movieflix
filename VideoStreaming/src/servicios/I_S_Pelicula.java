package servicios;

import datos.DAOPelicula;
import modelo.Pelicula;


/** interface de la capa servicios de Cliente, con los métodos a implementar */
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
	
	static void modificarPelicula (int idP) {
		dc.mostrarPelicula(idP);
	}
	
	static void listaCategoria () {
		dc.listaCategoria();
	}
	
	static void listaMasValorada () {
		dc.listaMasValorada();
	}
	
	static void listaMasVistas () {
		dc.listaMasVistas();
	}
}
