package service;


import org.junit.jupiter.api.Test;
import pojo.Book;

import java.util.List;

public class BookServiceTest {
    
    @Test
    public void selectAll() {
        BookService bookService = new BookService();
        List<Book> books = bookService.selectAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
