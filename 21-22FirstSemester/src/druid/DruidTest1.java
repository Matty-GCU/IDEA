package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DruidTest1 {
    public static void main(String[] args) {
        /**
         * 测试代码来自：
         * Druid基本使用教程 - 简书
         * https://www.jianshu.com/p/776f6df96b31
         */
        String sql = "select * from students where id = ?";
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //创建Properties对象，用于加载配置文件
            Properties pro = new Properties();
            //加载配置文件
            pro.load(DruidTest1.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取数据库连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            //获取数据库连接对象
            conn = ds.getConnection();
            //获取statement,使用prepareStatement，防止sql注入
            pstmt = conn.prepareStatement(sql);
            //注入sql参数（sql中？将被替换）
            pstmt.setInt(1,id);
            //执行sql，返回数据集
            ResultSet rs = pstmt.executeQuery();
            //数据处理
            while(rs.next()){
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id+" "+ name);
            };
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放stmt
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //conn归还连接池
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
