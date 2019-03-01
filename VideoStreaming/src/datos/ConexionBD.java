package datos;

import java.sql.*;

public class ConexionBD {
	
    Connection connection = null;
    String BD = "videostreaming";
    String driverClassName = "com.mysql.jdbc.Driver";
    String driverUrl = "jdbc:mysql://192.168.101.101:3306/videostreaming?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "grupo1";
    String password = "grupo1";

    public void ConexionDB() {
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverUrl, user, password);
            System.out.println("conexion correcta");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra el driver");
        } catch (SQLException E) {
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
