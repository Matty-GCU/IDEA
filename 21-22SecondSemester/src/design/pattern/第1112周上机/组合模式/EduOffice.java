package design.pattern.第1112周上机.组合模式;

public class EduOffice extends Office {
    public EduOffice(String name) {
        super(name);
    }
    
    @Override
    public void sendDocument() {
        System.out.println(parentName + "教务办公室已收到公文！");
    }
}
