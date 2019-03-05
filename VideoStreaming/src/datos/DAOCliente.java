package datos;

import modelo.Cliente;
import utilidades.LecturaDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/** Capa DAO de Cliente que implementa el Interfaz DAO de Cliente*/
public class DAOCliente implements I_DAOCliente {
	
	static Scanner sc = new Scanner(System.in);
	
	public DAOCliente() {
		super();
	}
	
	
	/**Método para dar de alta a un cliente */
	public void altaCliente(Cliente c) {
		Statement st = null;
		try {
			/** Conexión con la base de datos  */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();
			
			/** Se piden datos a usuario para rellenar la tabla "Cliente" de la base de datos */
			c.setNombreCliente(LecturaDatos.leerString("Introduce el nombre del CLiente"));
			c.setCiudad(LecturaDatos.leerString("Introduce la ciudad del CLiente"));
			c.setFechaNacimiento(LocalDate.of(LecturaDatos.leerInt("año de nacimiento:"),
					LecturaDatos.leerInt("mes de nacimiento:"), LecturaDatos.leerInt("día de nacimiento:")));
			c.setTipoAcceso(LecturaDatos.leerString("Introduce el tipo de acceso del CLiente"));
			
			/**	Sentencia SQL para insertar los datos en la BD */
			String sql = "INSERT INTO cliente (nombreCliente, fechaNacimiento, ciudad, tipoAcceso) VALUES ('"
					+ c.getNombreCliente() + "','" + c.getFechaNacimiento() + "','" + c.getCiudad() + "','"
					+ c.getTipoAcceso() + "')";
			
			System.out.println("" + sql);
			
			st.executeUpdate(sql);
			
		/** Catch que captura los posibles errores */
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("---" + ex.getSQLState());
			System.out.println("---" + ex.getErrorCode());
			System.out.println("---" + ex.getMessage());
			
			Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	/** Método para dar de baja a un cliente */
	public void bajaCliente (int id) {
		Statement st = null;
		try {
			/** Se pide un id de cliente al usuaro */
			System.out.println("Código a dar de baja: " + id);
			
			/** Conexión con la base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection ().createStatement ();
			
			/** Sentencia SQL para borrar el cliente de la base de datos */
			String s = "delete from cliente where idCliente =" + id;
			
			int i = st.executeUpdate(s);
			System.out.println(s + i);
			
			/** Terminar la conexión */
			con.getConnection ().close();
			
		}
		
		/** Catch que captura los posibles errores */
		catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	/**	Método para modificar un cliente a partir de un id de cliente */
	public void modificarCliente (Cliente c) {
		/**crear sentencia */
		Statement st1 = null;
		Logger.getLogger("Creando variable sentencia");
		
		try {
			
			System.out.println("Modificación datos del cliente.");
			
			/** Código del cliente que se desea modificar */
			int idm = LecturaDatos.leerInt("Codigo de cliente a modificar:");
			
			/** Pedir los datos nuevos del cliente existrente */
			c.setIdCliente(idm);
			c.setCiudad(LecturaDatos.leerN("Ciudad del Cliente:"));
			c.setNombreCliente(LecturaDatos.leerN("Nombre del Cliente:"));
			c.setFechaNacimiento(LocalDate.of(LecturaDatos.leerInt("año de nacimiento:"), LecturaDatos.leerInt("mes de nacimiento:"), LecturaDatos.leerInt("día de nacimiento:")));
			c.setTipoAcceso(LecturaDatos.leerN("Tipo de acceso"));
			
			/** Conexión a base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st1 = con.getConnection ().createStatement ();
			
			/** Concatenado de sentencias SQL y variables */
			String q = "UPDATE CLIENTE SET nombreCliente = '" + c.getNombreCliente() + "',fechaNacimiento= '" + c.getFechaNacimiento() + "',ciudad= '" + c.getCiudad() + "',tipoAcceso= '" + c.getTipoAcceso() + "' WHERE idCliente= " + c.getIdCliente();
			System.out.println("Sentencia: " + q);
			st1.executeUpdate(q);
			
			/** Cierre de conexión */
			con.getConnection ().close();
			
		/** Catch que captura los posibles errores */
		}catch(SQLException ex) {
			Logger.getLogger("Error con el SQL");
		}

	}
	
	
	/** Método que muestra los datos de un cliente introduciendo su id*/
	public void mostrarCliente(int idC) {
		Statement st = null;
		ResultSet rs = null;
		try {
			
			/** Conexión con base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();
			
			/** Sentencia SQL que permite seleccionar un cliente de la base de datos cliente */
			rs = st.executeQuery("SELECT * FROM cliente where idCliente =" + idC);

			while (rs.next()) {
		
				/** Concatenado para sacar por pantalla los datos del cliente */
				System.out.println("Código cliente: " + rs.getInt("idCliente") + ", nombre cliente: " + rs.getString("nombreCliente") 
					+ " , ciudad: " + rs.getString("ciudad") + " , tipo de acceso: " + rs.getString("tipoAcceso"));
			}
			
			/** Cierre de conexión */
			con.getConnection().close();

		/** Catch que captura los posibles errores */
		} catch (SQLException ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
