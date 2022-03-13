package textbook.chapter03.assemble.annotaion2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("testController")      //相当于@Controller
public class TestController {

//    @Autowired
//    @Resource
//    @Resource(type = TestServiceImpl.class)
    @Resource(name = "testServiceImpl")
    private TestService testService;

    public void saveData() {
        testService.saveData();
        System.out.println("TestService saves data.");
    }
}
