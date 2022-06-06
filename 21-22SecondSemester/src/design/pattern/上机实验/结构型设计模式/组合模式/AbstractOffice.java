package design.pattern.上机实验.结构型设计模式.组合模式;

public abstract class AbstractOffice {
    protected String parentName;
    
    public AbstractOffice(String parentName) {
        this.parentName = parentName;
    }
    
    public abstract void addOffice(AbstractOffice office);
    
    public abstract void sendDocument();
    
}
