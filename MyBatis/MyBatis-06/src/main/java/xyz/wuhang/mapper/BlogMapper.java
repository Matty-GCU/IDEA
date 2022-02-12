package xyz.wuhang.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.wuhang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);
    List<Blog> getBlogs(Map map);
    List<Blog> getBlogsByForEach(List blogIds);
    int updateBlog(Map map);
}
