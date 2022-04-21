package design.pattern.第9周上机.工厂模式;

import design.pattern.第9周上机.工厂模式.factory.*;
import design.pattern.第9周上机.工厂模式.game.Game;

public class Client1Week9 {
    public static void main(String[] args) {
        GameFactory gameFactory = new EasyPVCGameFactory();
//        GameFactory gameFactory = new EasyPVPGameFactory();
//        GameFactory gameFactory = new HardPVCGameFactory();
//        GameFactory gameFactory = new HardPVPGameFactory();
        Game game = gameFactory.createGame();
        game.play();
    }
}
