package view;

import controller.FindListener;
import controller.JudgeListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 菜单框架。
 * 具有完整的菜单栏、菜单和菜单项，提供所有可视化操作所需要的菜单项。
 * @author Matty
 * @version 1.0
 */
public class FrameWithMenu extends JFrame {

    JMenuBar menuBar;
    JMenu init, restart, judge, find;
    JMenuItem reflexive, antiReflexive, symmetric, antiSymmetric, transitive, equRelation, partialOrder;
    JMenuItem rClosure, sClosure, tClosure, partition, greatestElement, leastElement, maxElement, minElement;
    JudgeListener judgeListener;
    FindListener findListener;

    /**
     * 实例化一个菜单框架对象及其所有子组件。
     * 注意：此时尽管框架的所有菜单项都已经添加相应的监视器，但仍然不会根据点击事件进行相应操作，仅作为可用功能的展示。
     */
    public FrameWithMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        init = new JMenu("初始化");
        judge = new JMenu("判断");
        find = new JMenu("求取");
        restart = new JMenu("重启");
        menuBar.add(init);
        menuBar.add(judge);
        menuBar.add(find);
        menuBar.add(restart);
        reflexive = new JMenuItem("自反性");
        antiReflexive = new JMenuItem("反自反性");
        symmetric = new JMenuItem("对称性");
        antiSymmetric = new JMenuItem("反对称性");
        transitive = new JMenuItem("传递性");
        equRelation = new JMenuItem("等价关系");
        partialOrder = new JMenuItem("偏序关系");
        judge.add(reflexive);
        judge.addSeparator();
        judge.add(antiReflexive);
        judge.addSeparator();
        judge.add(symmetric);
        judge.addSeparator();
        judge.add(antiSymmetric);
        judge.addSeparator();
        judge.add(transitive);
        judge.addSeparator();
        judge.add(equRelation);
        judge.addSeparator();
        judge.add(partialOrder);
        rClosure = new JMenuItem("自反闭包");
        sClosure = new JMenuItem("对称闭包");
        tClosure = new JMenuItem("传递闭包");
        partition = new JMenuItem("划分");
        greatestElement = new JMenuItem("最大元");
        leastElement = new JMenuItem("最小元");
        maxElement = new JMenuItem("极大元");
        minElement = new JMenuItem("极小元");
        find.add(rClosure);
        find.addSeparator();
        find.add(sClosure);
        find.addSeparator();
        find.add(tClosure);
        find.addSeparator();
        find.add(partition);
        find.addSeparator();
        find.add(greatestElement);
        find.addSeparator();
        find.add(leastElement);
        find.addSeparator();
        find.add(maxElement);
        find.addSeparator();
        find.add(minElement);
        judgeListener = new JudgeListener();
        findListener = new FindListener();
        reflexive.addActionListener(judgeListener);
        antiReflexive.addActionListener(judgeListener);
        symmetric.addActionListener(judgeListener);
        antiSymmetric.addActionListener(judgeListener);
        transitive.addActionListener(judgeListener);
        equRelation.addActionListener(judgeListener);
        partialOrder.addActionListener(judgeListener);
        rClosure.addActionListener(findListener);
        sClosure.addActionListener(findListener);
        tClosure.addActionListener(findListener);
        partition.addActionListener(findListener);
        greatestElement.addActionListener(findListener);
        leastElement.addActionListener(findListener);
        maxElement.addActionListener(findListener);
        minElement.addActionListener(findListener);
    }

}
