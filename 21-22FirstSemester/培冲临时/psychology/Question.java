package psychology;

public class Question {
	private String title;//题干
    private String A,B,C,D;//选项
    public Question() {
    	
    }
    public Question(String title,String A,String B,String C,String D){
        this.setTitle(title);
        this.setA(A);
        this.setB(B);
        this.setC(C);
        this.setD(D);
    }
	public String getA() {
		return A;
	}
	public void setA(String A) {
		this.A = A;
	}
	public String getB() {
		return B;
	}
	public void setB(String B) {
		this.B = B;
	}
	public String getC() {
		return C;
	}
	public void setC(String C) {
		this.C = C;
	}
	public String getD() {
		return D;
	}
	public void setD(String D) {
		this.D = D;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
        return this.title;
    }
    
    //要重写equals方法以及hashCode方法，才能在set集合中保证题目不重复
    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj instanceof Question){
            Question anotherQuestion=(Question)obj;
            //比较题干是否相同
            if(this.getTitle().equals(anotherQuestion.getTitle()))
                return false;
        }
        return true;
    }
    public int hashCode() {
        return this.getTitle().hashCode();
    }
    public String toString() {
    	return title+"\n"+A+"\n"+B+"\n"+C+"\n"+D+"\n";
    }
    
}
