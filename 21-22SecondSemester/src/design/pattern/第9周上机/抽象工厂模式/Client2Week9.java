package design.pattern.第9周上机.抽象工厂模式;

import design.pattern.第9周上机.抽象工厂模式.factory.GameFactory;
import design.pattern.第9周上机.抽象工厂模式.factory.PVCGameFactory;
import design.pattern.第9周上机.抽象工厂模式.factory.PVPGameFactory;
import design.pattern.第9周上机.抽象工厂模式.game.Game;

public class Client2Week9 {
    public static void main(String[] args) {
        GameFactory gameFactory = new PVCGameFactory();
//        GameFactory gameFactory = new PVPGameFactory();
        Game game1 = gameFactory.createEasyGame();
        game1.play();
        Game game2 = gameFactory.createHardGame();
        game2.play();
    }
}
