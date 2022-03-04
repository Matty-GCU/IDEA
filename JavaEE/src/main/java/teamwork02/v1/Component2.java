package teamwork02.v1;

public class Component2 implements Components{
    double price=23.0;
    @Override
    public double buy() {
        System.out.println("用户购买了装备2");
        return -price;
    }

    @Override
    public double sell() {
        System.out.println("用户出售了装备2");
        return price;
    }
}
