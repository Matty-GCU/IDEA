package 对象包;
import java.util.HashMap;
public class Store {
//    店铺的属性有：店名、评价、菜品(集合)
    private String name;
    private double exval;
    private HashMap<Integer,Dash> dashes;

    public Store(){
        this.name = null;
        this.exval = 0;
        this.dashes = null;
    }
    public Store(String name, double exval){
        this.name = name;
        this.exval = exval;
    }
    public Store(String name, double exval, HashMap<Integer,Dash> dashes){
        this.name = name;
        this.exval = exval;
        this.dashes = dashes;
    }

//    只有店铺才可以操作菜品，对菜品进行增删改，所以店铺对象要有对应方法，还要有随机方法

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

    public HashMap<Integer, Dash> getDashes() {
        return dashes;
    }

    public void setDashes(HashMap<Integer, Dash> dashes) {
        this.dashes = dashes;
    }

    public void add(int n,Dash dash){
        if(n<=0){
            n=this.dashes.size()+1;
        }
        if(dash == null){
            System.out.println("添加的菜为空");
        }
        dashes.put(n,dash);
    }

    public Dash random(){
        return dashes.get((int)(Math.random()*dashes.size())+1);
    }

    @Override
    public String toString() {
        return  name+"   "+exval+"   "+dashes+"\n";
    }
}