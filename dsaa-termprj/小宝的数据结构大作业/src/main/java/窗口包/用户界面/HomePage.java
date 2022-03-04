package 窗口包.用户界面;

import 功能包.Function;
import 数据库包.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomePage extends JPanel implements ActionListener {
    JRadioButton typeA,typeB,typeC;
    JRadioButton rangeA,rangeB,rangeC;
    ButtonGroup group1,group2;
    JTextArea text;
    JScrollPane scroll;
    Box boxH1,boxH2,boxH3;
    Box boxV1;
    Function function;
    Database database;

    public void setFunction(Function function){
        this.function = function;
    }

    public void setDatabase(Database database){
        this.database = database;
    }

    public HomePage(){
        init();
        setVisible(true);
        setSize(450,450);
        setLayout(new FlowLayout());
    }

    public void init(){
        typeA = new JRadioButton("综合");
        typeB = new JRadioButton("价格");
        typeC = new JRadioButton("评价");
        group1 = new ButtonGroup();
        group1.add(typeA);
        group1.add(typeB);
        group1.add(typeC);

        rangeA = new JRadioButton("饭堂");
        rangeB = new JRadioButton("店铺");
        rangeC = new JRadioButton("菜品");
        group2 = new ButtonGroup();
        group2.add(rangeA);
        group2.add(rangeB);
        group2.add(rangeC);

        text = new JTextArea(16,35);
        scroll = new JScrollPane(text);

        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxV1 = Box.createVerticalBox();


        boxH1.add(new JLabel("范围："));
        boxH1.add(Box.createHorizontalStrut(5));
        boxH1.add(rangeA);
        boxH1.add(rangeB);
        boxH1.add(rangeC);

        boxH2.add(new JLabel("类型："));
        boxH2.add(Box.createHorizontalStrut(5));
        boxH2.add(typeA);
        boxH2.add(typeB);
        boxH2.add(typeC);


        boxH3.add(scroll);

        boxV1.add(boxH1);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH2);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH3);
        add(boxV1);

        typeA.addActionListener(this);
        typeB.addActionListener(this);
        typeC.addActionListener(this);
        rangeA.addActionListener(this);
        rangeB.addActionListener(this);
        rangeC.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet rs;

//        综合饭堂
        if(typeA.isSelected() == true && rangeA.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from canteen order by Cexval DESC");
            try{
                while(rs.next()){
                    text.append("       "+rs.getString("Cname")+"          "+rs.getDouble("Cexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        综合店铺
        else if(typeA.isSelected() == true && rangeB.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from stores order by Sexval DESC");
            try{
                while(rs.next()){
                    text.append("        "+rs.getString("Sname")+"          "+rs.getDouble("Sexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        综合菜品
        else if(typeA.isSelected() == true && rangeC.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"价格"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from dashes order by Dexval DESC,Price ASC");
            try{
                while(rs.next()){
                    text.append("     "+rs.getString("Dname")+"          "+rs.getDouble("Price")+"          "+rs.getDouble("Dexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        价格饭堂
        else if(typeB.isSelected() == true && rangeA.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from canteen order by Cexval DESC");
            try{
                while(rs.next()){
                    text.append("       "+rs.getString("Cname")+"          "+rs.getDouble("Cexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        价格店铺
        else if(typeB.isSelected() == true && rangeB.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from stores order by Sexval DESC");
            try{
                while(rs.next()){
                    text.append("       "+rs.getString("Sname")+"          "+rs.getDouble("Sexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        价格菜品
        else if(typeB.isSelected() == true && rangeC.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"价格"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from dashes order by Price ASC");
            try{
                while(rs.next()){
                    text.append("     "+rs.getString("Dname")+"          "+rs.getDouble("Price")+"          "+rs.getDouble("Dexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        评价饭堂
        else if(typeC.isSelected() == true && rangeA.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from canteen order by Cexval DESC");
            try{
                while(rs.next()){
                    text.append("       "+rs.getString("Cname")+"          "+rs.getDouble("Cexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        评价店铺
        else if(typeC.isSelected() == true && rangeB.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from stores order by Sexval DESC");
            try{
                while(rs.next()){
                    text.append("        "+rs.getString("Sname")+"          "+rs.getDouble("Sexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
//        评价菜品
        else if(typeC.isSelected() == true && rangeC.isSelected() == true){
            text.setText("");
            text.append("            "+"名字"+"            "+"价格"+"            "+"评分"+"\n");
            rs = database.searchBySQL("select * from dashes order by Dexval DESC");
            try{
                while(rs.next()){
                    text.append("     "+rs.getString("Dname")+"          "+rs.getDouble("Price")+"          "+rs.getDouble("Dexval")+"\n");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
