package textbook.chapter03.assemble.annotaion2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testServiceImpl")     //相当于@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public void saveData() {
        testDao.saveData();
        System.out.println("TestServiceImpl saves data.");
    }
}
