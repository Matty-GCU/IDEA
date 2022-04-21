package po;

import java.util.List;

public class Book {
    private String name;
    private int id;
    private double price;
    private String author;
    private int number;
    private int shelfid;
    private List<User> users; //与用户关联（多对多中第一个一对多）
    
    public Book(){}
    public Book(String name,double price,String author,int number,int shelfid){
        this.name=name;
        this.price=price;
        this.author=author;
        this.number=number;
        this.shelfid=shelfid;
    }

    public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getShelfid() {
        return shelfid;
    }

    public void setShelfid(int shelfid) {
        this.shelfid = shelfid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString(){
        return "书本信息[名称：:"+this.name+",ID编号："+this.id+",价格："+this.price+",作者："+this.author+",数量："+this.number;
    }
}
