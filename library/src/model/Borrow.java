package model;

import java.util.Date;

public class Borrow {
    //借书时的各个属性
    private String bookId;
    private String readerId;
    private Date lendDate;
    private Date dueDate;
    private String overtime;
    //属性相关的方法

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "bookId='" + bookId + '\'' +
                ", readerId='" + readerId + '\'' +
                ", lendDate=" + lendDate +
                ", dueDate=" + dueDate +
                ", overtime='" + overtime + '\'' +
                '}';
    }
}
