package model;

import java.util.Objects;

public class Book {
    //book类的基本属性
    private String bookName;
    private String bookId;
    private int price;
    private String type;
    private String author;
    private String publisher;
    //属性的getter 和 setter 方法


    public Book() {
    }

    public Book(String bookName, String bookId, int price, String type, String author, String publisher) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.price = price;
        this.type = type;
        this.author = author;
        this.publisher = publisher;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                price == book.price &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(type, book.type) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, bookId, price, type, author, publisher);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookId=" + bookId +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
