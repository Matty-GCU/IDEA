package design.pattern.ch24.strategy.example1;

public class Context {
    Strategy strategy;
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void algorithm() {
        strategy.algorithm();
    }
}
