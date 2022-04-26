package design.pattern.ch17.command.example2;

import design.pattern.XMLUtil2;

public class Client {
    public static void main(String[] args) {
        FunctionButton button = new FunctionButton();
        button.setCommand((Command) XMLUtil2.getBean("command"));
        button.click();
    }
}
