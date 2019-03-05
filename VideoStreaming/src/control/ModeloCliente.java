package control;

import gui.MenuCliente;
import modelo.Cliente;
import utilidades.LecturaDatos;
import servicios.S_Cliente;

public class ModeloCliente {
	
	 private Cliente c = new Cliente();
	 
	 /** Método para acceder al menú de Cliente */
	    public void abrirVideoStreamingCliente() {
	        boolean seguir = true;
	        do {
	            MenuCliente.mostrarMenu();
	            seguir = this.seleccionOpcionesCliente();
	        } while (seguir);
	        System.out.println("   --- Fin de la sesion ---");
	    }

	    
	    /** Método para seleccionar la opción deseada de la Tabla Cliente */
	    public boolean seleccionOpcionesCliente() {

	        boolean continuar = true;

	        try {
	            switch (LecturaDatos.leerInt()) {
	                case 1:
	                    //ALTA DE UN CLIENTE
	                	System.out.println("Has seleccionado: Crear Cliente");
	                	System.out.println("Introduce el id del cliente a dar de alta");
	                    S_Cliente.altaCliente(c);
	                    break;

	                case 2:
	                    //ELIMINAR UN CLIENTE
	                	System.out.println("Has seleccionado: Dar de baja cliente");
	                	System.out.println("Introduce el id del cliente a dar de baja");
	                	int idC = LecturaDatos.leerInt();
	                    S_Cliente.bajaCliente(idC);
	                    break;

	                case 3:
	                    //MOSTRAR CLIENTE
	                	System.out.println("Has seleccionado: Mostrar datos de clientes");
	                	System.out.println("Introduce el id del cliente a mostrar");
	                	int idC1 = LecturaDatos.leerInt();
	                	S_Cliente.mostrarCliente(idC1);
	                    break;

	                case 4:
	                	//MODIFICAR CLIENTE
	                	System.out.println("Has seleccionado: Modificar clientes");
	                	System.out.println("Introduce el id del cliente a modificar");
	                	S_Cliente.modificarCliente(c);
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


