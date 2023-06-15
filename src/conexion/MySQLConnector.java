package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/BDProduccion";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Password123#@!";
    // Casa 123
    // Trabajo Password123#@!
    public static Connection getConnection() throws SQLException {
        try {
        	String driver = "com.mysql.cj.jdbc.Driver";
        	Class.forName(driver);
           
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
