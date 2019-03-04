package control;

import gui.MenuCliente;
import modelo.Cliente;
import utilidades.*;
import servicios.S_Cliente;

public class ModeloCliente {
	
	 Cliente c = new Cliente();
	 
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
<<<<<<< HEAD
<<<<<<< HEAD
	                    services.altaCliente(c);
=======
	                    Impl_S_Cliente.altaCliente(c);
>>>>>>> 77d836a3fc381c392be1d3bb47aa0ee72ebae656
=======
	                    S_Cliente.altaCliente(c);
>>>>>>> 923402c3a81c6d4da2acbd847164a152f5249f06
	                    break;

	                case 2:
	                    //ELIMINAR UN CLIENTE
	                	System.out.println("Has seleccionado: Dar de baja cliente");
<<<<<<< HEAD
	                    services.bajaCliente(c);
=======
	                	System.out.println("Introduce el id del cliente a dar de baja");
	                	int idC = LecturaDatos.leerInt();
<<<<<<< HEAD
	                    Impl_S_Cliente.bajaCliente(idC);
>>>>>>> 77d836a3fc381c392be1d3bb47aa0ee72ebae656
=======
	                    S_Cliente.bajaCliente(idC);
>>>>>>> 923402c3a81c6d4da2acbd847164a152f5249f06
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


