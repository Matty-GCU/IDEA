package design.pattern.上机实验.行为型设计模式.策略模式;

public class Client {

	public static void main(String[] args) {
//		FindAlgorithm findAlgorithm = new FindAlgorithm1();
//		FindAlgorithm findAlgorithm = new FindAlgorithm2();
		FindAlgorithm findAlgorithm = new FindAlgorithm3();
//		FindAlgorithm findAlgorithm = new FindAlgorithm4();
		
		Keyword keyword = new Keyword();
		keyword.setFindAlgorithm(findAlgorithm);
		keyword.findWord();
	}

}
