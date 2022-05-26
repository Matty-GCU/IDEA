package service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import pojo.BookShelf;
import util.MyBatisUtil;

@Service
public class BookShelfService {
    
    SqlSession sqlSession;
    
    public BookShelfService() {
        sqlSession = MyBatisUtil.getSqlSession();
    }
    
    public BookShelf getById(int id) {
        BookShelf bookShelf = sqlSession.selectOne("mapper.BookShelfMapper.selectBookShelfById", id);
        return bookShelf;
    }
    
}
