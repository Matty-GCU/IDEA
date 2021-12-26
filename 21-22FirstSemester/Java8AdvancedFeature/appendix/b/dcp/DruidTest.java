package appendix.b.dcp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidDataSource;

public class DruidTest {
    public static void main(String[] args) throws Exception {
        /**
         * 测试代码来自：
         * Druid连接池的使用 - chy_18883701161 - 博客园
         * https://www.cnblogs.com/chy18883701161/p/12594889.html
         */

        /**
         * 以下是纯代码方式：
         * （另一种方式是用druid.properties文件来配置，不过这个文件要放在src目录下才能用）
         * （数据库连接池可以用在springboot里，这里不纠结细节和各种原理，能跑起来就好）
         */

        //数据源配置
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1/test?serverTimezone=UTC");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //这个可以缺省的，会根据url自动识别
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //下面都是可选的配置
        dataSource.setInitialSize(10);  //初始连接数，默认0
        dataSource.setMaxActive(30);  //最大连接数，默认8
        dataSource.setMinIdle(10);  //最小闲置数
        dataSource.setMaxWait(2000);  //获取连接的最大等待时间，单位毫秒
        dataSource.setPoolPreparedStatements(true); //缓存PreparedStatement，默认false
        dataSource.setMaxOpenPreparedStatements(20); //缓存PreparedStatement的最大数量，默认-1（不缓存）。大于0时会自动开启缓存PreparedStatement，所以可以省略上一句代码

        //获取连接
        Connection connection = dataSource.getConnection();

        //Statement接口
        Statement statement = connection.createStatement();
        String sql1 = "insert into students (id, name) values ('004', 'sb俊鑫')";
        statement.executeUpdate(sql1);

        //PreparedStatement接口
        String sql2 = "insert into students (id, name) values ('005', 'fcy')";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.execute();

        //关闭连接
        connection.close();
    }
}
