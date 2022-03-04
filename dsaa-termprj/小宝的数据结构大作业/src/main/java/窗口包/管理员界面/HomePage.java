package 窗口包.管理员界面;

import javax.swing.*;

public class HomePage extends JPanel {
    JLabel tip;
    Box boxV1,boxV2;
    public HomePage(){
        init();
        setVisible(true);
        setSize(450,450);
    }
    public void init(){
        tip = new JLabel("欢迎来到管理员界面！");
        boxV1 = Box.createVerticalBox();
        boxV2 = Box.createVerticalBox();
        boxV1.add(tip);
        boxV2.add(Box.createVerticalStrut(130));
        boxV2.add(boxV1);

        add(boxV2);
    }
}
