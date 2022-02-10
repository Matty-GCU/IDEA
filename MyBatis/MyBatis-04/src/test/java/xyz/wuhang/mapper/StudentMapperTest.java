package xyz.wuhang.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.wuhang.pojo.Student;
import xyz.wuhang.utils.MyBatisUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

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
    void getAllStudents() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudents = mapper.getAllStudents();
        for(Student student : allStudents) {
            System.out.println(student);
        }
    }
    @Test
    void getAllStudents2() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudents = mapper.getAllStudents2();
        for(Student student : allStudents) {
            System.out.println(student);
        }
    }
}