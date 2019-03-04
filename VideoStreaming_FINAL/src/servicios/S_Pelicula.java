package servicios;

import datos.DAOPelicula;
import datos.I_DAOPelicula;
import modelo.Pelicula;


public class S_Pelicula implements I_S_Pelicula{
	
	private static I_DAOPelicula col = new DAOPelicula();

	public void altaPelicula(Pelicula p) {
		col.altaPelicula(p);
	}

	public static void bajaPelicula(int idP) {
		col.bajaPelicula(idP);
	}
	
	public static void mostrarPelicula (int idP) {
		col.mostrarPelicula(idP);
	}
	
	public static void modificarPelicula(Pelicula p) {
		col.modificarPelicula(p);
	}

	@Override
	public void bajaPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		
	}
	
}

	

