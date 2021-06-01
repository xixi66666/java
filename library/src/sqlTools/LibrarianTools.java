package sqlTools;

import database.DBtools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianTools {
    public Boolean Login(String username,String password){
        Connection connection = null;
        DBtools dBtools = new DBtools();
        String sql = "select nameUser,password from librarian where nameUser = '" +username +"'and password = '" + password +"'";
        try {
            connection = dBtools.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
