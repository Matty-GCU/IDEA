package 学生信息管理系统;
import javax.swing.*;
import java.awt.event.*;
/**
 * 作为系统的首页
 * @author Swance
 *
 */
public class HomePage extends JPanel implements ActionListener{
	Function manage;
	JLabel tip,label,label2;
	Box box1,box2,box3;
	JTextField field,field2;
	JButton button;
	String s;
	HomePage() {
		init();
		setVisible(true);
		setSize(450,450);
	}
	public boolean setFunction(Function manage) {
		this.manage = manage;
		return true;
	}
	public void init() {
		tip = new JLabel("欢迎进入学生信息管理系统！");
		label = new JLabel("（若想更改文件路径）请输入文件路径：");
		label2 = new JLabel("输入文件名：");
		field = new JTextField(12);
		field2 = new JTextField(12);
		button = new JButton("更改");
		button.addActionListener(this);
		box1 = Box.createVerticalBox();
		box2 = Box.createHorizontalBox();
		box3 = Box.createHorizontalBox();
		box1.add(Box.createVerticalStrut(100));
		box1.add(tip);
		box1.add(Box.createVerticalStrut(10));
		box2.add(label);
		box2.add(field);
		box3.add(label2);
		box3.add(field2);
		box1.add(box2);
		box1.add(Box.createVerticalStrut(10));
		box1.add(box3);
		box1.add(Box.createVerticalStrut(10));
		box1.add(button);
		box1.add(Box.createVerticalStrut(10));
		add(box1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s1 = field.getText();
		String s2 = field2.getText();
		manage.setFile(s1, s2);
		field.setText(null);
		field2.setText("更改成功！");
	}
}
