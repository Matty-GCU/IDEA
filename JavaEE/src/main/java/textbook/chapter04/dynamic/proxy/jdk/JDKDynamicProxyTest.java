package textbook.chapter04.dynamic.proxy.jdk;

public class JDKDynamicProxyTest {
    public static void main(String[] args) {
        JDKInvocationHandler proxy = new JDKInvocationHandler();
        Dao dao = new DaoImpl();
        dao.save();
        dao.modify();
        dao.delete();
        System.out.println();

        dao = (Dao) proxy.createProxy(dao);
        System.out.println("===========");
        dao.save();
        System.out.println("===========");
        dao.modify();
        System.out.println("===========");
        dao.delete();
    }
}
