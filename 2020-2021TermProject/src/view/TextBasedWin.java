package view;

import model.BasicSet;
import model.BinaryRelation;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 基于纯文本交互的控制台窗口。
 * 提供所有可视化操作的入口。
 * @author Matty
 * @version 1.0
 */
public class TextBasedWin extends FrameWithMenu implements MouseListener {

    JMenu tryOnOldVision;
    JTextField input;
    JTextArea showProcess;
    BinaryRelation binRelation;

    /**
     * 实例化一个窗口对象及其子组件，并利用文本框和文本区域提供一定的文字操作指引。
     */
    public TextBasedWin() {
        tryOnOldVision = new JMenu("试用旧版");
        menuBar.add(tryOnOldVision);
        init.addMouseListener(this);
        restart.addMouseListener(this);
        tryOnOldVision.addMouseListener(this);

        setBounds(0, 0, 750, 650);
        input = new JTextField(90);
        showProcess = new JTextArea(30, 90);
        add(input);
        add(new JScrollPane(showProcess));
        input.setText("请在此输入二元关系并点击【初始化】。示例：{(1, 1), (1, 2), (2, 4)}");
        Font font = new Font("宋体", Font.PLAIN, 15);
        input.setFont(font);
        showProcess.setFont(font);

        setTitle("二元关系计算器（by Matty）");
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * 监听“初始化”“重启”和"试用旧版"菜单的单击事件，执行对应的操作。
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if(source == init) {
            initWin();
        }
        else if(source == restart) {
            restartWin();
        }
        else if(source == tryOnOldVision) {
            openOldVersionWin();
        }
    }

    /**
     * 初始化窗口：
     * 读取文本框内容，判断用户输入的对二元关系的描述是否合法；若合法，则生成一个相应的二元关系。
     */
    public void initWin() {
        String text = input.getText().replaceAll(" ", "");
        if("".equals(text)) {
            return;
        }
        else if((text.charAt(0) != '{') || (text.charAt(text.length() - 1) != '}')) {
            showProcess.append("初始化失败！描述二元关系必须以 { 开头，以 } 结尾！\n");
            return;
        }
        else {
            String illegalStr = text.replaceAll("[0123456789\\-,，()（）{}]+", "");
            if(illegalStr.length() > 0) {
                showProcess.append("初始化失败！请检查非法字符！\n");
                return;
            }
        }
        BasicSet basicSet = new BasicSet();
        String[] numsOccurred = text.split("[^0123456789-]+");
        try {
            for(int i = 1; i < numsOccurred.length; i++) {
                basicSet.add(Integer.parseInt(numsOccurred[i]));
            }
            binRelation = new BinaryRelation(basicSet);
            text = text.replaceAll("[{][(（]", "");
            text = text.replaceAll("[)）][}]", "");
            String[] strArr = text.split("[)）][,，][(（]");
            for(String orderedPair: strArr) {
                String[] elements = orderedPair.split("[,，]");
                binRelation.addOrderedPair(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]));
            }
        }
        catch (NumberFormatException e) {
            showProcess.append("初始化失败！输入格式错误！\n");
            return;
        }

        findListener.setBinaryRelation(binRelation);
        findListener.setShowProcess(showProcess);
        judgeListener.setBinaryRelation(binRelation);
        judgeListener.setShowProcess(showProcess);
        String splitLine = "---------------------------------------------------\n";
        showProcess.append(splitLine);
        showProcess.append("初始化成功！！！\n选择“判断”或“求取”菜单，单击任意菜单项进行计算！\n\n");
        showProcess.append("您输入的二元关系是：\n");
        showProcess.append(binRelation + "\n");
    }

    /**
     * 重启窗口：
     * 实例化一个新的窗口，并关闭当前窗口。
     */
    public void restartWin() {
        dispose();
        TextBasedWin textBasedWin = new TextBasedWin();
        textBasedWin.setLocation(getX(), getY());
    }

    /**
     * 试用旧版：
     * 实例化一个旧版窗口，但不关闭当前窗口。
     * 注意：关闭旧版窗口或新版窗口并不会导致另一个窗口的关闭，二者在运行时互不影响。
     */
    public void openOldVersionWin() {
        TableBasedWin tableBasedWin = new TableBasedWin();
        tableBasedWin.setLocation(getX()+ getWidth(), getY());
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
