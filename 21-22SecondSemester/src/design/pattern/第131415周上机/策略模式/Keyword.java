package design.pattern.第131415周上机.策略模式;

public class Keyword {
	private FindAlgorithm findAlgorithm;
	
	public void setFindAlgorithm(FindAlgorithm findAlgorithm) {
		this.findAlgorithm = findAlgorithm;
	}
	
	public void findWord() {
		findAlgorithm.find();
	}
}
