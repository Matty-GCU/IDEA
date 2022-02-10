package xyz.wuhang.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.wuhang.pojo.Student;
import xyz.wuhang.pojo.Teacher;
import xyz.wuhang.utils.MyBatisUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherMapperTest {

    SqlSession sqlSession;

    @BeforeEach
    void setUp() {
        sqlSession = MyBatisUtils.getSqlSession();
    }

    @AfterEach
    void tearDown() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    void getTeacherById() {
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacherById(1);
        for(Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}