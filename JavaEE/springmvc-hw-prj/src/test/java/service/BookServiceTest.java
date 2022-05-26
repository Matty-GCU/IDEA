package service;


import org.junit.jupiter.api.Test;
import pojo.Book;

import java.util.List;

public class BookServiceTest {
    BookService bookService = new BookService();
    
    @Test
    public void selectAll() {
        List<Book> books = bookService.selectAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    @Test
    public void selectBookByName() {
        List<Book> books = bookService.selectBookByName("%Java%");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
