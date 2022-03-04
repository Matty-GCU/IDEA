package 窗口包.管理员界面.修改界面;

import 数据库包.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StoreUpdate extends JPanel implements ActionListener {
    JTextField storeID,property,newproperty;
    JButton update,reset;
    JTextArea area;
    JScrollPane scroll;
    Database database;
    Box boxH1,boxH2,boxH3,boxH4,boxH5,boxV1;

    public StoreUpdate(){
        init();
        setVisible(true);
        setSize(450,450);
    }

    public void init(){
        storeID = new JTextField();
        property = new JTextField();
        newproperty = new JTextField();
        update = new JButton("修改");
        reset = new JButton("取消");
        area = new JTextArea(15,35);
        scroll = new JScrollPane(area);
        database = new Database();
        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxH4 = Box.createHorizontalBox();
        boxH5 = Box.createHorizontalBox();
        boxV1 = Box.createVerticalBox();

        boxH1.add(new JLabel("输入店铺ID："));
        boxH1.add(Box.createHorizontalStrut(5));
        boxH1.add(storeID);

        boxH2.add(new JLabel("需修改的属性名："));
        boxH2.add(Box.createHorizontalStrut(5));
        boxH2.add(property);

        boxH3.add(new JLabel("修改的属性值："));
        boxH3.add(Box.createHorizontalStrut(5));
        boxH3.add(newproperty);

        boxH4.add(update);
        boxH4.add(Box.createHorizontalStrut(10));
        boxH4.add(reset);

        boxH5.add(scroll);

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
        add(boxV1);

        update.addActionListener(this);
        reset.addActionListener(this);
        setArea();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            int sno = Integer.parseInt(storeID.getText());
            String p = property.getText();
            String np = newproperty.getText();
            int n = database.updateStore(sno,p,np);
            if(n == 1){
                setArea();
                area.append("\n"+"     "+"修改成功！"+"\n");
            }
            else{
                area.setText("");
                area.append("     "+"修改失败！");
            }
        }
        if(e.getSource() == reset){
            storeID.setText("");
            property.setText("");
            newproperty.setText("");
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
