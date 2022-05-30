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

public class BookMapperTest {
    
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
     * 使用select进行查询操作
     */
    @Test
    void selectAllBooks() {
        List<Book> books = sqlSession.selectList("mapper.BookMapper.selectAllBooks");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    /**
     * 使用select进行查询操作
     * 使用<resultMap>将查询结果与返回对象绑定
     * 使用<choose>进行条件化查询
     */
    @Test
    void selectBookById() {
        Book book1 = sqlSession.selectOne("mapper.BookMapper.selectBookById",10);
        System.out.println(book1);
    }
 
    /**
     * 使用select进行查询操作
     * 使用<resultMap>将查询结果与返回对象绑定
     * 使用<where>、<if>进行条件化查询
     */
    @Test
    void selectBookByName() {
        List<Book> books = sqlSession.selectList("mapper.BookMapper.selectBookByName","Java%");
        for (Book javaBook : books) {
            System.out.println(javaBook);
        }
    }
    
    /**
     * 使用select进行查询操作
     * 使用<foreach>元素
     */
    @Test
    void selectSomeBook() {
        List<Integer> bookIdList = new ArrayList();
        bookIdList.add(1);
        bookIdList.add(2);
        bookIdList.add(3);
        bookIdList.add(4);
        List<Book> books = sqlSession.selectList("mapper.BookMapper.selectSomeBook", bookIdList);
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    /**
     * 使用insert进行新数据的创建和插入
     * 连同关联对象一起写入数据库
     */
    @Test
    void insertBook() {
        BookShelf bookShelf = new BookShelf(4, "科幻", null);
        Book newBook = new Book("刘慈欣短篇小说集", 99.0, "刘慈欣", 10, bookShelf);
        System.out.println(sqlSession.insert("mapper.BookMapper.insertBook", newBook));
    }
    
    /**
     * 使用update进行数据修改
     */
    @Test
    void updateBookById() {
        Book book1 = sqlSession.selectOne("mapper.BookMapper.selectBookById",10);
        book1.setName("新书名");
        System.out.println(sqlSession.update("mapper.BookMapper.updateBookById", book1));
    }
    
    /**
     * 后来为了springmvc-hw-prj才加的功能
     */
    @Test
    void deleteBookById() {
        int delete = sqlSession.delete("mapper.BookMapper.deleteBookById", 18);
        System.out.println("删掉了" + delete + "本书");
    }
}
