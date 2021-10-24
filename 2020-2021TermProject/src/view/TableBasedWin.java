package view;

import model.BasicSet;
import model.BinaryRelation;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 旧版的基于MyTable的控制台窗口。
 * 提供所有可视化操作的入口。
 * @author Matty
 * @version 1.0
 */
public class TableBasedWin extends FrameWithMenu implements MouseListener {

    JTextField input;
    MyTable myTable;
    JTextArea showProcess;

    boolean haveInit = false;

    /**
     * 实例化一个窗口对象及其子组件，并利用文本框和文本区域提供一定的文字操作指引。
     */
    public TableBasedWin() {
        super();
        input = new JTextField(30);
        add(input, BorderLayout.NORTH);
        showProcess = new JTextArea(23, 0);
        add(new JScrollPane(showProcess), BorderLayout.SOUTH);
        input.setText("请输入集合。示例：{-1, 0, 2, 4}（仅支持整数！）");
        showProcess.append("温馨提醒：\n");
        showProcess.append("1) 输入集合后请点击菜单栏的【初始化】，\n程序将基于该集合自动生成一个等待填入的关系矩阵。\n");
        showProcess.append("2) 在矩阵中输入数据后请【回车】，确保数据已被更新。\n");

        init.addMouseListener(this);
        restart.addMouseListener(this);

        setBounds(100, 60, 350, 580);
        setTitle("二元关系计算器");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * 监听“初始化”和“重启”菜单的单击事件，进行初始化或重启操作。
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
    }

    /**
     * 初始化窗口：
     * 读取文本框内容作为基础集合，基于该集合生成一个没有任何有序偶的二元关系，
     * 将代表关系矩阵的表格添加到窗口中，并设置合适的大小。用户可直接在表格中进行添加或删除有序偶。
     */
    public void initWin() {
        if(haveInit) {
            return;
        }
        else {
            haveInit = true;
        }

        BasicSet basicSet = new BasicSet();
        String[] strArray = input.getText().split("[^0123456789-]+");
        int startIndex = 0;
        if("".equals(strArray[0])) {
            startIndex = 1;
        }
        try {
            for(int i = startIndex; i < strArray.length; i++) {
                basicSet.add(Integer.parseInt(strArray[i]));
            }
        }
        catch (NumberFormatException e) {
            showProcess.append("初始化失败！输入格式错误！\n");
            return;
        }

        BinaryRelation binRelation = new BinaryRelation(basicSet);
        myTable = binRelation.generateMyTable();
        int size = strArray.length;
        myTable.setPreferredScrollableViewportSize(new Dimension(33 * size, 16 * size));
        input.setText(basicSet.toString());
        add(new JScrollPane(myTable), BorderLayout.CENTER);
        pack();

        judgeListener.setBinaryRelation(binRelation);
        judgeListener.setShowProcess(showProcess);
        findListener.setBinaryRelation(binRelation);
        findListener.setShowProcess(showProcess);

        showProcess.append("\n---------------初始化成功！---------------\n");
    }

    /**
     * 重启窗口：
     * 实例化一个新的窗口，并关闭当前窗口。
     */
    public void restartWin() {
        dispose();
        TableBasedWin tableBasedWin = new TableBasedWin();
        tableBasedWin.setLocation(getX(), getY());
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
