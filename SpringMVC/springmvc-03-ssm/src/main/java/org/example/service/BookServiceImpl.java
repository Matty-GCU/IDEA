package org.example.service;

import org.example.dao.BookMapper;
import org.example.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    BookMapper bookMapper;
    
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    
    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }
    
    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }
    
    @Override
    public int updateBookById(Book book) {
        return bookMapper.updateBookById(book);
    }
    
    @Override
    public Book selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }
    
    @Override
    public List<Book> selectAllBooks() {
        return bookMapper.selectAllBooks();
    }
}
