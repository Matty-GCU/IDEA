package design.pattern.ch14.flyweight.example2;

public abstract class IgoChessman {
    
    public abstract String getColor();
    
    public void display(Coordinates coordinates) {
        System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coordinates.toString());
    }
}
