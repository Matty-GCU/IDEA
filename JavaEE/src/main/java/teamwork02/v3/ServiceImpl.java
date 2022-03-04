package teamwork02.v3;

public class ServiceImpl implements Service {

    @Override
    public void sell(Component component) {
        component.sell();
    }

    @Override
    public void buy(Component component) {
        component.buy();
    }

    @Override
    public void attack(Component component) {
        component.attack();
    }

    @Override
    public void defend(Component component) {
        component.defend();
    }
}