package control;

import datos.ConexionBD;

import modelo.Cliente;
import modelo.Pelicula;
import servicios.I_S_Cliente;
import servicios.I_S_Pelicula;
import servicios.S_Cliente;
import servicios.S_Pelicula;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Pelicula p1 = new Pelicula();
		I_S_Pelicula pr = new S_Pelicula();
		try {
		pr.modificarPelicula(p1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
