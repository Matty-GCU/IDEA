package textbook.chapter05.declaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestControllerCh0503 {
    @Autowired
    private TestServiceCh0503 testServiceCh0503;
    
    public void test() {
        testServiceCh0503.test();
    }
}
