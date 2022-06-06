package design.pattern.上机实验.结构型设计模式.组合模式;


public abstract class AbstractNormalOffice extends AbstractOffice {
    
    public AbstractNormalOffice(String name) {
        super(name);
    }
    
    @Override
    public void addOffice(AbstractOffice office) {
        System.out.println("不支持该方法！");
    }
    
}
