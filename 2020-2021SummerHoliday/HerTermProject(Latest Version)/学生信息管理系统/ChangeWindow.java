package 学生信息管理系统;
import javax.swing.*;
import java.awt.event.*;
/**
 * 继承了基础窗口类，添加了修改功能
 * @author Swance
 *
 */
public class ChangeWindow extends baseWindow implements ActionListener{
	int i = 0;
	JButton find,change;
	ChangeWindow() {
		area.append("执行修改行为时先填写原信息（可填写一部分）"+"\n"+"然后根据提示继续填写修改后的信息（需完整）"+"\n"+"格式：学号XXX（如001）、姓名XXX（如李三）、电话号码（11位）、宿舍"+"\n"+"（宿舍栋-宿舍号）、年级班级");
		find = new JButton("查找原信息");
		find.addActionListener(this);
		change = new JButton("确认修改");
		change.addActionListener(this);
		boxv3.add(find);
		boxv3.add(Box.createVerticalStrut(8));
		boxv3.add(change);
		boxv3.add(Box.createVerticalStrut(8));
		baseBox.add(boxv3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == find) {
			area.setText(null);
			getInformation();
			clear();
			i = system.search(str[0], str[1], str[2], str[3], str[4]);
			area.append("请输入修改后的完整学生信息！");
		}
		else if(e.getSource() == change) {
			area.setText(null);
			getInformation();
			clear();
			String s = system.change(i, str[0], str[1], str[2], str[3], str[4]);
			area.append(s);
		}
		system.fileWriter();
	}
}
