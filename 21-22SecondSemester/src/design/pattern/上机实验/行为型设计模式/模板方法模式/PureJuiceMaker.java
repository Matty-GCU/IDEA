package design.pattern.上机实验.行为型设计模式.模板方法模式;

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
