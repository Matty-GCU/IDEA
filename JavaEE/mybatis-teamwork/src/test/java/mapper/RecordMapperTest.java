package mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojo.Record;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RecordMapperTest {
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
     * 多对多级联查询
     */
    @Test
    void selectAllRecord() {
        List<Record> recordList = sqlSession.selectList("mapper.RecordMapper.selectAllRecord");
        for (Record record : recordList) {
            System.out.println(record);
        }
    }
}
