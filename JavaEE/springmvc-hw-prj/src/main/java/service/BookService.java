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
    
}
