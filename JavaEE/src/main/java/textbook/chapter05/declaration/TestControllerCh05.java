package textbook.chapter05.declaration;

import org.springframework.beans.factory.annotation.Autowired;

public class TestControllerCh05 {
    
    @Autowired
    private TestServiceCh05 testServiceCh05;
    
    public void test() {
        testServiceCh05.test();
    }
}
