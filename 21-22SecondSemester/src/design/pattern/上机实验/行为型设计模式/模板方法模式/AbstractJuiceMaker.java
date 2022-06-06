package design.pattern.上机实验.行为型设计模式.模板方法模式;

public abstract class AbstractJuiceMaker {
	
	/**
	 * 模板方法
	 */
	public void makeJuice() {
		cutFruit();
		addToJuicer();
		if(! isPureJuice()) {
			addFlavouring();
		}
		start();
	}
	
	/**
	 * 基本方法之具体方法
	 */
	protected void cutFruit() {
		System.out.println("水果切片");
	}
	
	/**
	 * 基本方法之具体方法
	 */
	protected void addToJuicer() {
		System.out.println("加入榨汁机");
	}
	
	/**
	 * 基本方法之钩子方法
	 */
	protected abstract boolean isPureJuice();
	
	/**
	 * 基本方法之抽象方法
	 */
	// 加调味料
	protected abstract void addFlavouring();
	
	/**
	 * 基本方法之具体方法
	 */
	protected void start() {
		System.out.println("启动榨汁机");
	}

}
