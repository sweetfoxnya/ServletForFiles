package servlet;
import java.sql.*;

public class UserBD {
    Connection con ;

    public UserBD(Connection con) {
        this.con = con;
    }

    public boolean saveUser(User user){
        boolean ok = false;
        try{
            String query = "insert into user (Name, Email, Password) values (?, ?, ?)";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getName());
            pt.setString(2, user.getEmail());
            pt.setString(3, user.getPassword());


            pt.executeUpdate();
            return true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public User getUser(String name) throws SQLException {

        Statement statement = con.createStatement();
        statement.execute("select * from user where Name = '" + name + "'");
        ResultSet resultSet = statement.getResultSet();
        if (resultSet.next()) {
            return new User(resultSet.getString("Name"),resultSet.getString("Email"), resultSet.getString("Password"));
        }
        return null;
    }
}
