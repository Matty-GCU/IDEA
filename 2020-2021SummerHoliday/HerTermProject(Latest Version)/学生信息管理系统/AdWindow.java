package 学生信息管理系统;
import javax.swing.*;
import java.awt.event.*;
/**
 * 继承了基础窗口类，增添了添加和删除两种功能
 * @author Swance
 *
 */
public class AdWindow extends baseWindow implements ActionListener{
	JButton add,delete;
	AdWindow() {
		area.append("执行添加行为时请按提示填写完整信息；执行删除行为时可只填写一部分信息。"+"\n");
		area.append("格式：学号XXX（如001）、姓名XXX（如李三）、电话号码（11位）、宿舍"+"\n"+"（宿舍栋-宿舍号）、年级班级");
		add = new JButton("添加");
		add.addActionListener(this);
		delete = new JButton("删除");
		delete.addActionListener(this);
		boxv3.add(add);
		boxv3.add(Box.createVerticalStrut(8));
		boxv3.add(delete);
		boxv3.add(Box.createVerticalStrut(8));
		baseBox.add(boxv3);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			area.setText(null);
			getInformation();
			clear();
			String s = system.addStudent(str[0], str[1], str[2], str[3], str[4]);
			area.append(s);
		}
		else if(e.getSource() == delete) {
			area.setText(null);
			getInformation();
			clear();
			String s = system.deleteStudent(str[0],str[1],str[2],str[3],str[4]);
			area.append(s);
		}
		system.fileWriter();
	}

}
