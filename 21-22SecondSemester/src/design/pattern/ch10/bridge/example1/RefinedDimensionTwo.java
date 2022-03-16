package design.pattern.ch10.bridge.example1;

public class RefinedDimensionTwo extends DimensionTwo {
    @Override
    public void operation() {
        //业务代码
        dimensionOne.operation();   //调用另一维度的方法
        //业务代码
    }
}
