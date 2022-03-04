package 窗口包;

import 窗口包.用户界面.UserWindow;
import 窗口包.管理员界面.AdWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JTextField account;
    JPasswordField password;
    JRadioButton administrator,user;
    ButtonGroup group;
    Box boxH1,boxH2,boxH3;
    Box boxV1,boxV2,boxV3;
    JButton login,cancel;
    public Login(){
        setLayout(new FlowLayout());
        init();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(400,150,450,450);
        setVisible(true);
        setTitle("懒人“吃什么”");
    }
    public void init(){

        account = new JTextField(15);
        password = new JPasswordField(15);

        login = new JButton("登录");
        cancel = new JButton("取消");
        administrator = new JRadioButton("管理员");
        user = new JRadioButton("普通用户");
        group = new ButtonGroup();
        group.add(administrator);
        group.add(user);

        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxV3 = Box.createVerticalBox();
        boxV1 = Box.createVerticalBox();
        boxV2 = Box.createVerticalBox();

        login.addActionListener(this);
        cancel.addActionListener(this);

        boxV1.add(new JLabel("账号："));
        boxV1.add(Box.createVerticalStrut(20));
        boxV1.add(new JLabel("密码："));
        boxV2.add(account);
        boxV2.add(Box.createVerticalStrut(20));
        boxV2.add(password);
        boxH3.add(boxV1);
        boxH3.add(Box.createHorizontalStrut(10));
        boxH3.add(boxV2);
        boxH1.add(administrator);
        boxH1.add(user);
        boxH2.add(login);
        boxH2.add(Box.createHorizontalStrut(10));
        boxH2.add(cancel);
        boxV3.add(Box.createVerticalStrut(100));
        boxV3.add(boxH3);
        boxV3.add(Box.createVerticalStrut(10));
        boxV3.add(boxH1);
        boxV3.add(Box.createVerticalStrut(10));
        boxV3.add(boxH2);
        add(boxV3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            String pw = new String(password.getPassword());
            if(account.getText() == null || pw == null || "".equals(account) || "".equals(pw)){

            }
            else{
                if(administrator.isSelected()){
                    new AdWindow();
                }
                if(user.isSelected()){
                    new UserWindow();
                }
            }
        }
        if(e.getSource() == cancel){
            account.setText("");
            password.setText("");
        }
    }
}
