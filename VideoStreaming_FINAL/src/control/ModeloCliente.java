package control;

import gui.MenuCliente;
import modelo.Cliente;
import utilidades.*;
import servicios.I_S_Cliente;
import servicios.S_Cliente;

public class ModeloCliente {
	
	 private I_S_Cliente services = new S_Cliente();
	 private Cliente c = new Cliente();
	 
	    public void abrirVideoStreamingCliente() {
	        boolean seguir = true;
	        do {
	            MenuCliente.mostrarMenu();
	            seguir = this.seleccionOpcionesCliente();
	        } while (seguir);
	        System.out.println("   --- Fin de la sesion ---");
	    }

	    public boolean seleccionOpcionesCliente() {

	        boolean continuar = true;

	        try {
	            switch (LecturaDatos.leerInt()) {
	                case 1:
	                    //ALTA DE UN CLIENTE
	                	System.out.println("Has seleccionado: Crear Cliente");
	                	services.altaCliente(c);
	                    break;

	                case 2:
	                    //ELIMINAR UN CLIENTE
	                	System.out.println("Has seleccionado: Dar de baja cliente");
	                	services.bajaCliente(c);
	                    

	                	System.out.println("Introduce el id del cliente a dar de baja");
	                	int idC = LecturaDatos.leerInt();

	    
	                    break;

	                case 3:
	                	//MODIFICAR CLIENTE
	                	System.out.println("Has seleccionado: Modificar clientes");
	                   services.modificarCliente(c);
	                    break;

	                case 4:
	                    //LISTAR CLIENTES
	                	System.out.println("Has seleccionado: Listar datos de clientes");
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
}


