package design.pattern.上机实验.结构型设计模式.组合模式;

public class AdminOffice extends AbstractNormalOffice {
    public AdminOffice(String name) {
        super(name);
    }
    
    @Override
    public void sendDocument() {
        System.out.println(parentName + "行政办公室已收到公文！");
    }
}
