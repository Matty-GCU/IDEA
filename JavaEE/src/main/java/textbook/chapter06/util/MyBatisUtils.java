package textbook.chapter06.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    
    static SqlSessionFactory sqlSessionFactory;
    
    public static SqlSession getSqlSession() {
        //单例模式
        if(sqlSessionFactory != null) {
            return sqlSessionFactory.openSession();
        }
        String resource = "mybatis/ch06/mybatis-config.xml";
        try(InputStream inputStream = Resources.getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory.openSession();
    }
    
}
