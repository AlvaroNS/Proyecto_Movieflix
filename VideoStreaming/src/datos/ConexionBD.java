package datos;

import java.sql.*;

public class ConexionBD {
	
	/** Conexi�n con la base de datos */
    Connection connection = null;
    String driverClassName = "com.mysql.oj.jdbc.Driver";
    
    /** Datos de la Base de datos */
    String driverUrl = "jdbc:mysql://192.168.101.101:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // En caso de que se quiera hacer una conexi�n local   
    //String driverUrl = "jdbc:mysql://localhost:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "grupo1";
    String password = "grupo1";

    
    /** M�todo para llamar a la conexi�n */
    public void ConexionDB() {
        try {
            //Class.forName(driverClassName);;            
            connection = DriverManager.getConnection(driverUrl, user, password);
            
        }  catch (SQLException E) {
            System.out.println("Excepcion SQL: " + E.getMessage());
            System.out.println("Estado SQL: " + E.getSQLState());
            System.out.println("Codigo del Error: " + E.getErrorCode());
        } catch (Exception E) {
            System.out.println("Otro problema: " + E);
        } 
    }

    public Connection getConnection() {
        return connection;
    }

    /** M�todo para pedir la desconexi�n */
    public void desconectar() {
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
