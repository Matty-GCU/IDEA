package 学生信息管理系统;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * 学生信息系统窗口由四个中间容器组成——首页，添加删除，查询和修改
 * @author Swance
 *
 */
public class Windows extends JFrame implements MouseListener{
	Function function;
	JMenuBar bar;
	JMenu menu1,menu2,menu3;
	AdWindow ad;
	SearchWindow sea;
	ChangeWindow cha;
	HomePage page;
	JPanel pCenter;
	CardLayout card;
	Windows() {
		init();
		setVisible(true);
		setBounds(250,150,450,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("学生信息管理系统");
	}
	public void init() {
		function = new Function();
		pCenter = new JPanel();
		card = new CardLayout();
		pCenter.setLayout(card);
		ad = new AdWindow();
		ad.setFunction(function);
		sea = new SearchWindow();
		sea.setFunction(function);
		cha = new ChangeWindow();
		cha.setFunction(function);
		page = new HomePage();
		page.setFunction(function);
		bar = new JMenuBar();
		menu1 = new JMenu("添加或删除");
		menu2 = new JMenu("查询");
		menu3 = new JMenu("修改");
		menu1.addMouseListener(this);
		menu2.addMouseListener(this);
		menu3.addMouseListener(this);
		bar.add(menu1);
		bar.add(menu2);
		bar.add(menu3);
		setJMenuBar(bar);
		pCenter.add("首页",page);
		pCenter.add("添加或删除",ad);
		pCenter.add("查询",sea);
		pCenter.add("修改",cha);
		add(pCenter);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menu1) {
			card.show(pCenter, "添加或删除");
		}
		else if(e.getSource()==menu2) {
			card.show(pCenter, "查询");
		}
		else if(e.getSource()==menu3) {
			card.show(pCenter,"修改");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
