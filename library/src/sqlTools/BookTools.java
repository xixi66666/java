package sqlTools;

import database.DBtools;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookTools {
    //获取书籍的信息
    public List<Book> GetBookData() {
        String sql = "select * from book";
        DBtools dBtools = new DBtools();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
    //通过书名查询书籍
    public List<Book> GetBookData(String bookname){
        String sql = "select bookId,bookName,price,kind,author,publisher from Book where bookName like'%" + bookname + "%'";
        DBtools dBtools = new DBtools();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
    //通过id寻找书籍信息
    public List<Book> SearchBookData(String id){
        String sql = "select * from book where bookId = '"+id+"'";
        DBtools dBtools = new DBtools();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
    //添加书籍信息

    public int  AddBook(Book book){
        int flag = 0;
        String sql = "insert into book (bookId,bookName,price,kind,author,publisher) values (?,?,?,?,?,?)";
        DBtools dBtools = new DBtools();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setInt(3, book.getPrice());
            preparedStatement.setString(4, book.getType());
            preparedStatement.setString(5, book.getAuthor());
            preparedStatement.setString(6, book.getPublisher());
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return flag;
        }

        //更新书籍信息
    public int UpdataBookData(Book book){
        int flag = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBtools dBtools = new DBtools();
        String sql = "update book set bookId=?,bookName=?,price=?,kind=?,author=?,publisher=? where bookId=?";

        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getBookId());
            preparedStatement.setString(2,book.getBookName());
            preparedStatement.setInt(3,book.getPrice());
            preparedStatement.setString(4,book.getType());
            preparedStatement.setString(5,book.getAuthor());
            preparedStatement.setString(6,book.getPublisher());
            preparedStatement.setString(7,book.getBookId());
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
    public int DeleteBook(String id){
        int flag = 0;
        String sql = "delete from Book where idBook=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBtools dBtools = new DBtools();
        try {
            connection = dBtools.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            flag = preparedStatement.executeUpdate();
            System.out.println(flag == 1 ?"删除成功" : "删除失败");
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
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    }