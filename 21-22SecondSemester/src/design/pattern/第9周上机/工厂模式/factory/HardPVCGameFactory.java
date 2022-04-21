package design.pattern.第9周上机.工厂模式.factory;

import design.pattern.第9周上机.工厂模式.game.Game;
import design.pattern.第9周上机.工厂模式.game.HardPVCGame;

public class HardPVCGameFactory implements GameFactory {
    @Override
    public Game createGame() {
        return new HardPVCGame();
    }
}
