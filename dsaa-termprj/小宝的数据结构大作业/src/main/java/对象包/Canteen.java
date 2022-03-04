package 对象包;
import java.util.*;
public class Canteen {
    private String name;
    private double exval;
    private HashMap<Integer,Store> stores;

    public Canteen(){

    }

    public Canteen(String name,double exval){
        this.name = name;
        this.exval = exval;
    }

    public Canteen(String name, double exval, HashMap<Integer, Store> stores){
        this.name = name;
        this.exval = exval;
        this.stores = stores;
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

    public HashMap<Integer, Store> getStores() {
        return stores;
    }

    public void setStores(HashMap<Integer, Store> stores) {
        this.stores = stores;
    }

    public void add(int n, Store store){
        if(n<=0){
            n = this.stores.size()+1;
        }
        if(store == null){
            System.out.println("添加的店铺为空");
        }
        stores.put(n, store);
    }

    public Store random(){
        return stores.get((int)(Math.random()*stores.size())+1);
    }

    @Override
    public String toString() {
        return  name+"   "+exval+"   "+stores+"\n";
    }
}
