package design.pattern.上机实验.创建型设计模式.抽象工厂模式;

import design.pattern.上机实验.创建型设计模式.抽象工厂模式.factory.GameFactory;
import design.pattern.上机实验.创建型设计模式.抽象工厂模式.factory.PVCGameFactory;
import design.pattern.上机实验.创建型设计模式.抽象工厂模式.game.Game;

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
