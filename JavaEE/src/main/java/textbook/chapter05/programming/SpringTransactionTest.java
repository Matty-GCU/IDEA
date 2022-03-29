package textbook.chapter05.programming;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContextCh5.xml");
        //5.2.1基于底层API（事务管理器）的编程式事务管理
        TransactionAPIDao transactionAPIDao = (TransactionAPIDao) context.getBean("transactionAPIDao");
        System.out.println(transactionAPIDao.test());
        //5.2.2基于TransactionTemplate（事务模板）的编程式事务管理
        TransactionTemplateDao transactionTemplateDao = (TransactionTemplateDao) context.getBean("transactionTemplateDao");
        System.out.println(transactionTemplateDao.test());
    }
}
