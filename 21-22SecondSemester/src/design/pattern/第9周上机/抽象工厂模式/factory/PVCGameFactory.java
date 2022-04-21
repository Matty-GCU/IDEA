package design.pattern.第9周上机.抽象工厂模式.factory;

import design.pattern.第9周上机.抽象工厂模式.game.EasyGame;
import design.pattern.第9周上机.抽象工厂模式.game.HardGame;
import design.pattern.第9周上机.抽象工厂模式.game.PVCEasyGame;
import design.pattern.第9周上机.抽象工厂模式.game.PVCHardGame;

public class PVCGameFactory implements GameFactory {
    
    @Override
    public EasyGame createEasyGame() {
        return new PVCEasyGame();
    }
    
    @Override
    public HardGame createHardGame() {
        return new PVCHardGame();
    }
}
