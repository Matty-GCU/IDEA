package pojo;

import java.util.List;

public class BookShelf {
    
    int id;
    String name;    //category
    List<Book> books;
    
    public BookShelf() {
    }
    
    public BookShelf(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
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
    
    public List<Book> getBooks() {
        return books;
    }
    
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    @Override
    public String toString() {
        return "书架{" +
                "书架编号=" + id +
                ", 图书类别='" + name + '\'' +
                ", 包含图书=\n" + books +
                "\n}";
    }
}
