package design.pattern.上机实验.创建型设计模式.工厂方法模式.factory;

import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.EasyPVCGame;
import design.pattern.上机实验.创建型设计模式.工厂方法模式.game.Game;

public class EasyPVCGameFactory implements GameFactory {
    
    @Override
    public Game createGame() {
        return new EasyPVCGame();
    }
}
