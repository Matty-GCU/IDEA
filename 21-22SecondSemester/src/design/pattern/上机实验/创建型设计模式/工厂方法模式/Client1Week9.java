package design.pattern.上机实验.创建型设计模式.工厂方法模式;

import design.pattern.上机实验.创建型设计模式.工厂方法模式.factory.*;
import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.Game;

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
