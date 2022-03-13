package textbook.chapter03.assemble.annotaion2;

import org.springframework.stereotype.Repository;

@Repository("testDaoImpl")      //相当于@Repository
public class TestDaoImpl implements TestDao {
    @Override
    public void saveData() {
        System.out.println("DaoImpl saves data.");
    }
}
