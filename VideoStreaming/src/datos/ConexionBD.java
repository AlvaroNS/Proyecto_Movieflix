package datos;

import java.sql.*;

public class ConexionBD {
	
    Connection connection = null;
    String driverClassName = "com.mysql.oj.jdbc.Driver";
    String driverUrl = "jdbc:mysql://192.168.101.101:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //String driverUrl = "jdbc:mysql://localhost:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "grupo1";
    String password = "grupo1";

    public void ConexionDB() {
    	System.out.println("-- entro al constructor de conexionDB");
        try {
        	System.out.println("-- ConexionDB 1");
            //Class.forName(driverClassName);
        	System.out.println("-- ConexionDB 2");            
            connection = DriverManager.getConnection(driverUrl, user, password);
        	System.out.println("-- ConexionDB 3");
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

    public void desconectar() {
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
