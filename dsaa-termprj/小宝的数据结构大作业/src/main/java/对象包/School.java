package 对象包;
import java.util.*;
public class School {
    HashMap<Integer,Canteen> canteens;

    public School(){

    }

    public School(HashMap<Integer,Canteen> canteens){
        this.canteens = canteens;
    }

    public HashMap<Integer, Canteen> getCanteens() {
        return canteens;
    }

    public void setCanteens(HashMap<Integer, Canteen> canteens) {
        this.canteens = canteens;
    }

    public void add(int n, Canteen canteen){
        if(n<=0){
            n = this.canteens.size()+1;
        }
        if(canteen == null){
            System.out.println("添加的饭堂为空");
        }
        canteens.put(n, canteen);
    }

    public Canteen random(){
        return canteens.get((int)(Math.random()*canteens.size())+1);
    }

    @Override
    public String toString() {
        return canteens+"\n";
    }
}
