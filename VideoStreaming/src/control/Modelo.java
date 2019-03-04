package control;

import gui.Menu;
import modelo.Cliente;
import utilidades.*;
import servicios.S_ClienteImpl;

public class Modelo {
	
	 Cliente c = new Cliente();
	 
	 private S_ClienteImpl services = new S_ClienteImpl() {
		
		@Override
		public void Baja(Cliente c) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void Alta(Cliente c) {
			// TODO Auto-generated method stub
			
		}
	};

	    public void abrirVideoStreaming() {
	        boolean seguir = true;
	        do {
	            Menu.mostrarMenu();
	            seguir = this.seleccionOpciones();
	        } while (seguir);
	        System.out.println("   --- Fin de la sesion ---");
	    }

	    public boolean seleccionOpciones() {

	        boolean continuar = true;

	        try {
	            switch (LecturaDatos.leerInt()) {
	                case 1:
	                    //ALTA DE UN CLIENTE
	                	System.out.println("Has seleccionado: Crear Cliente");
	                    services.Alta(c);
	                    break;

	                case 2:
	                    //ELIMINAR UN CLIENTE
	                	System.out.println("Has seleccionado: Dar de baja cliente");
	                    services.Baja(c);
	                    break;

	                case 3:
	                	//MODIFICAR CLIENTE
	                	System.out.println("Has seleccionado: Modificar clientes");
	                   // services.ListarProductos();
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
	        String sino = LecturaDatos.leerString("   ¿Está seguro?(S/N)");
	        return (sino.toUpperCase().charAt(0) != 'S');
	    }
}


