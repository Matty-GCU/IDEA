package 学生信息管理系统;
import javax.swing.*;
import java.awt.*;

/**
 * 作为基础窗口
 * @author Swance
 *
 */
public class baseWindow extends JPanel{
	Function system;
	JLabel ID,name,telephone,dormitory,classes,result;
	JTextField[] field;
	JTextArea area;
	Box boxv1,boxv2,baseBox,boxv3,baseBox2;
	String[] str = new String[5];
	baseWindow() {
		init();
		setSize(450,450);
		setVisible(true);
	}
	public boolean setFunction(Function f) {
		system=f;
		return true;
	}
	/**
	 * 对窗口进行添加组件并布局
	 */
	public void init() {
		setLayout(new FlowLayout());
		boxv1 = Box.createVerticalBox();
		boxv2 = Box.createVerticalBox();
		boxv3 = Box.createVerticalBox();
		baseBox = Box.createHorizontalBox();
		baseBox2 = Box.createHorizontalBox();
		ID = new JLabel("学号：");
		name = new JLabel("姓名：");
		telephone = new JLabel("电话号码：");
		dormitory = new JLabel("宿舍：");
		classes = new JLabel("年级班级：");
		boxv1.add(ID);
		boxv1.add(Box.createVerticalStrut(10));
		boxv1.add(name);
		boxv1.add(Box.createVerticalStrut(10));
		boxv1.add(telephone);
		boxv1.add(Box.createVerticalStrut(10));
		boxv1.add(dormitory);
		boxv1.add(Box.createVerticalStrut(10));
		boxv1.add(classes);
		boxv1.add(Box.createVerticalStrut(10));
		baseBox.add(boxv1);
		field = new JTextField[5];
		for(int i = 0;i<field.length;i++) {
			field[i] = new JTextField(12);
			boxv2.add(field[i]);
			boxv2.add(Box.createVerticalStrut(8));
		}
		baseBox.add(boxv2);
		baseBox.add(Box.createHorizontalStrut(15));
		baseBox.add(boxv3);
		add(baseBox);
		area = new JTextArea(10,35);
		baseBox2.add(area);
		add(baseBox2);
	}
	/**
	 * 对文本框清空
	 */
	public void clear() {
		for(int i = 0;i<field.length;i++) {
			field[i].setText(null);
		}
	}
	/**
	 * 读取输入到文本框中的信息
	 */
	public void getInformation() {
		for(int i = 0;i<field.length;i++) {
			 str[i] = field[i].getText();
		}
	}
}
