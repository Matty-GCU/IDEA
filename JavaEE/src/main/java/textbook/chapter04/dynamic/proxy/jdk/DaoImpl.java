package textbook.chapter04.dynamic.proxy.jdk;

import org.springframework.stereotype.Repository;

/**
 * 这里的两个注解，仅用于测试基于注解开发AspectJ，其他时候不用。
 */
@Repository("testDao3")
public class DaoImpl implements Dao {
    @Override
    public void save() {
        System.out.println("保存");
    }

    @Override
    public void modify() {
        System.out.println("修改");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }
}
