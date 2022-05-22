package design.pattern.ch14.flyweight.example2;

public class FlyweightPatternTest {
    public static void main(String[] args) {
        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();
        IgoChessman chessman1 = IgoChessmanFactory.getIgoChessman("black");
        IgoChessman chessman2 = IgoChessmanFactory.getIgoChessman("black");
        IgoChessman chessman3 = IgoChessmanFactory.getIgoChessman("black");
        IgoChessman chessman4 = IgoChessmanFactory.getIgoChessman("white");
        IgoChessman chessman5 = IgoChessmanFactory.getIgoChessman("white");
        System.out.println(chessman1);
        System.out.println(chessman2);
        System.out.println(chessman3);
        System.out.println(chessman4);
        System.out.println(chessman5);
        chessman1.display(new Coordinates(1, 6));
        chessman2.display(new Coordinates(4, -1));
        chessman3.display(new Coordinates(10, 66));
        chessman4.display(new Coordinates(42, -5));
        chessman5.display(new Coordinates(461, 98));
    }
}
interface A {
    public static void nn() {}
}