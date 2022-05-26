package design.pattern.第131415周上机.模板方法模式;

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
