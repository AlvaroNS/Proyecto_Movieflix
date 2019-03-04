package control;

import datos.ConexionBD;
import servicios.S_Cliente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		S_Cliente s1 = new S_Cliente();
		s1.delete(1);
		
	}

}
