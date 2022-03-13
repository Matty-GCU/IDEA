package design.pattern.ch05.abstractFactory;

public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}
