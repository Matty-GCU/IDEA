package design.pattern.ch05.abstractFactory;

import design.pattern.ch04.factory.XMLUtil;

public class Test {
    public static void main(String[] args) {
        SkinFactory skinFactory
            = (SpringSkinFactory) XMLUtil.getObjectFromXMLByTagName("src/design/pattern/ch05/abstractFactory/config.xml", "skinFactory");
        Button button = skinFactory.createButton();
        TextField textField = skinFactory.createTextField();
        ComboBox comboBox = skinFactory.createComboBox();
        button.display();
        textField.display();
        comboBox.display();
    }
}
