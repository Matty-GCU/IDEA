package 数据库包;

import java.sql.*;
//将数据库连接封装到一个类里，需要连接数据库时就创建该类对象并调用getConnect()方法获得连接即可
public class Database {
//    mysql驱动包名
    private static final String driver_name = "com.mysql.cj.jdbc.Driver";
//    mysql数据库连接地址
    private static final String url = "jdbc:mysql://localhost:3306/test";
//    用户名
    private static final String username = "root";
//    密码
//    private static final String password = "20210327wh@";
    private static final String password = "123456";
    Connection connection = null;
    PreparedStatement prst =null;
    ResultSet rs = null;

    //创建该类对象时就建立了连接
    public Database(){
        try{
            //加载mysql驱动类
            Class.forName(driver_name);
            //获取数据库连接
            connection = DriverManager.getConnection(url,username,password);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //关闭连接
    public void close(){
        if(prst!=null){
            try{
                prst.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        if(rs == null){
            try{
                rs.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //将返回结果集的代码封装起来
    public ResultSet searchBySQL(String sql){
        try{
            prst = connection.prepareStatement(sql);
            rs = prst.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet searchByFlavor(String colvalue){
        try{
            String sql = "select * from dashes where Flavor = ?";
            prst = connection.prepareStatement(sql);
            prst.setString(1,colvalue);
            rs = prst.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public int insertStore(int cno,String sname){
        String sql = "insert into stores(Cno,Sname) values(?,?)";
        int n = -1;
        try{
            prst = connection.prepareStatement(sql);
            prst.setInt(1,cno);
            prst.setString(2,sname);
            n = prst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }

    public int insertDash(int sno,String dname,double price,String flavor){
        String sql = "insert into dashes(Sno,Dname,Price,Flavor) values(?,?,?,?)";
        int n = -1;
        try{
            prst = connection.prepareStatement(sql);
            prst.setInt(1,sno);
            prst.setString(2,dname);
            prst.setDouble(3,price);
            prst.setString(4,flavor);
            n = prst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }

    public int deleteStore(String sname){
        String sql = "delete from stores where Sname = ?";
        int n = -1;
        try{
            prst = connection.prepareStatement(sql);
            prst.setString(1,sname);
            n = prst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }

    public int deleteDash(String dname){
        String sql = "delete from dashes where Dname = ?";
        int n = -1;
        try{
            prst = connection.prepareStatement(sql);
            prst.setString(1,dname);
            n = prst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }

    public int updateStore(int sno,String property,String newProperty){
        String sql = null;
        int n = -1;
        if("店铺名".equals(property)){
            sql = "update stores set Sname = ? where Sno = ?";
        }
        else if("店铺评分".equals(property)){
            sql = "update stores set Sexval = ? where Sno = ?";
        }
        try{
            prst = connection.prepareStatement(sql);
            prst.setString(1,newProperty);
            prst.setInt(2,sno);
            n = prst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }

    public int updateDash(int dno,String property,String newProperty){
        String sql = null;
        int n = -1;
        try{
            if("菜品名".equals(property)){
                sql = "update dashes set Dname = ? where Dno = ?";
                prst = connection.prepareStatement(sql);
                prst.setString(1,newProperty);
                prst.setInt(2,dno);
            }
            else if("菜品价格".equals(property)){
                sql = "update dashes set Price = ? where Dno = ?";
                double price = Double.parseDouble(newProperty);
                prst = connection.prepareStatement(sql);
                prst.setDouble(1,price);
                prst.setInt(2,dno);
            }
            else if("菜品口味".equals(property)){
                sql = "update dashes set Flavor = ? where Dno = ?";
            }
            else if("菜品评分".equals(property)){
                sql = "update dashes set Dexval = ? where Dno = ?";
                double exval = Double.parseDouble(newProperty);
                prst = connection.prepareStatement(sql);
                prst.setDouble(1,exval);
                prst.setInt(2,dno);
            }
            n = prst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }

}
