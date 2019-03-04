package datos;

import modelo.Cliente;
import utilidades.LecturaDatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente implements I_DAOCliente {
	
	static Scanner sc = new Scanner(System.in);
	
	public DAOCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	 public void altaCliente (Cliente c) {
        Statement st = null;
        try {
            ConexionBD con = new ConexionBD();
            con.ConexionDB();
            st = con.getConnection().createStatement();
            System.out.print("\n Ingrese un código del cliente: \n");
            int  codigo = LecturaDatos.leerInt();
            System.out.print("Nombre: ");
            String nombre = LecturaDatos.leerString();
            System.out.print("Fecha: ");
            String fecha = LecturaDatos.leerString();
            System.out.print("Ciudad: ");
            String ciudad = LecturaDatos.leerString();
            System.out.print("Tipo de Acceso: ");
            String TipoAcceso = LecturaDatos.leerString();
            
            
            if (c == null) {
                String sql = "INSERT INTO productos VALUES (codigo, nombre, fecha, ciudad, TipoAcceso)";

                PreparedStatement pst = null;
                pst.setInt(1, codigo);
                pst.setString(2, nombre);
                pst.setString(3, fecha);
                pst.setString(4, ciudad);
                pst.setString(5, TipoAcceso);
                pst.execute(sql);
                
                int i = st.executeUpdate(sql);
    			System.out.println(sql + i);
                con.getConnection().close();
                System.out.print("Producto agregado\n");
            } else {
                System.out.print("ya existe este producto");
            }

        } catch (SQLException ex) {
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
