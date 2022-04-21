package po;

import java.util.List;

public class User {
	private Integer uid;
	private String uname;
	private BorrowerCard borrowerCard; //与借书卡关联(一对一)
	private List<Book> books; //与书本关联（多对多中的第二个一对多）
	
	@Override
	public String toString() {
		return "用户信息[编号："+uid+",姓名："+uname+",借阅书籍："+books+"]";
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
