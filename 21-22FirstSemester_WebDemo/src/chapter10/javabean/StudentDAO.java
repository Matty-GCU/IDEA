package chapter10.javabean;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Matty's PC
 */
public class StudentDAO {
    public static ArrayList<StudentVO> queryAllStudents() throws ClassNotFoundException, SQLException {
        Connection conn;
        ArrayList<StudentVO> stus = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?useSSL=true", "root", "123456");
        String sql = "select * from students";
        Statement stat = conn.createStatement();
        ResultSet result = stat.executeQuery(sql);
        while(result.next()) {
            StudentVO stu = new StudentVO();
            stu.setName(result.getString("name"));
            stu.setId(result.getInt("id"));
            stus.add(stu);
        }
        result.close();
        stat.close();
        conn.close();
        return stus;
    }
}
