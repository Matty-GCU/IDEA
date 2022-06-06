package design.pattern.上机实验.创建型设计模式.抽象工厂模式.factory;

import design.pattern.上机实验.创建型设计模式.抽象工厂模式.game.EasyGame;
import design.pattern.上机实验.创建型设计模式.抽象工厂模式.game.HardGame;

public interface GameFactory {
    public EasyGame createEasyGame();
    public HardGame createHardGame();
}
