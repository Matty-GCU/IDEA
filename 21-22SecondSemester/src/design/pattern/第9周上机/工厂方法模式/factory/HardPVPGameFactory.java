package design.pattern.第9周上机.工厂方法模式.factory;

import design.pattern.第9周上机.工厂方法模式.game.Game;
import design.pattern.第9周上机.工厂方法模式.game.HardPVPGame;

public class HardPVPGameFactory implements GameFactory {
    @Override
    public Game createGame() {
        return new HardPVPGame();
    }
}
