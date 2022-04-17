package org.example.dao;

import org.example.pojo.Book;

import java.util.List;

public interface BookMapper {
    
    /**
     * 增加一本书
     */
    int insertBook(Book book);
    
    /**
     * 删除一本书
     */
    int deleteBookById(int id);
    
    /**
     * 更新一本书
     */
    int updateBookById(Book book);
    
    /**
     * 查询一本书
     */
    Book selectBookById(int id);
    
    /**
     * 查询所有书
     */
    List<Book> selectAllBooks();
    
}
