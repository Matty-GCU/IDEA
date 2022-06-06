package design.pattern.上机实验.结构型设计模式.装饰模式;

import design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood.AdditionalBeef;
import design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood.AdditionalEgg;
import design.pattern.上机实验.结构型设计模式.装饰模式.additionalfood.AdditionalPork;
import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Food;
import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Noodle;
import design.pattern.上机实验.结构型设计模式.装饰模式.stablefood.Vermicelli;

public class Counter {
    public static void main(String[] args) {
        //10
        Food noodle = new Noodle();
        //+5
        Food noodlePlusBeef = new AdditionalBeef(noodle);
        System.out.println(noodlePlusBeef.getPrice());
        
        //9
        Food vermicelli = new Vermicelli();
        //+3
        Food vermicelliPlusPork = new AdditionalPork(vermicelli);
        //+2
        Food vermicelliPlusPorkAndEgg = new AdditionalEgg(vermicelliPlusPork);
        System.out.println(vermicelliPlusPorkAndEgg.getPrice());
    }
}
