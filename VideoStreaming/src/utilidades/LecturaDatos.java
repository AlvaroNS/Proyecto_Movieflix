package utilidades;

import java.util.Scanner;

public class LecturaDatos {
	

    //Metodo estatico
    @SuppressWarnings("resource")
	public static String leerString() {
        return new Scanner(System.in).nextLine();
    }

    public static String leerString(String msg) {
        System.out.println(msg);
        //Llama al metodo de arriba
        return leerString();
    }

    //Metodo estatico
    @SuppressWarnings("resource")
	public static int leerInt() {
        return new Scanner(System.in).nextInt();
    }
    
        public static int leerInt(String msg) {
        System.out.println(msg);
        //Llama al metodo de arriba
        return leerInt();
    }
        
    //Metodo estatico    
    @SuppressWarnings("resource")
	public static long leerLong() {
        return new Scanner(System.in).nextLong();
    }
    
        public static long leerLong(String msg) {
        System.out.println(msg);
        //Llama al metodo de arriba
        return leerLong();
    }
    
    //Metodo estatico
    @SuppressWarnings("resource")
	public static String leerN() {
        return new Scanner(System.in).next();
    }
    
        public static String leerN(String msg) {
        System.out.println(msg);
        //Llama al metodo de arriba
        return leerN();
    }    
<<<<<<< HEAD
 
        public static Date leerFecha() {
=======
    
    //Metodo estatico    
    @SuppressWarnings("resource")
	public static double leerDouble() {
        return new Scanner(System.in).nextDouble();
    }
    
        public static double leerDouble(String msg) {
        System.out.println(msg);
        //Llama al metodo de arriba
        return leerDouble();
    }
        

>>>>>>> 77d836a3fc381c392be1d3bb47aa0ee72ebae656
}
