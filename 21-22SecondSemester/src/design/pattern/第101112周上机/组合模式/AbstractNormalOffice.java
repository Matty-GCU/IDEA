package design.pattern.第101112周上机.组合模式;


public abstract class AbstractNormalOffice extends AbstractOffice {
    
    public AbstractNormalOffice(String name) {
        super(name);
    }
    
    @Override
    public void addOffice(AbstractOffice office) {
        System.out.println("不支持该方法！");
    }
    
}
