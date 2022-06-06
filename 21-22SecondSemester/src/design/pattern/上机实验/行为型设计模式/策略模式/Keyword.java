package design.pattern.上机实验.行为型设计模式.策略模式;

public class Keyword {
	private FindAlgorithm findAlgorithm;
	
	public void setFindAlgorithm(FindAlgorithm findAlgorithm) {
		this.findAlgorithm = findAlgorithm;
	}
	
	public void findWord() {
		findAlgorithm.find();
	}
}
