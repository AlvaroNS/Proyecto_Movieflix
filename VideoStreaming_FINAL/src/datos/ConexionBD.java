package datos;

import java.sql.*;

public class ConexionBD {
	
    Connection connection = null;
    String driverClassName = "com.mysql.oj.jdbc.Driver";
    String driverUrl = "jdbc:mysql://192.168.101.101:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // En caso de que se quiera hacer una conexi�n local   
    //String driverUrl = "jdbc:mysql://localhost:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "grupo1";
    String password = "grupo1";
<<<<<<< HEAD:VideoStreaming/src/datos/ConexionBD.java
    
    public ConexionBD() {
    	System.out.println("-- entro al constructor de conexionDB");
=======

    public void ConexionDB() {
>>>>>>> b13a4f3815ac785c2ba7d5e77dc872c3cbcefa4e:VideoStreaming_FINAL/src/datos/ConexionBD.java
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

    public void desconectar() {
        try {
            connection.close();
            connection = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
