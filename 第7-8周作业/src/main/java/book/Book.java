package book;

public class Book {
    private String name;
    private int id;
    private double price;
    private String author;
    private int number;
    private int shelfid;
    public Book(){}
    public Book(String name,double price,String author,int number,int shelfid){
        this.name=name;
        this.price=price;
        this.author=author;
        this.number=number;
        this.shelfid=shelfid;
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
        return "名字:"+this.name+",ID:"+this.id+",价格:"+this.price+",作者:"+this.author+",数量"+this.number+",书架"+this.shelfid;
    }
}
