package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Book;
import pojo.BookShelf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {
    
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
    
    @Test
    void bookMapperTest() {
        System.out.println("=========== 使用select进行一对一级联查询 ===========");
        List<Book> books = sqlSession.selectList("mapper.BookMapper.selectAllBooks");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
        System.out.println();
        System.out.println("=========== 使用select进行一对一级联查询（使用<resultMap>将查询结果与返回对象绑定）（使用choose进行条件化查询） ===========");
        Book book1 = sqlSession.selectOne("mapper.BookMapper.selectBookById",10);
        System.out.println(book1);
        System.out.println();
        System.out.println();
        System.out.println("=========== 使用select进行一对一级联查询（使用<resultMap>将查询结果与返回对象绑定）（使用where+if进行条件化查询） ===========");
        books = sqlSession.selectList("mapper.BookMapper.selectBookByName","Java%");
        for (Book javaBook : books) {
            System.out.println(javaBook);
        }
        System.out.println();
        System.out.println();
        System.out.println("=========== 使用foreach元素查询 ===========");
        List<Integer> bookIdList = new ArrayList();
        bookIdList.add(1);
        bookIdList.add(2);
        bookIdList.add(3);
        bookIdList.add(4);
        books = sqlSession.selectList("mapper.BookMapper.selectBook", bookIdList);
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
        System.out.println();
        System.out.println("=========== 使用insert进行新数据的创建和插入（连同关联对象一起写入数据库） ===========");
        BookShelf bookShelf = sqlSession.selectOne("mapper.BookShelfMapper.selectBookShelfById",1);
        Book newBook = new Book("数据结构", 35.0, "严蔚敏", 6, bookShelf);
        System.out.println(sqlSession.insert("mapper.BookMapper.insertBook", newBook));
        System.out.println();
        System.out.println();
        System.out.println("=========== 使用update进行数据修改 ===========");
        book1.setName("新");
        System.out.println(sqlSession.update("mapper.BookMapper.updateBookById", book1));
    }
    
    @Test
    void bookShelfMapperTest() {
        System.out.println("=========== 一对多级联查询 ===========");
        BookShelf bookShelf = sqlSession.selectOne("mapper.BookShelfMapper.selectBookShelfById", 2);
        System.out.println(bookShelf);
    }
}
