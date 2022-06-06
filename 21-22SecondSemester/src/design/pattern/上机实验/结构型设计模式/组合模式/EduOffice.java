package design.pattern.上机实验.结构型设计模式.组合模式;

public class EduOffice extends AbstractNormalOffice {
    public EduOffice(String name) {
        super(name);
    }
    
    @Override
    public void sendDocument() {
        System.out.println(parentName + "教务办公室已收到公文！");
    }
}
