package design.pattern.ch14.flyweight.example2;

import java.util.Hashtable;

public class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable hashtable;
    
    private IgoChessmanFactory() {
        hashtable = new Hashtable();
        IgoChessman black = new BlackIgoChessman();
        hashtable.put("black", black);
        IgoChessman white = new WhiteIgoChessman();
        hashtable.put("white", white);
    }
    
    public static IgoChessmanFactory getInstance() {
        return instance;
    }
    
    public static IgoChessman getIgoChessman(String color) {
        return (IgoChessman) hashtable.get(color);
    }
}
