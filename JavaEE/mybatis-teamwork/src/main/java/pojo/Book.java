package pojo;

public class Book {
    int id;
    String name;    //title
    double price;
    String author;  //authorName
    int number;
    BookShelf bookShelf;
    
    public Book() {
    }
    
    public Book(String name, double price, String author, int number, BookShelf bookShelf) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.number = number;
        this.bookShelf = bookShelf;
    }
    
    public Book(int id, String name, double price, String author, int number, BookShelf bookShelf) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.number = number;
        this.bookShelf = bookShelf;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public BookShelf getBookShelf() {
        return bookShelf;
    }
    
    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }
    
    @Override
    public String toString() {
        return "图书{" +
                "图书编号=" + id +
                ", 书名='" + name + '\'' +
                ", 价格=" + price +
                ", 作者='" + author + '\'' +
                ", 图书数量=" + number +
                (bookShelf == null ? "" : ", 所属书架类别='" + bookShelf.getName()) +
                "}";
    }
}
