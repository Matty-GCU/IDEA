package design.pattern.第9周上机.抽象工厂模式.factory;

import design.pattern.第9周上机.抽象工厂模式.game.EasyGame;
import design.pattern.第9周上机.抽象工厂模式.game.HardGame;

public interface GameFactory {
    public EasyGame createEasyGame();
    public HardGame createHardGame();
}
