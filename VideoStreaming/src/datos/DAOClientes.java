package datos;

import modelo.Cliente;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOClientes implements I_DAOClientes {
	
	static Scanner sc = new Scanner(System.in);
	
	 public void altaCliente (Cliente c) {
        Statement st = null;
        
        try {
            ConexionBD con = new ConexionBD();
            con.ConexionDB();
            st = con.getConnection().createStatement();
            String q = "INSERT INTO `cliente` VALUES ('" + c.getIdCliente() + "','" + c.getNombreCliente() + "','" + c.getFechaNacimiento() + "','" + c.getCiudad() + "','" + c.getTipoAcceso() + "')";
            System.out.println(q);
            int i = st.executeUpdate(q);
            con.getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
