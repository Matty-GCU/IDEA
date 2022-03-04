package teamwork02.v3;

public class Test {
    public static void main(String[] args) {
        //传统方法（手动new）
        Component sword = new Sword();
        Component shield = new Shield();
        Service northService = new ServiceImpl();
        Service southService = new ServiceImpl();
        southService.sell(sword);
        southService.buy(shield);
        southService.attack(sword);
        southService.defend(shield);
        for(int i = 0; i < 14; i++) {
            northService.sell(sword);
        }
        southService.sell(sword);

        //现代方法（手动new模拟依赖注入）
        Component anotherSword = new Sword();
        Component anotherShield = new Shield();
        ServiceImpl2 northService2 = new ServiceImpl2();
        ServiceImpl2 southService2 = new ServiceImpl2();
        northService2.setComponent(anotherSword);
        northService2.buy();

        southService2.buy();
    }
}
