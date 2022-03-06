package teamwork02.v3;

public class Test {
    public static void main(String[] args) {
        //传统方法（手动new）
        Component sword = new Sword();
        Component shield = new Shield();
        Service northService = new ServiceImpl();
        Service southService = new ServiceImpl();
        southService.sell(shield);
        southService.buy(shield);
        southService.attack(shield);
        southService.defend(shield);
        //sword的初始数量是15，最多能卖15次
        for(int i = 0; i < 15; i++) {
            northService.sell(sword);
        }
        //已经没有库存了
        southService.sell(sword);

        System.out.println();
        System.out.println();

        //现代方法（手动new模拟依赖注入）
        Component anotherSword = new Sword();
        Component anotherShield = new Shield();
        ServiceImpl2 northService2 = new ServiceImpl2();
        ServiceImpl2 southService2 = new ServiceImpl2();
        northService2.setComponent(anotherSword);
        southService2.setComponent(anotherSword);
        northService2.buy();
        southService2.buy();
        for(int i = 0; i < 15; i++) {
            northService2.sell();
        }
        southService2.sell();

        //现代方法（利用Spring的Ioc容器实现依赖注入）
        /**
         * 俊鑫的思路是写两个服务类，代表北区和南区，
         * 两个类（基本上是一样的，只不过改了个类名）里都有两个属性，一个是剑，一个是盾，然后类里有买剑、卖剑方法（都是无参的）。
         * 然后用Ioc容器给这两个服务区类的对象传入同一个剑的对象和同一个盾的对象。
         * 【我不想写是因为，这样子的代码的复用性是极低的，要增加一个装备，就得给两个类都增加1属性+2方法（还只考虑购买和出售方法）】；
         * 不过，这不重要，老师布置这个作业的目的应该只是让我们体会Spring的依赖反转的实现，
         * 我也确实学到了：配置文件里同一个id的bean，无论拿出来(getBean())多少次，Ioc容器都会给我同一个引用，本质上是不会重新new的。
         * 后注：其实这是因为Bean的作用域默认为singleton
         */
    }
}
