package datos;

import modelo.Cliente;
import utilidades.LecturaDatos;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente implements I_DAOCliente {
	
	static Scanner sc = new Scanner(System.in);
	
	public DAOCliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void altaCliente(Cliente c) {
		Statement st = null;
		try {
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection().createStatement();
			
			c.setNombrecliente(LecturaDatos.leerString("Introduce el nombre del CLiente"));
			c.setCiudad(LecturaDatos.leerString("Introduce la ciudad del CLiente"));
			c.setFechaNacimiento(LocalDate.of(LecturaDatos.leerInt("año de nacimiento:"),
					LecturaDatos.leerInt("mes de nacimiento:"), LecturaDatos.leerInt("día de nacimiento:")));
			c.setTipoAcceso(LecturaDatos.leerString("Introduce el tipo de acceso del CLiente"));
			
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

	 
	public void bajaCliente (int id) {
		Statement st = null;
		try {
			System.out.println("Código a dar de baja: " + id);
			ConexionBD con = new ConexionBD();
			con.ConexionDB();
			st = con.getConnection ().createStatement ();
			String s = "delete from cliente where idCliente =" + id;
			
			int i = st.executeUpdate(s);
			System.out.println(s + i);
			con.getConnection ().close();
			
		}
		
		catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
