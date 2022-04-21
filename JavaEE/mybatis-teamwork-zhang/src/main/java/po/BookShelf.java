package po;

import java.util.List;

public class BookShelf {
	private Integer id;
	private String bname;
	private List<Book> bookList; //��������һ�Զ����
	
	@Override
	public String toString() {
		return "书架[编号："+id+",类别名："+bname+",书本列表："+bookList+"]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getbName() {
		return bname;
	}

	public void setbName(String bname) {
		this.bname = bname;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
}
