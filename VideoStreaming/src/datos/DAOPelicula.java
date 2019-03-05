package datos;

import modelo.Pelicula;
import utilidades.LecturaDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/** Capa DAO de Pelicula que implementa el Interfaz DAO de Cliente */
public class DAOPelicula implements I_DAOPelicula {

	static Scanner sc = new Scanner(System.in);

	public DAOPelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**Método para dar de alta a una películ */
	public void altaPelicula(Pelicula p) {
		Statement st = null;
		int valorDefecto = 0;

		try {
			/** Conexión con la base de datos  */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();

			/** Se piden datos a usuario para rellenar la tabla "Pelicula" de la base de datos,
			 en visualización y valoración se indican valores nulos por defecto */
			p.setNombrePelicula(LecturaDatos.leerString("Introduce el nombre de la Pelicula"));
			p.setAnioEstreno(LecturaDatos.leerInt("Introduce el año de estreno de la Pelicula"));
			p.setCategoria(LecturaDatos.leerString("Introduce la categoria:"));
			p.setVisualizacion(valorDefecto);
			p.setValoracion(valorDefecto);

			/**	Sentencia SQL para insertar los datos en la BD */
			String sql = "INSERT INTO pelicula (nombrePelicula, anioEstreno, categoria, visualizacion, valoracion) VALUES ('"
					+ p.getNombrePelicula() + "','" + p.getAnioEstreno() + "','" + p.getCategoria() + "','"
					+ p.getVisualizacion() + "','" + p.getValoracion() + "')";

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


	/** Método para dar de baja a una película */
	public void bajaPelicula(int idP) {
		Statement st = null;
		try {
			/** Se pide un id de película al usuaro */
			System.out.println("Código a dar de baja: " + idP);
			
			/** Conexión con la base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();
			
			/** Sentencia SQL para borrar la película de la base de datos */
			String s = "delete from pelicula where idPelicula =" + idP;

			int i = st.executeUpdate(s);
			System.out.println(s + i);
			
			/** Terminar la conexión */
			con.getConnection().close();

		}

		/** Catch que captura los posibles errores */
		catch (Exception ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	/**	Método para modificar una película a partir de un id de película */
	public void modificarPelicula (Pelicula p) {
		/**crear sentencia */
		Statement st1 = null;
		Logger.getLogger("Creando variable sentencia");
		int valorDefecto = 0;
		
		try {
			
			System.out.println("Modificación datos de la película.");
			
			/** Código de la película que se desea modificar */
			int idp = LecturaDatos.leerInt("Codigo de la película a modificar:");
			
			/** Pedir los datos nuevos de la película existente */
			p.setIdPelicula(idp);
			p.setNombrePelicula(LecturaDatos.leerN("Película: "));
			p.setAnioEstreno(LecturaDatos.leerInt("Año de extreno: "));
			p.setCategoria(LecturaDatos.leerN("Categoría: "));
			p.setVisualizacion(valorDefecto);
			p.setValoracion(valorDefecto);
			
			/** Conexión a base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st1 = con.getConnection ().createStatement ();
			
			/** Concatenado de sentencias SQL y variables */
			String q = "UPDATE PELICULA SET idPelicula = '" + p.getIdPelicula() + "', nombrePelicula= '" + p.getNombrePelicula() +
					 "', anioEstreno = '" + p.getAnioEstreno() +"', categoria = '" + p.getCategoria() + "', visualizacion= '" + p.getVisualizacion() 
					 + "', valoracion= '" + p.getValoracion()+ "' WHERE idPelicula= " + p.getIdPelicula();
			
			System.out.println("Sentencia: " + q);
			
			/** Ejecutar los cambios */
			st1.executeUpdate(q);
			
			/** Cierre de conexión */
			con.getConnection ().close();
			
		/** Catch que captura los posibles errores */
		}catch(SQLException ex) {
			Logger.getLogger("Error con el SQL");
		}
		
	}	

	
	/** Método que muestra los datos de una pelícua al introducir su id */
	public void mostrarPelicula(int idP) {
		Statement st = null;
		ResultSet rs = null;
		try {
			
			/** Conexión con la base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();

			/** Sentencia SQL que permite seleccionar la película a borrar a través de su id */
			rs = st.executeQuery("SELECT * FROM pelicula where idPelicula =" + idP);

			while (rs.next()) {

				/** Se rellena un objeto Película con datos de la
				base de datos para mostrarlo por pantalla */
				Pelicula p = new Pelicula();
				p.setIdPelicula(rs.getInt("idPelicula"));
				p.setNombrePelicula(rs.getString("nombrePelicula"));
				p.setAnioEstreno(rs.getInt("anioEstreno"));
				p.setCategoria(rs.getString("categoria"));
				p.setVisualizacion(rs.getInt("visualizacion"));
				p.setValoracion(rs.getInt("valoracion"));

				System.out.println(p);
			}

			/** Cierre de conexión */
			con.getConnection().close();

		/** Catch que captura los posibles errores */
		} catch (SQLException ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	
	/** Método para mostrar una lista de películas ordenadas por categoría */
	public void listaCategoria() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			/** Se establece la conexión con la base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();

			/** Sentencia SQL para seleccionar por categoría */
			rs = st.executeQuery("SELECT * FROM pelicula ORDER BY categoria ASC");

			while (rs.next()) {

				Pelicula p = new Pelicula();
				p.setIdPelicula(rs.getInt("idPelicula"));
				p.setNombrePelicula(rs.getString("nombrePelicula"));
				p.setAnioEstreno(rs.getInt("anioEstreno"));
				p.setCategoria(rs.getString("categoria"));
				p.setVisualizacion(rs.getInt("visualizacion"));
				p.setValoracion(rs.getInt("valoracion"));

				System.out.println(p);
			}

			/** Cierre de la conexión con la base de datos */
			con.getConnection().close();

		/** Catch que captura los posibles errores */
		} catch (SQLException ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	/** Método para mostrar las películas por el orden de valoración */
	public void listaMasValorada() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			
			/** Conexión con base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();

			/** Sentencia SQL para ordenar por valoración */
			rs = st.executeQuery("SELECT * FROM pelicula ORDER BY valoracion DESC");

			while (rs.next()) {

				Pelicula p = new Pelicula();
				p.setIdPelicula(rs.getInt("idPelicula"));
				p.setNombrePelicula(rs.getString("nombrePelicula"));
				p.setAnioEstreno(rs.getInt("anioEstreno"));
				p.setCategoria(rs.getString("categoria"));
				p.setVisualizacion(rs.getInt("visualizacion"));
				p.setValoracion(rs.getInt("valoracion"));

				System.out.println(p);
			}

			/** Cierre de la conexión con la base de datos */
			con.getConnection().close();

		/** Catch que captura los posibles errores */	
		} catch (SQLException ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	
	/** Método para mostrar una lista con las películas más vistas */
	public void listaMasVistas() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			/** Conexión con base de datos */
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();

			/** Sentencia SQL para mostrar lista ordenada por orden de visualización */
			rs = st.executeQuery("SELECT * FROM pelicula ORDER BY visualizacion DESC");

			while (rs.next()) {

				Pelicula p = new Pelicula();
				p.setIdPelicula(rs.getInt("idPelicula"));
				p.setNombrePelicula(rs.getString("nombrePelicula"));
				p.setAnioEstreno(rs.getInt("anioEstreno"));
				p.setCategoria(rs.getString("categoria"));
				p.setVisualizacion(rs.getInt("visualizacion"));
				p.setValoracion(rs.getInt("valoracion"));

				System.out.println(p);
			}

			/** Cierre de la conexión */
			con.getConnection().close();

		/** Catch que captura los posibles errores */
		} catch (SQLException ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
	
}
