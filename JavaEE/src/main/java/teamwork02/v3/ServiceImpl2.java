package teamwork02.v3;

public class ServiceImpl2 implements Service2 {

    static Component component;

    public void setComponent(Component component) {
        ServiceImpl2.component = component;
    }

    @Override
    public void sell() {
        component.sell();
    }

    @Override
    public void buy() {
        component.buy();
    }

    @Override
    public void attack() {
        component.attack();
    }

    @Override
    public void defend() {
        component.defend();
    }
}
