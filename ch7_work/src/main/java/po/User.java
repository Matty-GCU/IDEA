package po;

import java.util.List;

public class User {
	private Integer uid;
	private String uname;
	private BorrowerCard borrowerCard; //����鿨����(һ��һ)
	private List<Book> books; //���鱾��������Զ��еĵڶ���һ�Զࣩ
	
	@Override
	public String toString() {
		return "�û���Ϣ[��ţ�"+uid+",������"+uname+",�����鼮��"+books+"]";
	}
	public Integer getuId() {
		return uid;
	}
	public void setuId(Integer uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uname;
	}
	public void setuName(String uname) {
		this.uname = uname;
	}
	public BorrowerCard getBorrowerCard() {
		return borrowerCard;
	}
	public void setBorrowerCard(BorrowerCard borrowerCard) {
		this.borrowerCard = borrowerCard;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
