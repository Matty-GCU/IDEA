package 学生信息管理系统;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 具有查找功能的窗口
 * @author Swance
 *
 */
public class SearchWindow extends JPanel implements ActionListener{
	Function manage;
	JButton search;
	JLabel tip;
	JTextField field;
	JTextArea area;
	SearchWindow() {
		init();
		setSize(450,450);
		setVisible(true);
	}
	public boolean setFunction(Function f) {
		manage = f;
		return true;
	}
	public void init() {
		setLayout(new FlowLayout());
		search = new JButton("查询");
		search.addActionListener(this);
		field = new JTextField(12);
		tip = new JLabel("请输入信息：");
		area = new JTextArea(10,35);
		area.append("执行查询行为时可填写一部分信息"+"\n"+"格式：学号XXX（如001）、姓名XXX（如李三）、电话号码（11位）、宿舍"+"\n"+"（宿舍栋-宿舍号）、年级班级");
		add(tip);
		add(field);
		add(search);
		add(area);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		area.setText(null);
		String s = field.getText();
		String str = manage.searchStudent(s);
		area.append(str);
	}
}
