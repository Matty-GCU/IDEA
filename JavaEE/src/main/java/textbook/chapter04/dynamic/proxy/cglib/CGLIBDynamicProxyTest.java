package textbook.chapter04.dynamic.proxy.cglib;

public class CGLIBDynamicProxyTest {
    public static void main(String[] args) {
        CglibInterceptor cglibInterceptor = new CglibInterceptor();
        Dao dao = new Dao();
        Dao enhancedDao = (Dao) cglibInterceptor.createProxy(dao);
        System.out.println();
        enhancedDao.save();
        System.out.println();
    }
}
