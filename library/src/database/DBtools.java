package database;

import java.sql.*;

public class DBtools {
    public Connection connection = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    /*将注册驱动的步骤写入静态代码块的原因：
        静态代码块中的代码在类加载时加载，并且只加载一次，所以在多次链接的时候可以减少时间消耗
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

  public Connection getConnection() throws SQLException {
        //获取链接
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","qsc13579");
  }

}
