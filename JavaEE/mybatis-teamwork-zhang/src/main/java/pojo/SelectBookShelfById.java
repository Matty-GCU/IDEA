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
    	return "���[��ܺţ�"+shelfid+",����������"+bname+",����[�鱾����"+name+",��ţ�"+id+",�۸�"+price+",���ߣ�"+author+"]";
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
