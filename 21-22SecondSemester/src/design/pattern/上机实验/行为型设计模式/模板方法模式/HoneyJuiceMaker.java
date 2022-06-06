package design.pattern.上机实验.行为型设计模式.模板方法模式;

public class HoneyJuiceMaker extends AbstractJuiceMaker {
	@Override
	protected boolean isPureJuice() {
		return false;
	}

	@Override
	protected void addFlavouring() {
		System.out.println("加入蜂蜜");
	}
}
