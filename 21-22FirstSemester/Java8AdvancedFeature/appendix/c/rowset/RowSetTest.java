package appendix.c.rowset;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.RowSet;
import java.sql.*;

public class RowSetTest {

    public static RowSet query(Connection conn, String sql) throws SQLException {
        //使用sun默认的RowSet实现
        CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        //填充离线集
        cachedRowSet.populate(resultSet);
        //提前关闭结果集
        resultSet.close();
        cachedRowSet.close();     //这个不能提前关闭。看注释就懂了
        stmt.close();
        return cachedRowSet;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/test";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        RowSet rowSet = query(conn, "SELECT * FROM students");
        //关闭连接也没关系了
        conn.close();
        //和RowSet一样使用
        while(rowSet.next()) {
            System.out.print("id: " + rowSet.getString(1));
            System.out.println(", name: " + rowSet.getString(2));
        }
    }

}
