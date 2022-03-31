package p20;

public class ServiceP20Impl implements ServiceP20 {
    @Override
    public void insert() {
        System.out.println("增加一条记录！");
    }
    
    @Override
    public void delete() {
        System.out.println("删除一条记录！");
    }
    
    @Override
    public void update() {
        System.out.println("更新一条记录！");
    }
    
    @Override
    public void select() {
        System.out.println("查找记录！");
    }
}
