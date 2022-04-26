package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.BookShelf;

import java.io.IOException;
import java.io.InputStream;

public class BookShelfMapperTest {
    static SqlSession sqlSession;
    
    @BeforeAll
    static void setUp() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }
    
    /**
     * 一对多级联查询
     */
    @Test
    void selectBookShelfById() {
        BookShelf bookShelf = sqlSession.selectOne("mapper.BookShelfMapper.selectBookShelfById", 2);
        System.out.println(bookShelf);
    }
}
