package psychology;

public class Student extends ExamMachine{
	String name;
	String major;
	long ID;
	String grade;
	int constant = 0;
	public Student() {
		
	}
	public Student(String name,String major,long ID,String grade) {
		this.setName(name);
		this.setMajor(major);
		this.setID(ID);
		this.setGrade(grade);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getConstant() {
		return constant;
	}
	public void setConstant(int constant) {
		this.constant = constant;
	}
	public String toString() {		
		return this.getName()+" "+this.getMajor()+" "+this.getID()+" "+this.getGrade();
	}
	

}
