package design.pattern.上机实验.行为型设计模式.状态模式;

public class TestStatePattern {
    public static void main(String[] args) {
        Water water = new Water();
        water.heat(79);
        water.cool(3);
        water.heat(5);
        water.cool(3);
        water.cool(300);
    }
}
