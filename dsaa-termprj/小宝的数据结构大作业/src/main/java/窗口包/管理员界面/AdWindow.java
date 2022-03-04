package 窗口包.管理员界面;
import 数据库包.Database;
import 窗口包.管理员界面.修改界面.DashUpdate;
import 窗口包.管理员界面.修改界面.StoreUpdate;
import 窗口包.管理员界面.删除界面.DashDelete;
import 窗口包.管理员界面.删除界面.StoreDelete;
import 窗口包.管理员界面.添加界面.DashInsert;
import 窗口包.管理员界面.添加界面.StoreInsert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdWindow extends JFrame implements MouseListener {
    JMenuBar bar;
    JMenu insertStore,deleteStore,updateStore,insertDash,deleteDash,updateDash;
    JPanel panel;
    CardLayout card;
    Database database;
    StoreInsert si;
    DashInsert di;
    StoreDelete sd;
    DashDelete dd;
    StoreUpdate su;
    DashUpdate du;
    HomePage h;

    public AdWindow(){
        init();
        database = new Database();
        setVisible(true);
        setBounds(150,150,450,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("懒人“吃什么”——管理员界面");
    }

    public void init(){
        bar = new JMenuBar();
        insertStore = new JMenu("添加店铺");
        deleteStore = new JMenu("删除店铺");
        updateStore = new JMenu("修改店铺");
        insertDash = new JMenu("添加菜品");
        deleteDash = new JMenu("删除菜品");
        updateDash = new JMenu("修改菜品");


        si = new StoreInsert();
        di = new DashInsert();
        sd = new StoreDelete();
        dd = new DashDelete();
        su = new StoreUpdate();
        du = new DashUpdate();
        h = new HomePage();


        bar.add(insertStore);
        bar.add(deleteStore);
        bar.add(updateStore);
        bar.add(insertDash);
        bar.add(deleteDash);
        bar.add(updateDash);
        setJMenuBar(bar);

        insertStore.addMouseListener(this);
        deleteStore.addMouseListener(this);
        updateStore.addMouseListener(this);
        insertDash.addMouseListener(this);
        deleteDash.addMouseListener(this);
        updateDash.addMouseListener(this);

        panel = new JPanel();
        card = new CardLayout();
        panel.setLayout(card);

        panel.add("首页",h);
        panel.add("添加店铺",si);
        panel.add("添加菜品",di);
        panel.add("删除店铺",sd);
        panel.add("删除菜品",dd);
        panel.add("修改店铺",su);
        panel.add("修改菜品",du);

        add(panel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == insertStore){
            card.show(panel,"添加店铺");
            setTitle("懒人“吃什么”——管理员界面——添加店铺");
        }
        if(e.getSource() == insertDash){
            card.show(panel,"添加菜品");
            setTitle("懒人“吃什么”——管理员界面——添加菜品");
        }
        if(e.getSource() == deleteStore){
            card.show(panel,"删除店铺");
            setTitle("懒人“吃什么”——管理员界面——删除店铺");
        }
        if(e.getSource() == deleteDash){
            card.show(panel,"删除菜品");
            setTitle("懒人“吃什么”——管理员界面——删除菜品");
        }
        if(e.getSource() == updateStore){
            card.show(panel,"修改店铺");
            setTitle("懒人“吃什么”——管理员界面——修改店铺");
        }
        if(e.getSource() == updateDash){
            card.show(panel,"修改菜品");
            setTitle("懒人“吃什么”——管理员界面——修改菜品");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
