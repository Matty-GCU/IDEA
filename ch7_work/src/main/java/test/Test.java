package test;
import po.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
//        璇诲彇mybatis-config.xml
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
        SqlSession ss=ssf.openSession(true);
        Book book=(Book)ss.selectOne("mapper.UserMapper.selectById",1);
        System.out.println(book.toString());
        List books=ss.selectList("mapper.UserMapper.selectByName","Java%");
        System.out.println(books);
        Book newbook=new Book("鏁版嵁缁撴瀯",35.0,"涓ヨ敋鏁�",6,1);
        System.out.println( ss.insert("mapper.UserMapper.insertData",newbook));
        List allBook=ss.selectList("mapper.UserMapper.selectAll");
        System.out.println(allBook);
    }
}
