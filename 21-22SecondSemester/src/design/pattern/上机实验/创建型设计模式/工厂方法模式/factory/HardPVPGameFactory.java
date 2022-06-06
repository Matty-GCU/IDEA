package design.pattern.上机实验.创建型设计模式.工厂方法模式.factory;

import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.Game;
import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.HardPVPGame;

public class HardPVPGameFactory implements GameFactory {
    @Override
    public Game createGame() {
        return new HardPVPGame();
    }
}
