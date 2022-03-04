package 功能包;
import 对象包.*;
import 数据库包.*;

import java.sql.ResultSet;
import java.util.HashMap;

public class Function {
    Database database;
    public School school = null;
    HashMap<Integer,String> someDash;

//    创建该类的对象实例时，会从数据库中读取数据，生成一个school对象
    public Function(){
        database = new Database();
        HashMap<Integer,Canteen> canteens = new HashMap();
        HashMap<Integer,Store> stores = new HashMap<>();
        HashMap<Integer,Dash> dashes = new HashMap<>();

        Canteen canteen = null;
        Store store = null;

        school = new School();
        school.setCanteens(canteens);
        String sql = "select * from canteen,stores,dashes where canteen.Cno = stores.Cno and stores.Sno = dashes.Sno";
        ResultSet rs;
        try{
            rs = database.searchBySQL(sql);
            int a = 0;
            int b = 1;
            int c = 1;
            int m = 1;
            int n = 1;
            while(rs.next()) {
                int i = rs.getInt("Sno");
                int j = rs.getInt("Cno");

                if(rs.isFirst()){
                    store = new Store(rs.getString("Sname"),rs.getDouble("Sexval"));
                    canteen = new Canteen(rs.getString("Cname"),rs.getDouble("Cexval"));
                }

                if(m != i){
                    a=0;
                    b++;
                    dashes = new HashMap<>();
                    store = new Store(rs.getString("Sname"),rs.getDouble("Sexval"));
                }
                a++;
                dashes.put(a,new Dash(rs.getString("Dname"),
                        rs.getDouble("Price"), rs.getInt("Repertory"),
                        rs.getString("Flavor"), rs.getDouble("Dexval")));
                store.setDashes(dashes);
                if(n != j){
                    b=1;
                    c++;
                    stores = new HashMap<>();
                    canteen = new Canteen(rs.getString("Cname"),rs.getDouble("Cexval"));
                }
                stores.put(b,store);
                canteen.setStores(stores);
                school.add(c,canteen);
                m=i;
                n=j;
            }
            database.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

//    返回随机的菜品
    public Dash randomDash(){
        if(school == null){
            return null;
        }
        return school.random().random().random();
    }

//    返回随机的店铺
    public Store randomStore(){
        if(school == null){
            return null;
        }
        return school.random().random();
    }

//    返回随机的饭堂
    public Canteen randomCanteen(){
        if(school == null){
            return null;
        }
        return school.random();
    }

//    根据菜品的口味进行随机
    public String randomByFlavor(String flavor){
        database = new Database();
        someDash = new HashMap<>();
        int n=0;
        ResultSet rs = database.searchByFlavor(flavor);
        try{
            while(rs.next()){
                n++;
                someDash.put(n,rs.getString("Dname"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return someDash.get((int)(Math.random()* someDash.size())+1);
    }





}

