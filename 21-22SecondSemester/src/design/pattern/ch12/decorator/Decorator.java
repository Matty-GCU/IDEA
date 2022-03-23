package design.pattern.ch12.decorator;

public class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
