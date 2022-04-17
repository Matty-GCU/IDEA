package org.example.service;

import org.example.pojo.Book;

import java.util.List;

public interface BookService {
    
    int insertBook(Book book);
    
    int deleteBookById(int id);
    
    int updateBookById(Book book);
    
    Book selectBookById(int id);
    
    List<Book> selectAllBooks();
}
