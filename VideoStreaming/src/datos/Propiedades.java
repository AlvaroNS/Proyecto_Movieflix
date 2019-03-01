package datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

public class Propiedades {

	public Propiedades() {
	}

	public static Properties propiedadesConex() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
		
		Properties pro = new Properties ();
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("database.properties");
			pro.load(in);
		}
		
		catch (FileNotFoundException ex) {
			Logger lgr = Logger.getLogger(Properties.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		
		catch (IOException ex) {
			Logger lgr = Logger.getLogger(Properties.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} 
         
			catch (IOException ex) {
				Logger lgr = Logger.getLogger(Properties.class.getName());
				lgr.log(Level.SEVERE, ex.getMessage(), ex);
			}
			
		}
		
        String url = pro.getProperty("db.url");
        String user = pro.getProperty("db.user");
        String passwd = pro.getProperty("db.passwd");

        try {

            con = DriverManager.getConnection(url, user, passwd);
            pst = con.prepareStatement("SELECT * FROM videostreaming");
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }


        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(Propiedades.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Propiedades.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
		return pro;
    
	}
	
}
