package 窗口包.管理员界面.添加界面;

import 数据库包.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DashInsert extends JPanel implements ActionListener {
    JTextField storeID,dashName,dashPrice,dashFlavor;
    JButton insert,reset;
    JTextArea area;
    JScrollPane scroll;
    Box boxH1,boxH2,boxH3,boxH4,boxH5,boxH6,boxV1;
    Database database;

    public DashInsert(){
        init();
        setVisible(true);
        setSize(450,450);
    }

    public void init(){
        database = new Database();
        storeID = new JTextField();
        dashName = new JTextField();
        dashPrice = new JTextField();
        dashFlavor = new JTextField();
        insert = new JButton("添加");
        reset = new JButton("取消");
        area = new JTextArea(12,35);
        scroll = new JScrollPane(area);

        insert.addActionListener(this);
        reset.addActionListener(this);

        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxH4 = Box.createHorizontalBox();
        boxH5 = Box.createHorizontalBox();
        boxH6 = Box.createHorizontalBox();
        boxV1 = Box.createVerticalBox();

        boxH1.add(new JLabel("输入所属店铺ID："));
        boxH1.add(Box.createHorizontalStrut(5));
        boxH1.add(storeID);

        boxH2.add(new JLabel("菜品名："));
        boxH2.add(Box.createHorizontalStrut(5));
        boxH2.add(dashName);

        boxH3.add(new JLabel("菜品价格："));
        boxH3.add(Box.createHorizontalStrut(5));
        boxH3.add(dashPrice);

        boxH4.add(new JLabel("菜品口味："));
        boxH4.add(Box.createHorizontalStrut(5));
        boxH4.add(dashFlavor);

        boxH5.add(insert);
        boxH5.add(Box.createHorizontalStrut(10));
        boxH5.add(reset);

        boxH6.add(scroll);

        boxV1.add(boxH1);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH2);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH3);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH4);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH5);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH6);
        add(boxV1);

        setArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == insert){
            int sno = Integer.parseInt(storeID.getText());
            String dname = dashName.getText();
            double price = Double.parseDouble(dashPrice.getText());
            String flavor = dashFlavor.getText();
            int n = database.insertDash(sno,dname,price,flavor);
            if(n == 1){
                area.setText("");
                setArea();
                area.append("\n"+"     "+"添加成功！"+"\n");
            }else{
                area.setText("");
                area.append("     "+"添加失败！"+"\n");
            }

        }
        if(e.getSource() == reset){
            storeID.setText("");
            dashName.setText("");
            dashPrice.setText("");
            dashFlavor.setText("");
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
