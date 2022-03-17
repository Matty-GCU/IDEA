package textbook.chapter05.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJDBCTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextCh5.xml");
        TestDaoCh05 dao = (TestDaoCh05) context.getBean("testDaoImplCh05");
        String sql1 = "insert into users values (null, ?, ?)";
        Object[] params1 = {"小明", "男"};
        Object[] params2 = {"小明白", "男"};
        Object[] params3 = {"大聪明", "女"};
        Object[] params4 = {"小机灵", "女"};
        dao.update(sql1, params1);
        dao.update(sql1, params2);
        dao.update(sql1, params3);
        dao.update(sql1, params4);
        String sql2 = "select * from users";
        List<MyUser> myUserList =  dao.query(sql2, null);
        for (MyUser myUser : myUserList) {
            System.out.println(myUser);
        }
    }
}
