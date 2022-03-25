package textbook.chapter05.declaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceCh0503Impl implements TestServiceCh0503 {
    
    @Autowired
    private TestDaoCh0503 testDaoCh0503;
    
    @Override
    public void test() {
        testDaoCh0503.update("delete from users", null);
        boolean ok = false;
        try {
            testDaoCh0503.update("insert into users value (?, ?, ?)", new Object[]{1, "小吴", "男的"});
            ok = true;
            System.out.println("（没有报错）第一条记录插入成功！");
            testDaoCh0503.update("insert into users value (?, ?, ?)", new Object[]{1, "小吴", "男的"});
            System.out.println("（没有报错）第二条记录同样插入成功！");
        } catch (Exception e) {
            if (ok) {
                System.out.println("（报错了）第二条记录插入失败！");
            } else {
                System.out.println("（报错了）第一条记录插入失败！");
            }
            System.out.println("查看users，发现第一条记录也没有被插入，说明Spring帮我们完成了事务回滚！\n");
            //默认情况下，Spring只在发生未被捕获的RuntimeException时才回滚事务
            throw new RuntimeException();
        }
    }
}
