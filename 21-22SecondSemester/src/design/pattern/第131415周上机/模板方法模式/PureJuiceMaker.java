package design.pattern.第131415周上机.模板方法模式;

public class PureJuiceMaker extends AbstractJuiceMaker {

	@Override
	protected boolean isPureJuice() {
		return true;
	}

	@Override
	protected void addFlavouring() {
		// 空实现
	}
}
