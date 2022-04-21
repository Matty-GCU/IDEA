package pojo;

public class SelectBookShelfById {
    private String name;
    private Integer id;
    private Double price;
    private String author;
    private Integer shelfid;
    private String bname;
    @Override
    public String toString() {
    	return "书架[书架号："+shelfid+",书架类别名："+bname+",包含[书本名："+name+",编号："+id+",价格："+price+",作者："+author+"]";
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getShelfid() {
		return shelfid;
	}
	public void setShelfid(Integer shelfid) {
		this.shelfid = shelfid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
    
}
