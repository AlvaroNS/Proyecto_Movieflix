package datos;

import modelo.Cliente;
import modelo.Pelicula;
import utilidades.LecturaDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPelicula implements I_DAOPelicula {
	
	static Scanner sc = new Scanner(System.in);
	
	public DAOPelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public void altaPelicula(Pelicula p) {
		Statement st = null;
		try {
			int valorDefecto = 0;
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();
			
			p.setNombrePelicula(LecturaDatos.leerString("Introduce el nombre del CLiente"));
			p.setAnioEstreno(LecturaDatos.leerInt("Introduce la ciudad del CLiente"));
			p.setCategoria(LecturaDatos.leerString("año de nacimiento:"));
			p.setVisualizacion(valorDefecto);
			p.setVisualizacion(valorDefecto);
			
			String sql = "INSERT INTO cliente (nombreCliente, fechaNacimiento, ciudad, tipoAcceso) VALUES ('"
					+ c.getNombreCliente() + "','" + c.getFechaNacimiento() + "','" + c.getCiudad() + "','"
					+ c.getTipoAcceso() + "')";
			
			System.out.println("" + sql);
			
			st.executeUpdate(sql);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("---" + ex.getSQLState());
			System.out.println("---" + ex.getErrorCode());
			System.out.println("---" + ex.getMessage());
			
			Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void bajaPelicula(int idP) {
=======
	 
	public void bajaPelicula (int idP) {
>>>>>>> b8a28d7685e56eb9cdbf815ac45817437db0cff0
		Statement st = null;
		try {
			System.out.println("Código a dar de baja: " + idP);
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection ().createStatement ();
			String s = "delete from pelicula where idPelicula =" + idP;
			
			int i = st.executeUpdate(s);
			System.out.println(s + i);
			con.getConnection ().close();
			
		}
		
		catch (Exception ex) {
            Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
    public void mostrarPelicula(int idP) {
        Statement st= null;
        try {
        	System.out.println("Código de la película a mostrar: " + idP);
            ConexionBD con= new ConexionBD();
            con.ConexionDB();
            st = con.getConnection().createStatement();
            String q = "SELECT FROM pelicula where idPelicula =" +idP;
            System.out.println(q);
            con.getConnection().close();
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
    
    /** Modificar pelicula existente en Base de datos**/
	public void modificarPelicula (Pelicula p ) {
		/**crear sentencia**/
		Statement st1 = null;
		Logger.getLogger("Creando variable sentencia");
		
		/** presentación del metodo**/
		try {
			
			System.out.println("Modificación datos de pelicula");
			/** codigo de la pelicula que se desea modificar**/
			int idm = LecturaDatos.leerInt("Codigo de película a modificar:");
			/** pido los datos nuevos del cliente existente**/
			p.setIdPelicula(idm);;
			p.setAnioEstreno(LecturaDatos.leerInt("Año de estreno:"));
			p.setCategoria(LecturaDatos.leerN("Categoría de la película:"));
			p.setNombrePelicula(LecturaDatos.leerString("Nombre de la película:"));
			/** conectando a base de datos**/
			Connection connect = new ConexionBD().getConnection();
			/** detallando sentencia**/
			st1= connect.createStatement();
			/** creo concatenado de sentencias SQL y variables**/
			String q = "UPDATE pelicula SET nombrePelicula = '" + p.getNombrePelicula() + "',anioEstreno= " + p.getAnioEstreno() + ",categoria= '" + p.getCategoria() + "' WHERE idPelicula = " + p.getIdPelicula();
			/** muestro sentencia**/
			System.out.println("Sentencia: " + q);
			/** ejecuto sentencia**/
			int i = st1.executeUpdate(q);
			/** cierro conexión**/
			connect.close();
		}catch(SQLException ex) {
			Logger.getLogger("Error con el SQL");
		}
		}
<<<<<<< HEAD
	}	
	
=======


	@Override
	public void altaPelicula(Pelicula p) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> b8a28d7685e56eb9cdbf815ac45817437db0cff0

}
