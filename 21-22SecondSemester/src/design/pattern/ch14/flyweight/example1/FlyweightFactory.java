package design.pattern.ch14.flyweight.example1;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    
    /**
     * 实现享元池
     */
    private Map map = new HashMap();
    
    public Flyweight getFlyweight(String key) {
        if(map.containsKey(key)) {
            return (Flyweight) map.get(key);
        } else {
            Flyweight flyweight = new ConcreteFlyweight("内部状态");
            map.put(key, flyweight);
            return flyweight;
        }
    }
}
