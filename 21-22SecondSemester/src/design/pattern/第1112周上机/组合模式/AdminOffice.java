package design.pattern.第1112周上机.组合模式;

public class AdminOffice extends Office {
    public AdminOffice(String name) {
        super(name);
    }
    
    @Override
    public void sendDocument() {
        System.out.println(parentName + "行政办公室已收到公文！");
    }
}
