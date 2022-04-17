package org.example.service;

import org.example.pojo.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookServiceImplTest {
    
    BookServiceImpl bookServiceImpl;
    
    @BeforeEach
    void setUp() {
        bookServiceImpl = new BookServiceImpl();
    }
    
//    @AfterEach
//    void tearDown() {
//    }
    
    @Test
    void insertBook() {
    }
    
    @Test
    void deleteBookById() {
    }
    
    @Test
    void updateBookById() {
    }
    
    @Test
    void selectBookById() {
    }
    
    @Test
    void selectAllBooks() {
        List<Book> books = bookServiceImpl.selectAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}