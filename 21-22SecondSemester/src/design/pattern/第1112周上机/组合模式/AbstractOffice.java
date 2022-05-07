package design.pattern.第1112周上机.组合模式;

public abstract class AbstractOffice {
    protected String parentName;
    
    public AbstractOffice(String parentName) {
        this.parentName = parentName;
    }
    
    public abstract void addOffice(AbstractOffice office);
    
    public abstract void sendDocument();
    
}
