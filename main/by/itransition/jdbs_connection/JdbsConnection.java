package main.by.itransition.jdbs_connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbsConnection {

    //private static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/group_c48";
    //private static final String JDBC_USER = "root";
    //private static final String JDBC_PASSWORD = "password";

    private Connection connection;

    public Connection getConnection(){
        Properties properties = new Properties();
        Connection conn = null;
        try (InputStream in = JdbsConnection.class.getClassLoader().getResourceAsStream("database.properties")){
            properties.load(in);
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
