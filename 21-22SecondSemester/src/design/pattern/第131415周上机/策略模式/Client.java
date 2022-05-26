package design.pattern.第131415周上机.策略模式;

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
