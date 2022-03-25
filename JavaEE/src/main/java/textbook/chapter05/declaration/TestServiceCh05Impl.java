package textbook.chapter05.declaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import textbook.chapter05.jdbc.TestDaoCh05;

@Service
public class TestServiceCh05Impl implements TestServiceCh05 {
    
    @Autowired
    private TestDaoCh05 testDaoCh05;
    
    @Override
    public void test() {
        String sql = "insert into users value (?, ?, ?)";
        Object[] params = {2, "俊鑫", "雄"};
        testDaoCh05.update(sql, params);
//        testDaoCh05.update(sql, params);
    }
}
