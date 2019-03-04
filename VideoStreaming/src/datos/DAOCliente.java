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
            ConexionBD con = new ConexionBD();
            con.ConexionDB();
            st = con.getConnection().createStatement();
            String q = "INSERT INTO cliente"
            		+ "(" + c.getIdCliente() + "," + c.getNombreCliente() + "," + c.getFechaNacimiento() + "," + c.getCiudad() + "," + c.getTipoAcceso() + ")"
            				+ " VALUES (?,?,?,?,?)";
            int i = st.executeUpdate(q);
			System.out.println(q + i);
            con.getConnection().close();

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
	public void modificarCliente (Cliente c ) {
		/**crear sentencia**/
		Statement st1 = null;
		try {
			
			System.out.println("Modificación datos del cliente.");
			int idm = LecturaDatos.leerInt("Codigo de cliente a modificar:");
			c.setIdCliente(idm);
			c.setCiudad(LecturaDatos.leerN("Ciudad del Cliente:"));
			c.setNombrecliente(LecturaDatos.leerN("Nombre del Cliente:"));
			c.setFechaNacimiento(LocalDate.of(LecturaDatos.leerInt("año de nacimiento:"), LecturaDatos.leerInt("mes de nacimiento:"), LecturaDatos.leerInt("día de nacimiento:")));
			c.setTipoAcceso(LecturaDatos.leerN("Tipo de acceso"));
			ConexionBD connect = new ConexionBD();
			st1= connect.getConnection().createStatement();
			String q = "UPDATE CLIENTE SET nombreCliente = " + c.getNombreCliente() + ",fechaNacimiento= " + c.getFechaNacimiento() + ",ciudad= " + c.getCiudad() + ",tipoAcceso= " + c.getTipoAcceso() + ",WHERE idCliente= " + c.getIdCliente();
			System.out.println("Sentencia: " + q);
			int i = st1.executeUpdate(q);
			connect.getConnection().close();
		}catch(SQLException ex) {
			Logger.getLogger("Error con el SQL");
		}

	}
}

