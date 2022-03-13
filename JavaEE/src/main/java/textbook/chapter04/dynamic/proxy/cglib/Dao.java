package textbook.chapter04.dynamic.proxy.cglib;

/**
 * 注意本类不实现任何接口
 */
public class Dao {
    public void save() {
        System.out.println("保存");
    }

    public void modify() {
        System.out.println("修改");
    }

    public void delete() {
        System.out.println("删除");
    }
}
