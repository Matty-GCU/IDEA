package 窗口包.管理员界面.删除界面;

import 数据库包.Database;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StoreDelete extends JPanel implements ActionListener {
    JTextField name;
    JButton delete,reset;
    JTextArea area;
    JScrollPane scroll;
    Database database;
    Box boxH1,boxH2,boxH3,boxV1;

    public StoreDelete(){
        init();
        setVisible(true);
        setSize(450,450);
    }

    public void init(){
        name = new JTextField();
        delete = new JButton("删除");
        reset = new JButton("取消");
        area = new JTextArea(15,35);
        scroll = new JScrollPane(area);
        database = new Database();
        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxV1 = Box.createVerticalBox();

        boxH1.add(new JLabel("输入店铺名："));
        boxH1.add(Box.createHorizontalStrut(5));
        boxH1.add(name);

        boxH2.add(delete);
        boxH2.add(Box.createHorizontalStrut(10));
        boxH2.add(reset);

        boxH3.add(scroll);

        boxV1.add(boxH1);
        boxV1.add(Box.createVerticalStrut(15));
        boxV1.add(boxH2);
        boxV1.add(Box.createVerticalStrut(15));
        boxV1.add(boxH3);
        boxV1.add(Box.createVerticalStrut(15));

        add(boxV1);

        delete.addActionListener(this);
        reset.addActionListener(this);
        setArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            int n = database.deleteStore(name.getText());
            if(n == 1){
                setArea();
                area.append("\n"+"     "+"删除成功！"+"\n");
            }
            else{
                area.setText("");
                area.append("     "+"删除失败！"+"\n");
            }
        }
        if(e.getSource() == reset){
            name.setText("");
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
