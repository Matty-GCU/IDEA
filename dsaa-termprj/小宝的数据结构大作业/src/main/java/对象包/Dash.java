package 对象包;

public class Dash {
//    菜品的属性有菜名、口味、库存、价格、评价
    private String name,flavor;
    private int repertory;
    private double price,exval;

    public Dash(){

    }

    public Dash(String name, double price, int repertory, String flavor, double exval){
        this.name = name;
        this.price = price;
        this.repertory = repertory;
        this.flavor = flavor;
        this.exval = exval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExval() {
        return exval;
    }

    public void setExval(double exval) {
        this.exval = exval;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  name+"   "+price+"   "+repertory+"   "+flavor+"   "+exval+"\n";
    }
}
