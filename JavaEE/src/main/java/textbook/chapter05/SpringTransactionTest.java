package textbook.chapter05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextCh5.xml");
        TransactionAPIDao transactionAPIDao = (TransactionAPIDao) context.getBean("transactionAPIDao");
        System.out.println(transactionAPIDao.test());
        TransactionTemplateDao transactionTemplateDao = (TransactionTemplateDao) context.getBean("transactionTemplateDao");
        System.out.println(transactionTemplateDao.test());
    }
}
