package control;

import gui.MenuPelicula;
<<<<<<< HEAD:VideoStreaming/src/control/ModeloPelicula.java
import modelo.Cliente;
import modelo.Pelicula;
import servicios.I_S_Cliente;
import servicios.I_S_Pelicula;
import servicios.S_Cliente;
import servicios.S_Pelicula;
//import modelo.Pelicula;
=======
import modelo.Pelicula;
>>>>>>> b13a4f3815ac785c2ba7d5e77dc872c3cbcefa4e:VideoStreaming_FINAL/src/control/ModeloPelicula.java
import utilidades.*;
import servicios.S_Pelicula;

public class ModeloPelicula {
	
	 Pelicula p = new Pelicula();
<<<<<<< HEAD:VideoStreaming/src/control/ModeloPelicula.java
		
		

=======
>>>>>>> b13a4f3815ac785c2ba7d5e77dc872c3cbcefa4e:VideoStreaming_FINAL/src/control/ModeloPelicula.java

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
	                    //ALTA DE UNA PELICULA
	                	System.out.println("Has seleccionado: Crear Pelicula");
	                   // services.Alta(c);
	                    break;

	                case 2:
	                    //ELIMINAR UNA PELICULA
	                	System.out.println("Has seleccionado: Dar de baja Pelicula");
	                	System.out.println("Introduce el id de la película a dar de baja");
	                	int idP  = LecturaDatos.leerInt();
	                	S_Pelicula.bajaPelicula(idP);
	                    break;

	                case 3:
	                	//MODIFICAR PELICULA
<<<<<<< HEAD:VideoStreaming/src/control/ModeloPelicula.java
	                	System.out.println("Has seleccionado: Modificar Peliculas");
	                    S_Pelicula.modificarPelicula(p);
	                    break;
=======
	                	System.out.println("Has seleccionado: Modificar Pelicula");
	                	break;
>>>>>>> b13a4f3815ac785c2ba7d5e77dc872c3cbcefa4e:VideoStreaming_FINAL/src/control/ModeloPelicula.java

	                case 4:
	                    //MOSTRAR PELICULA
	                	System.out.println("Has seleccionado: Mostrar Datos de Pelicula");
	                    S_Pelicula.mostrarPelicula(LecturaDatos.leerInt("Introduce el id de la película que quieras que se muestre"));
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
	    	



