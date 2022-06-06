package design.pattern.上机实验.创建型设计模式.工厂方法模式.factory;

import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.EasyPVPGame;
import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.Game;

public class EasyPVPGameFactory implements GameFactory {
    @Override
    public Game createGame() {
        return new EasyPVPGame();
    }
}
