package design.pattern.ch05.abstractfactory;

public interface SkinFactory {
    Button createButton();
    TextField createTextField();
    ComboBox createComboBox();
}
