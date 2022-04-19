package org.example.service;

import org.example.pojo.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

class BookServiceImplTest {
    
    BookService bookService;
    
    @BeforeEach
    void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-service.xml");
        this.bookService = applicationContext.getBean("bookServiceImpl", BookServiceImpl.class);
    }
    
    @Test
    void insertBook() {
        // 注意这个对象的id属性没有被用到，因为我写的insert语句实际上并没有向id字段插入数据。
        // 数据库会自动为新插入记录的id字段赋值。
        int rowAffected = bookService.insertBook(new Book(999, "书名4", 100, "这是第四本书"));
        System.out.println(rowAffected);
    }
    
    @Test
    void deleteBookById() {
        int rowAffected = bookService.deleteBookById(4);
        System.out.println(rowAffected);
    }
    
    @Test
    void updateBookById() {
        int rowAffected = bookService.updateBookById(new Book(3, "Linux新版", 16, "从进门到改行"));
//         int rowAffected = bookService.updateBookById(new Book(3, "Linux", 16, "从进门到改行"));
        System.out.println(rowAffected);
    }
    
    @Test
    void selectBookById() {
        Book book = bookService.selectBookById(3);
        System.out.println(book);
    }
    
    @Test
    void selectAllBooks() {
        List<Book> books = bookService.selectAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}