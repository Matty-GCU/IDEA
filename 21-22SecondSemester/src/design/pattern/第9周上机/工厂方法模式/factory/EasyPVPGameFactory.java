package design.pattern.第9周上机.工厂方法模式.factory;

import design.pattern.第9周上机.工厂方法模式.game.EasyPVPGame;
import design.pattern.第9周上机.工厂方法模式.game.Game;

public class EasyPVPGameFactory implements GameFactory {
    @Override
    public Game createGame() {
        return new EasyPVPGame();
    }
}
