package xyz.wuhang.mapper;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.wuhang.pojo.Blog;
import xyz.wuhang.utils.IdUtils;
import xyz.wuhang.utils.MyBatisUtils;

import java.util.*;

class BlogMapperTest {

    SqlSession sqlSession;
    BlogMapper mapper;

    @BeforeEach
    void setUp() {
        sqlSession = MyBatisUtils.getSqlSession();
        mapper = sqlSession.getMapper(BlogMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void addBlogTest() {
        Blog blog1 = new Blog(IdUtils.randomId(), "Maven教程", "wuhang", new Date(), 3);
        Blog blog2 = new Blog(IdUtils.randomId(), "Junit教程", "wuhang", new Date(), 2);
        Blog blog3 = new Blog(IdUtils.randomId(), "MyBatis教程", "wuhang", new Date(), 0);
        Blog blog4 = new Blog(IdUtils.randomId(), "基金教程", "kuang", new Date(), 22000);
        mapper.addBlog(blog1);
        mapper.addBlog(blog2);
        mapper.addBlog(blog3);
        mapper.addBlog(blog4);
    }

    @Test
    void queryBlogTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<Blog> blogs = mapper.getBlogsByForEach(list);
        for(Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    void updateBlogTest() {
        Map<Object, Object> map = new HashMap<>();
        map.put("blogTitle", "Maven");
        map.put("blogAuthor", "狂神2");
        map.put("blogId", "a618e84e-1d3f-4922-bc94-8cba47894948");
        System.out.println(mapper.updateBlog(map));
    }

}
