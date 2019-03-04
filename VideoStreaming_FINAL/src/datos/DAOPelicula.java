package datos;

import modelo.Pelicula;
import utilidades.LecturaDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPelicula implements I_DAOPelicula {

	static Scanner sc = new Scanner(System.in);

	public DAOPelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		Statement st = null;
		try {
			System.out.println("Código a dar de baja: " + idP);
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();
			String s = "delete from pelicula where idPelicula =" + idP;

			int i = st.executeUpdate(s);
			System.out.println(s + i);
			con.getConnection().close();

		}

		catch (Exception ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void mostrarPelicula(int idP) {
		Statement st = null;
		ResultSet rs = null;
		try {
			System.out.println("Código de la película a mostrar: " + idP);
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();

			rs = st.executeQuery("SELECT * FROM pelicula where idPelicula =" + idP);

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

			con.getConnection().close();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPelicula.class.getName()).log(Level.SEVERE, null, ex);
		}
	}	
	

}
