package sqlTools;

import database.DBtools;
import model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorTools {
    //返回作者信息的方法
    public List<Author> AutherData(String name)  {
        String sql = "select id,name from author where name = ?";
        DBtools dBtools = new DBtools();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<Author> list = new ArrayList<>();
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Author author = new Author();
                author.setName(resultSet.getString("name"));
                author.setId(resultSet.getString("id"));
                list.add(author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if ( resultSet != null) {
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

    public List<Author> AuthorData() {
        String sql="select name,id from author";
        DBtools db = new DBtools();
        Connection conn = null;
        try {
            conn = db.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSets=null;
        List<Author> list = new ArrayList<Author>();
        try {
            PreparedStatement st =conn.prepareStatement(sql);
            resultSets=st.executeQuery(sql);
            while(resultSets.next()){
                Author author=new Author();
                author.setName(resultSets.getString("name"));
                author.setId(resultSets.getString("id"));
                list.add(author);
            }
            resultSets.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //增
    public int AddAuthor(Author author){
        String sql = "insert into author(name) values (?)";
        DBtools dBtools = new DBtools();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int flag = 0;
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,author.getName());
            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ? "插入成功" : "插入失败");
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
        return flag;
    }

    public int UpdateAuthor(Author author){
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBtools dBtools = new DBtools();
        String sql = "update author set name=? where id=?";
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,author.getName());
            preparedStatement.setString(2,author.getId());
            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ?"修改成功" : "修改失败");
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
