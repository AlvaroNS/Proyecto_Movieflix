package datos;

import modelo.Cliente;
import utilidades.LecturaDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * 
 * @author Equipo1
 * fecha: 04/03/2018
 * versión: 1
 * 
 */
public class DAOCliente implements I_DAOCliente {
	
	static Scanner sc = new Scanner(System.in);
	 private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("Mensaje");
	
	public DAOCliente() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	
	 public void altaCliente (Cliente c) {
        Statement st = null;
        
     /*   System.out.print("\n Ingrese un código del cliente: \n");
        int  codigo = LecturaDatos.leerInt();
        System.out.print("Nombre: ");
        String nombre = LecturaDatos.leerString();
        System.out.print("Precio: ");
        precio = LecturaDatos.
        System.out.print("Stock: ");
        stock = entrada.nextInt();
        p = busqueda(codigo, productos);

        if (p == null) {
            productos.addElement(new Producto(codigo, nombre, precio, stock));

            **String sql = "INSERT INTO productos (ID, Nombre, Precio, Stock) VALUES(?,?,?,?)";

            PreparedStatement pst;
            pst = cn.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.setString(2, nombre);
            pst.setDouble(3, precio);
            pst.setInt(4, stock);
            pst.execute(sql);**

            System.out.print("Producto agregado\n");
        } else {
            System.out.print("ya existe este producto");
        }
        */
        try {
            Connection con = new ConexionBD().getConnection();
            st=con.createStatement();
            String q = "INSERT INTO cliente"
            		+ "(" + c.getIdCliente() + "," + c.getNombreCliente() + "," + c.getFechaNacimiento() + "," + c.getCiudad() + "," + c.getTipoAcceso() + ")"
            				+ " VALUES (?,?,?,?,?)";
            int i = st.executeUpdate(q);
			System.out.println(q + i);
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	 
	public void bajaCliente (int id) {
		Statement st = null;
		try {
			System.out.println("Código a dar de baja: " + id);
			Connection con = new ConexionBD().getConnection();
			st = con.createStatement ();
			String s = "delete from cliente where idCliente =" + id;
			
			int i = st.executeUpdate(s);
			System.out.println(s + i);
			con.close();
			
		}
		
		catch (Exception ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	/** Modificar cliente existente en Base de datos**/
	public void modificarCliente (Cliente c ) {
		/**crear sentencia**/
		Statement st1 = null;
		Logger.getLogger("Creando variable sentencia");
		
		/** presentación del metodo**/
		try {
			
			System.out.println("Modificación datos del cliente.");
			/** codigo del cliente que se desea modificar**/
			int idm = LecturaDatos.leerInt("Codigo de cliente a modificar:");
			/** pido los datos nuevos del cliente existrente**/
			c.setIdCliente(idm);
			c.setCiudad(LecturaDatos.leerN("Ciudad del Cliente:"));
			c.setNombrecliente(LecturaDatos.leerN("Nombre del Cliente:"));
			c.setFechaNacimiento(LocalDate.of(LecturaDatos.leerInt("año de nacimiento:"), LecturaDatos.leerInt("mes de nacimiento:"), LecturaDatos.leerInt("día de nacimiento:")));
			c.setTipoAcceso(LecturaDatos.leerN("Tipo de acceso"));
			/** conectando a base de datos**/
			Connection connect = new ConexionBD().getConnection();
			/** detallando sentencia**/
			st1= connect.createStatement();
			/** creo concatenado de sentencias SQL y variables**/
			String q = "UPDATE CLIENTE SET nombreCliente = '" + c.getNombreCliente() + "',fechaNacimiento= '" + c.getFechaNacimiento() + "',ciudad= '" + c.getCiudad() + "',tipoAcceso= '" + c.getTipoAcceso() + "' WHERE idCliente= " + c.getIdCliente();
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
}

