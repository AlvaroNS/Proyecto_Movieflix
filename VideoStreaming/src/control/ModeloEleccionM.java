package control;

import gui.MenuEleccion;
import utilidades.LecturaDatos;

public class ModeloEleccionM {
	
	ModeloCliente mc = new ModeloCliente();
	ModeloPelicula mp = new ModeloPelicula();

	/** M�todo para acceder al men� de selecci�n principal */
    public void abrirVideoStreaming() {
        boolean seguir = true;
        do {
            MenuEleccion.mostrarMenu();
            seguir = this.seleccionOpciones();
        } while (seguir);
        System.out.println("   --- Fin de la sesion ---");
    }

    
    /** M�todo para elegir opciones referentes a Cliente o a Pel�cula */
    public boolean seleccionOpciones() {

        boolean continuar = true;

        try {
            switch (LecturaDatos.leerInt()) {
                case 1:
                    //MENU CLIENTE
                	System.out.println("Has seleccionado: Menu Cliente");
                    mc.abrirVideoStreamingCliente();
                    break;

                case 2:
                    //MENU PELICULA
                	System.out.println("Has seleccionado: Menu Pelicula");
                	mp.abrirVideoStreamingPelicula();
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
        String sino = LecturaDatos.leerString("�Est� seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }

}
