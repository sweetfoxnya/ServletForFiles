package servlet;

import java.sql.*;
import java.util.logging.Logger;

public class ConnectionPro {
    private static Connection con;
    private static final Logger logger = Logger.getLogger("");

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","dbrnjhbz");
            logger.info("Connection successful!");

        }catch(SQLException e ){
            System.out.println("Не удалось создать соединение");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return con;
    }

}