package 窗口包.用户界面;

import 功能包.Function;
import 数据库包.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserWindow extends JFrame implements MouseListener {
    JMenuBar bar;
    JMenu homePage,random;
    JPanel panel;
    CardLayout card;
    HomePage hPage;
    RandomPage rPage;
    Function function;
    Database database;


    public UserWindow(){
        function = new Function();
        database = new Database();
        setVisible(true);
        setBounds(400,150,450,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("懒人“吃什么”——用户界面");
        init();
    }

    public void init(){
        hPage = new HomePage();
        rPage = new RandomPage();
        hPage.setFunction(function);
        hPage.setDatabase(database);
        rPage.setFunction(function);

        panel = new JPanel();
        card = new CardLayout();
        panel.setLayout(card);

        bar = new JMenuBar();
        homePage = new JMenu("首页");
        random = new JMenu("随机");
        bar.add(homePage);
        bar.add(random);
        setJMenuBar(bar);

        homePage.addMouseListener(this);
        random.addMouseListener(this);

        panel.add("首页",hPage);
        panel.add("随机界面",rPage);
        add(panel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == homePage){
            card.show(panel,"首页");
        }
        if(e.getSource() == random){
            card.show(panel,"随机界面");
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
