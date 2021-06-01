package sqlTools;

import database.DBtools;
import model.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherTools {
    //通过出版社名称查询出版社信息
    public Publisher PublisherData(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        Publisher publisher = new Publisher();
        String sql = "select * from publisher where name = ?";

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                publisher.setName(resultSet.getString("name"));
                publisher.setAddress(resultSet.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return publisher;
    }

    //返回全部出版社

    public List<Publisher> AllPublisherData(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        List<Publisher> list = new ArrayList<>();
        String sql = "select * from publisher";
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Publisher  publisher = new Publisher();
                publisher.setName(resultSet.getString("name"));
                publisher.setAddress(resultSet.getString("address"));
                list.add(publisher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    //添加出版社信息

    public int AddPublisher(Publisher publisher){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBtools dBtools = new DBtools();
        String sql = "insert into publisher values(?,?)";
        int flag = 0;
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,publisher.getName());
            preparedStatement.setString(2,publisher.getAddress());
            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ?"插入成功" : "插入失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    //更新出版社信息
    public int UpdatePublisherData(Publisher publisher){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBtools dBtools = new DBtools();
        int flag = 0;
        String sql = "Update update publisher set name=?,address=? where name=?";

        try {
            connection = dBtools.getConnection();
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.setString(2, publisher.getAddress());
            preparedStatement.setString(3, publisher.getName());
            flag = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
