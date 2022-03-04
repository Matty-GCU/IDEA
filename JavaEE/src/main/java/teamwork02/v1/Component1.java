package teamwork02.v1;
public class Component1 implements Components{
    double price=17.0;
    @Override
    public double buy() {
        System.out.println("用户购买了装备1");
        return -price;
    }

    @Override
    public double sell() {
        System.out.println("用户出售了装备1");
        System.out.println(price);
        return price;
    }
}
