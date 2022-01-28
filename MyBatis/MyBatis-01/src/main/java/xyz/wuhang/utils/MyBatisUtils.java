package xyz.wuhang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    //从 XML 文件中构建 SqlSessionFactory 的实例
    static {
        //为什么不需要写绝对路径？等会儿看target就知道。它是不是放在了类路径？
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            //加载资源文件
            inputStream = Resources.getResourceAsStream(resource);
        } catch(IOException e) {
            e.printStackTrace();
        }
        //SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
        //SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先配置的 Configuration 实例来构建出 SqlSessionFactory 实例。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
