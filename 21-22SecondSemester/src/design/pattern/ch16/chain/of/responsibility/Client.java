package design.pattern.ch16.chain.of.responsibility;

public class Client {
    public static void main(String[] args) {
        //创建职责链
        AbstractApprover directorA = new Director("directorA");
        VicePresident vicePresidentB = new VicePresident("vicePresidentB");
        President presidentC = new President("presidentC");
        Congress congress = new Congress("congress");
        
        directorA.setSuccessor(vicePresidentB);
        vicePresidentB.setSuccessor(presidentC);
        presidentC.setSuccessor(congress);
        
        //创建采购单
        PurchaseReuqest reuqest1 = new PurchaseReuqest(1500, 1, "购买今天的食材");
        PurchaseReuqest reuqest2 = new PurchaseReuqest(12000, 2, "更换厨具设备");
        PurchaseReuqest reuqest3 = new PurchaseReuqest(200000, 3, "重新装修食堂");
        PurchaseReuqest reuqest4 = new PurchaseReuqest(1000000, 4, "新建食堂大楼");
    
        directorA.handleRequest(reuqest1);
        directorA.handleRequest(reuqest2);
        directorA.handleRequest(reuqest3);
        directorA.handleRequest(reuqest4);
    }
}
