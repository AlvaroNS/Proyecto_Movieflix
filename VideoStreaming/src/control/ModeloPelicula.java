package control;

import gui.MenuPelicula;
import modelo.Cliente;
import modelo.Pelicula;
import servicios.I_S_Cliente;
import servicios.I_S_Pelicula;
import servicios.S_Cliente;
import servicios.S_Pelicula;
//import modelo.Pelicula;
import utilidades.*;
//import servicios.S_PeliculaImpl;

public class ModeloPelicula {
	
	 Pelicula p = new Pelicula();
		
		


	    public void abrirVideoStreamingPelicula() {
	        boolean seguir = true;
	        do {
	            MenuPelicula.mostrarMenu();
	            seguir = this.seleccionOpcionesPelicula();
	        } while (seguir);
	        System.out.println("   --- Fin de la sesion ---");
	    }

	    public boolean seleccionOpcionesPelicula() {

	        boolean continuar = true;

	        try {
	            switch (LecturaDatos.leerInt()) {
	                case 1:
	                    //ALTA DE UN PELICULA
	                	System.out.println("Has seleccionado: Crear Pelicula");
	                   // services.Alta(c);
	                    break;

	                case 2:
	                    //ELIMINAR UN PELICULA
	                	System.out.println("Has seleccionado: Dar de baja Pelicula");
	                   // services.Baja(c);
	                    break;

	                case 3:
	                	//MODIFICAR PELICULA
	                	System.out.println("Has seleccionado: Modificar Peliculas");
	                    S_Pelicula.modificarPelicula(p);
	                    break;

	                case 4:
	                    //LISTAR PELICULA
	                	System.out.println("Has seleccionado: Listar datos de Peliculas");
	                   // services.CantidadesProducto();
	                    break;
	                    
	                case 5:
	                	//LISTAR PELICULA POR CATEGORIA
	                	System.out.println("Has seleccionado: Listar Pelicula por categoria");
	                 //   services.Baja(c);
	                    break;

	                case 6:
	                	//LISTAR PELICULA POR MAS VALORADAS
	                	System.out.println("Has seleccionado: Listar Peliculas por mas valoradas");
	                   // services.ListarProductos();
	                    break;

	                case 7:
	                    //LISTAR PELICULA POR MAS VISTAS
	                	System.out.println("Has seleccionado: Listar Peliculas por mas vistas");
	                   // services.CantidadesProducto();
	                    break;

	                case 0:
	                    continuar = salir();
	                    break;
	            }
	        } catch (Exception e) {
	            System.out.println("error: " + e.toString());
	        }
	        return continuar;
	    }

	    private boolean salir() throws Exception {
	        String sino = LecturaDatos.leerString("¿Está seguro?(S/N)");
	        return (sino.toUpperCase().charAt(0) != 'S');
	    }
	  
	    public void pruebaModificarPelicula() {
	    	Pelicula p1 = new Pelicula();
			I_S_Pelicula pr = new S_Pelicula();
			try {
			pr.modificarPelicula(p1);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    
	    public void pruebaModificarCliente() {
	    	
	    		// TODO Auto-generated method stub
	    		
	    		/** modificar cliente testing/
	    		 */
	    		Cliente d1 = new Cliente();
	    		I_S_Cliente s1 = new S_Cliente(); 
	    		try {
	    			s1.modificarCliente(d1);
	    		} catch (Exception e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    }
	    	}
	    }
	    	



