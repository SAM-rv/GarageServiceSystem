package config;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url="jdbc:mysql://localhost:3306/garageservices";
    private static final String user="root";
    private static final String pass="rutavikVS@5120";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pass);
    }
}
