package pojo;

import java.sql.Date;

public class Record {
    User user;
    Book book;
    Date date;
    
    public Record() {
    }
    
    public Record(User user, Book book, Date date) {
        this.user = user;
        this.book = book;
        this.date = date;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        return "借书记录{" +
                "借书用户=" + user +
                ", 借的书=" + book +
                ", 借书日期=" + date.toLocalDate() +
                '}';
    }
}
