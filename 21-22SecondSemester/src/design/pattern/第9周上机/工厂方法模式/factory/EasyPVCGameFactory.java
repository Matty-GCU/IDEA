package design.pattern.第9周上机.工厂方法模式.factory;

import design.pattern.第9周上机.工厂方法模式.game.EasyPVCGame;
import design.pattern.第9周上机.工厂方法模式.game.Game;

public class EasyPVCGameFactory implements GameFactory {
    
    @Override
    public Game createGame() {
        return new EasyPVCGame();
    }
}
