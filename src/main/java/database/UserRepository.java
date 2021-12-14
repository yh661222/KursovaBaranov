package database;
import com.example.demo.User;

import java.sql.*;


public class UserRepository {

    private final String databaseURL;


    public UserRepository(String databaseURL) {
        this.databaseURL = databaseURL;
    }


    public boolean setupCredentials(User Emp) throws SQLException{
        try (Connection connection = DriverManager.getConnection(this.databaseURL)) {
            System.out.println("CONNECTED");
            String SQL = "Select Login from Employees where Login =?";
            try (PreparedStatement mystmnt = connection.prepareStatement(SQL)) {
                mystmnt.setString(1, Emp.getLogin());
                ResultSet rs = mystmnt.executeQuery();
                if (!rs.next()) {
                    String SQL2 = "INSERT INTO Employees (Login, Password) values( ?, ?)";
                    try (PreparedStatement insertStament = connection.prepareStatement(SQL2)) {
                        insertStament.setString(1, Emp.getLogin());
                        insertStament.setString(2, Emp.getPassword());
                        insertStament.executeUpdate();
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public int loginUser(User user) {
        String url = "jdbc:sqlserver://localhost;databaseName=Фургон Кави;user=Owner;password=12345";

        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("CONNECTED");

            String SQL = "Select Login, Password from Employees where Login =? and Password = ?";
            PreparedStatement mystmnt = connection.prepareStatement(SQL);
            mystmnt.setString(1,user.getLogin());
            mystmnt.setString(2,user.getPassword());
            ResultSet rs = mystmnt.executeQuery();
            if(!rs.next()){
                String SQL2 = "Select Login, Password from Owners where Login =? and Password = ?";
                mystmnt = connection.prepareStatement(SQL2);
                mystmnt.setString(1,user.getLogin());
                mystmnt.setString(2,user.getPassword());
                rs = mystmnt.executeQuery();
                if(!rs.next()){
                    return 0;
                }
                else{return 2;}
            }
            user.setLogin(rs.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

}
