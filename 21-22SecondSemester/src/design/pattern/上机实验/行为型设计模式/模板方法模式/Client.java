package design.pattern.上机实验.行为型设计模式.模板方法模式;

public class Client {

	public static void main(String[] args) {
//		AbstractJuiceMaker juiceMaker = new PureJuiceMaker();
//		AbstractJuiceMaker juiceMaker = new HoneyJuiceMaker();
		AbstractJuiceMaker juiceMaker = new SodaJuiceMaker();
		juiceMaker.makeJuice();
	}

}
