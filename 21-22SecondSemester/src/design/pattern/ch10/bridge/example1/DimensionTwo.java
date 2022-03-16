package design.pattern.ch10.bridge.example1;

public abstract class DimensionTwo {
    protected DimensionOne dimensionOne;
    
    public void setDimensionOne(DimensionOne dimensionOne) {
        this.dimensionOne = dimensionOne;
    }
    
    public abstract void operation();
}
