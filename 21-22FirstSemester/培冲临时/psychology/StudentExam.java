package psychology;

public class StudentExam extends Question{
	int scoreA,scoreB,scoreC,scoreD;
	public StudentExam() {
		
	}
	public StudentExam(String title,String A,String B,String C,String D,int scoreA,int scoreB,int scoreC,int scoreD) {
		super.setTitle(title);
		super.setA(A);
		super.setB(B);
		super.setC(C);
		super.setD(D);
		this.setScoreA(scoreA);
		this.setScoreB(scoreB);
		this.setScoreC(scoreC);
		this.setScoreD(scoreD);
	}
	public int getScoreA() {
		return scoreA;
	}
	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}
	public int getScoreB() {
		return scoreB;
	}
	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}
	public int getScoreC() {
		return scoreC;
	}
	public void setScoreC(int scoreC) {
		this.scoreC = scoreC;
	}
	public int getScoreD() {
		return scoreD;
	}
	public void setScoreD(int scoreD) {
		this.scoreD = scoreD;
	}
	public String toString() {
		return getTitle()+"\n"+getA()+"\n"+getScoreA()+"\n"+getB()+"\n"+getScoreB()+"\n"+getC()+"\n"+getScoreC()+"\n"+getD()+"\n"+getScoreD()+"\n";
		//return "\n"+getTitle()+"\n"+"Person."+getA()+"("+getScoreA()+"分）"+"\n"+"B."+getB()+"("+getScoreB()+"分）"+"\n"+"C."+getC()+"("+getScoreC()+"分）"+"\n"+"D."+getD()+"("+getScoreD()+"分）";
	}
	public String link() {
		return "\n"+getTitle()+"\n"+"Person."+getA()+"("+getScoreA()+"分）"+"\n"+"B."+getB()+"("+getScoreB()+"分）"+"\n"+"C."+getC()+"("+getScoreC()+"分）"+"\n"+"D."+getD()+"("+getScoreD()+"分）";
	}
}
