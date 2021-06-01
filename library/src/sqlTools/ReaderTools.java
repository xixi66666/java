package sqlTools;

import database.DBtools;
import model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderTools {

    //通过读者id返回读者信息
    public List<Reader> ReaderDataById(String id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        List<Reader> list = new ArrayList<>();
        String sql = "select * from reader where reader.readerId = '"+id+"'";
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Reader reader = new Reader();
            while(resultSet.next()){
                reader.setReaderId(resultSet.getString("readerId"));
                reader.setReaderName(resultSet.getString("readerName"));
                reader.setType(resultSet.getString("kind"));
                reader.setSex(resultSet.getString("sex"));
                reader.setPassword(resultSet.getString("password"));
                list.add(reader);
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
    public List<Reader> ReaderDataByName(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        List<Reader> list = new ArrayList<>();
        String sql = "select * from reader where reader.readerName like '%"+name+"%'";
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Reader reader = new Reader();
            while(resultSet.next()){
                reader.setReaderId(resultSet.getString("readerId"));
                reader.setReaderName(resultSet.getString("readerName"));
                reader.setType(resultSet.getString("kind"));
                reader.setSex(resultSet.getString("sex"));
                reader.setPassword(resultSet.getString("password"));
                list.add(reader);
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

    //查询所有的读者信息
    public List<Reader> AllReaderData(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        List<Reader> list = new ArrayList<>();
        String sql = "select * from reader ";
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Reader reader = new Reader();
                reader.setReaderId(resultSet.getString("readerId"));
                reader.setReaderName(resultSet.getString("readerName"));
                reader.setType(resultSet.getString("kind"));
                reader.setSex(resultSet.getString("sex"));
                reader.setPassword(resultSet.getString("password"));
                list.add(reader);
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

    //验证读者输入的id和密码是否正确
    public Boolean ReaderLogin(String id,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        String sql = "select readerId,password from reader where readerId = ? and password = ?";

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                return true;
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
        return false;
    }

    //增加读者
    public int AddReader(Reader reader){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        String sql = "insert into reader values(?,?,?,?,?)";
        int flag=0;
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,reader.getReaderId());
            preparedStatement.setString(2,reader.getReaderName());
            preparedStatement.setString(3,reader.getType());
            preparedStatement.setString(4,reader.getSex());
            preparedStatement.setString(5,reader.getPassword());

            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ?"插入成功":"插入失败");
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

    //更新读者信息
    public int UpdateReader(Reader reader){
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        String sql = "update reader set readerName = ?,readerId = ?,kind=?,sex=?,password=? where idReader=?";

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,reader.getReaderName());
            preparedStatement.setString(2,reader.getReaderId());
            preparedStatement.setString(3,reader.getType());
            preparedStatement.setString(4,reader.getSex());
            preparedStatement.setString(5,reader.getPassword());
            preparedStatement.setString(6,reader.getReaderId());

            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ? "更新成功" : "更新失败");
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

    //删除读者信息
    public int DeleteReaderData(String id){
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBtools dBtools = new DBtools();
        String sql = "delete from reader where readerId = ?";

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ?"删除成功" :"删除失败");
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
