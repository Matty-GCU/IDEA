package design.pattern.第9周上机.抽象工厂模式.factory;

import design.pattern.第9周上机.抽象工厂模式.game.EasyGame;
import design.pattern.第9周上机.抽象工厂模式.game.HardGame;
import design.pattern.第9周上机.抽象工厂模式.game.PVPEasyGame;
import design.pattern.第9周上机.抽象工厂模式.game.PVPHardGame;

public class PVPGameFactory implements GameFactory {
    @Override
    public EasyGame createEasyGame() {
        return new PVPEasyGame();
    }
    
    @Override
    public HardGame createHardGame() {
        return new PVPHardGame();
    }
    
}
