package 窗口包.管理员界面.添加界面;

import 数据库包.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StoreInsert extends JPanel implements ActionListener {
    JTextField canteenID,storeName;
    JButton insert,reset;
    JTextArea area;
    JScrollPane scroll;
    Database database = new Database();
    Box boxH1,boxH2,boxH3,boxH4,boxH5,boxV1;

    public StoreInsert(){
        init();
        setVisible(true);
        setSize(450,450);
    }

    public void setDatabase(Database database){
        this.database = database;
    }

    public void init(){
        canteenID = new JTextField();
        storeName = new JTextField();
        insert = new JButton("添加");
        reset = new JButton("取消");
        area = new JTextArea(14,35);

        setArea();

        scroll = new JScrollPane(area);
        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxH4 = Box.createHorizontalBox();
        boxH5 = Box.createHorizontalBox();
        boxV1 = Box.createVerticalBox();

        boxH1.add(new JLabel("输入所属饭堂ID："));
        boxH1.add(Box.createHorizontalStrut(5));
        boxH1.add(canteenID);

        boxH2.add(new JLabel("输入店铺名："));
        boxH2.add(Box.createHorizontalStrut(5));
        boxH2.add(storeName);

        boxH4.add(insert);
        boxH4.add(Box.createHorizontalStrut(10));
        boxH4.add(reset);

        boxH5.add(scroll);

        boxV1.add(boxH1);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH2);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH4);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH5);

        add(boxV1);

        insert.addActionListener(this);
        reset.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insert){
            int id = Integer.parseInt(canteenID.getText());
            int n = database.insertStore(id,storeName.getText());
            if(n == 1){
                area.setText("");
                setArea();
                area.append("\n"+"     "+"添加成功！"+"\n");
            }
            else{
                area.setText("");
                area.append("     "+"添加失败！"+"\n");
            }

        }
        if(e.getSource() == reset){
            canteenID.setText("");
            storeName.setText("");
            area.setText("");
            setArea();
        }
    }

    public void setArea(){
        area.setText("");
        ResultSet rs = null;
        try{
            rs = database.searchBySQL("select * from canteen");
            area.append("     "+"饭堂ID"+"        "+"饭堂名"+"        "+"饭堂评分"+"\n");
            while (rs.next()){
                area.append("         "+rs.getInt("Cno")+"           "+rs.getString("Cname")+"           "+rs.getDouble("Cexval")+"\n");
            }

            rs = database.searchBySQL("select * from stores");
            area.append("\n"+"     "+"店铺ID"+"     "+"饭堂ID"+"          "+"店铺名"+"          "+"店铺评分"+"\n");
            while (rs.next()){
                area.append("         "+rs.getInt("Sno")+"               "+rs.getInt("Cno")+"             "+rs.getString("Sname")+"             "+rs.getDouble("Sexval")+"\n");
            }

            rs = database.searchBySQL("select * from dashes");
            area.append("\n"+"     "+"菜品ID"+"     "+"店铺ID"+"          "+"菜品名"+"          "+"菜品价格"+"          "+"菜品口味"+"          "+"菜品评分"+"\n");
            while (rs.next()){
                area.append("         "+rs.getInt("Dno")+"               "+rs.getInt("Sno")+"           "+rs.getString("Dname")+"            "+rs.getDouble("Price")+"                    "+rs.getString("Flavor")+"                     "+rs.getDouble("Dexval")+"\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
