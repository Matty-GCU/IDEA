package design.pattern.ch09.adapter;

import design.pattern.XMLUtil2;

public class AdapterPatternTest {
    public static void main(String[] args) {
        CarController carController = (CarController) XMLUtil2.getBean("adapter");
        carController.move();
        carController.phonate();
        carController.twinkle();
    }
}
