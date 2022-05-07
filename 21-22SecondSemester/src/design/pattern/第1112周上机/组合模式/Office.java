package design.pattern.第1112周上机.组合模式;


public abstract class Office extends AbstractOffice {
    
    public Office(String name) {
        super(name);
    }
    
    @Override
    public void addOffice(AbstractOffice office) {
        System.out.println("不支持该方法！");
    }
    
}
