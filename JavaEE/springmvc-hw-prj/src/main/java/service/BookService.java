package service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import pojo.Book;
import util.MyBatisUtil;

import java.util.List;

@Service
public class BookService {
    
    SqlSession sqlSession;
    
    public BookService() {
        sqlSession = MyBatisUtil.getSqlSession();
    }
    
    public List<Book> selectAllBooks() {
        return sqlSession.selectList("mapper.BookMapper.selectAllBooks");
    }
    
    public List<Book> selectBookByName(String bookName) {
        return sqlSession.selectList("mapper.BookMapper.selectBookByName", bookName);
    }
    
    public int insertBook(Book book) {
        return sqlSession.insert("mapper.BookMapper.insertBook", book);
    }
    
    public int updateBook(Book book) {
        return sqlSession.update("mapper.BookMapper.updateBookById", book);
    }
    
    public Book selectBookById(int id) {
        return sqlSession.selectOne("mapper.BookMapper.selectBookById", id);
    }
}
