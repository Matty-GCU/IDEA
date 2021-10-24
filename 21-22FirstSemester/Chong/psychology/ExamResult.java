package psychology;

public class ExamResult extends StudentExam{
	String level[];
	String remark[];
	public ExamResult() {
		
	}
	public ExamResult(String[] level, String[] remark) {
		super();
		this.level = level;
		this.remark = remark;
	}
	public String[] getLevel() {
		return level;
	}
	public void setLevel(String[] level) {
		this.level = level;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
}
