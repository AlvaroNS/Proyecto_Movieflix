package control;

import gui.MenuPelicula;
import modelo.Pelicula;
import utilidades.LecturaDatos;
import servicios.S_Pelicula;

public class ModeloPelicula {
	
	 Pelicula p = new Pelicula();

	 /** Método para acceder al menú de Película */
	    public void abrirVideoStreamingPelicula() {
	        boolean seguir = true;
	        do {
	            MenuPelicula.mostrarMenu();
	            seguir = this.seleccionOpcionesPelicula();
	        } while (seguir);
	        System.out.println("   --- Fin de la sesion ---");
	    }

	    /** Método para seleccionar la opción deseada de la Tabla Pelicula*/ 
	    public boolean seleccionOpcionesPelicula() {

	        boolean continuar = true;

	        try {
	            switch (LecturaDatos.leerInt()) {
	                case 1:
	                    /** ALTA DE UNA PELICULA */
	                	System.out.println("Has seleccionado: Crear Pelicula");
	                	System.out.println("Introduce el id de la película a dar de baja");
	                   // services.Alta(c);
	                    break;

	                case 2:
	                    /** ELIMINAR UNA PELICULA */
	                	System.out.println("Has seleccionado: Dar de baja Pelicula");
	                	System.out.println("Introduce el id de la película a dar de baja");
	                	int idP  = LecturaDatos.leerInt();
	                	S_Pelicula.bajaPelicula(idP);
	                    break;

	                case 3:
	                	/** MODIFICAR PELICULA */
	                	System.out.println("Has seleccionado: Modificar Pelicula");
	                    S_Pelicula.mostrarPelicula(LecturaDatos.leerInt("Introduce el id de la película a modificar"));
	                	break;

	                case 4:
	                    /** MOSTRAR PELICULA */
	                	System.out.println("Has seleccionado: Mostrar Datos de Pelicula");
	                    S_Pelicula.mostrarPelicula(LecturaDatos.leerInt("Introduce el id de la película que quieras que se muestre"));
	                	break;
	                    
	                case 5:
	                	/** LISTAR PELICULA POR CATEGORIA */
	                	System.out.println("Has seleccionado: Listar Pelicula por categoria");
	                	 S_Pelicula.listaCategoria();
	                    break;

	                case 6:
	                	/** LISTAR PELICULA POR MAS VALORADAS */
	                	System.out.println("Has seleccionado: Listar Peliculas por mas valoradas");
	                	S_Pelicula.listaMasValorada();
	                    break;

	                case 7:
	                    /** LISTAR PELICULA POR MAS VISTAS */
	                	System.out.println("Has seleccionado: Listar Peliculas por mas vistas");
	                	S_Pelicula.listaMasVistas();
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
}


