package design.pattern.ch05.abstractFactory;

public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }
    
    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
    
    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
