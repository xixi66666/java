package sqlTools;

import database.DBtools;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowTools {

    //通过借书者id查询所借的书籍情况
    public List<Book> BookData(String id){
        String sql="select book.bookId,bookName,price,book.kind,author,publisher from reader,borrow,book where book.bookId = borrow.bookId and reader.readerId = borrow.readerId and reader.readerId = '" + id + "'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        List<Book> list = new ArrayList<>();
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getString("bookId"));
                book.setBookName(resultSet.getString("bookName"));
                book.setPrice(resultSet.getInt("price"));
                book.setType(resultSet.getString("kind"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublisher(resultSet.getString("publisher"));
                list.add(book);
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }

    //进行数据删除操作，删除借阅的信息，表示归还图书
    public int ReturnBook(String id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        int flag = 0;
        String sql = "delete from borrow where bookId ='" +id +"'";

        try {
            connection =dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ? "还书成功" : "还书失败");
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
    //通过书籍id查询书籍
    public List<Book> Search_Reader_Id(String id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();
        String sql = "select readerId,lendDate from borrow where bookId = '" + id + "'";
        List<Book> list = new ArrayList<>();

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Book book = new Book();
            while(resultSet.next())
            book.setBookId(resultSet.getString("bookId"));
            book.setBookName(resultSet.getString("bookName"));
            book.setPrice(resultSet.getInt("price"));
            book.setType(resultSet.getString("kind"));
            book.setAuthor(resultSet.getString("author"));
            book.setPublisher(resultSet.getString("publisher"));
            list.add(book);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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

    //查看书籍是否未被借出，是则返回true，否则返回false
    public Boolean WhetherIn(String id){
        DBtools dBtools = new DBtools();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from borrow";

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getString("bookId") != null){
                    if(resultSet.getString("bookid") .equals(id))
                        return false;
                }
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
        return  true;
    }

    //进行数据插入，即增加借阅的信息
    public int BorrowBook(String idReader,String idbook){
        int flag = 0;
//        Date date = new Date();
//        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//        java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
//        java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
        String sql="insert into borrow (readerId,bookId,overtime)values(?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        DBtools dBtools = new DBtools();

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idReader);
            preparedStatement.setString(2,idbook);
//            preparedStatement.setDate(3,sqlDate);
//            preparedStatement.setDate(4,sqlDate);
            preparedStatement.setString(3,"否");
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
}
