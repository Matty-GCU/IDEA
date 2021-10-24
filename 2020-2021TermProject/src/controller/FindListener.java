package controller;

import model.BinaryRelation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * 针对控制台窗口“求取”菜单的菜单项监听器。
 * @author Matty
 * @version 1.0
 */
public class FindListener implements ActionListener {

    BinaryRelation binRelation;
    JTextArea showProcess;
    final String R_CLOSURE = "自反闭包";
    final String S_CLOSURE = "对称闭包";
    final String T_CLOSURE = "传递闭包";
    final String PARTITION = "划分";
    final String GREATEST_ELEMENT = "最大元";
    final String LEAST_ELEMENT = "最小元";
    final String MAX_ELEMENT = "极大元";
    final String MIN_ELEMENT = "极小元";

    public FindListener() {
    }

    public void setBinaryRelation(BinaryRelation binRelation) {
        this.binRelation = binRelation;
    }

    public void setShowProcess(JTextArea showProcess) {
        this.showProcess = showProcess;
    }

    /**
     * 监听“求取”菜单中的所有菜单项的单击事件，将对应操作的计算结果呈现到文本区域中。
     * 注意：只有调用过两个setter后，此监视器才能根据点击事件进行相应操作。
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(binRelation == null || showProcess == null) {
            return;
        }
        String text = ((JMenuItem)e.getSource()).getText();
        switch(text) {
            case R_CLOSURE:
                showFindingClosure(R_CLOSURE);
                break;
            case S_CLOSURE:
                showFindingClosure(S_CLOSURE);
                break;
            case T_CLOSURE:
                showFindingClosure(T_CLOSURE);
                break;
            case PARTITION:
                showFindingPartition();
                break;
            case GREATEST_ELEMENT:
                showFindingElements(GREATEST_ELEMENT);
                break;
            case LEAST_ELEMENT:
                showFindingElements(LEAST_ELEMENT);
                break;
            case MAX_ELEMENT:
                showFindingElements(MAX_ELEMENT);
                break;
            case MIN_ELEMENT:
                showFindingElements(MIN_ELEMENT);
                break;
            default: showProcess.append("ERROR\n");
        }
    }

    public void showFindingClosure(String type) {
        switch (type) {
            case R_CLOSURE:
                showProcess.append("自反闭包：");
                BinaryRelation rClosure = binRelation.findClosure(BinaryRelation.CLOSURE_TYPE_REFLEXIVE);
                if (rClosure == binRelation) {
                    showProcess.append("它本身");
                } else {
                    showProcess.append("\n" + rClosure);
                }
                break;
            case S_CLOSURE:
                showProcess.append("对称闭包：");
                BinaryRelation sClosure = binRelation.findClosure(BinaryRelation.CLOSURE_TYPE_SYMMETRIC);
                if (sClosure == binRelation) {
                    showProcess.append("它本身");
                } else {
                    showProcess.append("\n" + sClosure);
                }
                break;
            case T_CLOSURE:
                showProcess.append("传递闭包：");
                BinaryRelation tClosure = binRelation.findClosure(BinaryRelation.CLOSURE_TYPE_TRANSITIVE);
                if (tClosure == binRelation) {
                    showProcess.append("它本身");
                } else {
                    showProcess.append("\n" + tClosure);
                }
                break;
            default:
        }
        showProcess.append("\n");
    }

    public void showFindingPartition() {
        if(! binRelation.isEquRelation()) {
            showProcess.append("错误！该二元关系不是等价关系，无法求取划分\n");
            return;
        }
        showProcess.append("划分：");
        showProcess.append(binRelation.generatePartition() + "\n");
    }

    public void showFindingElements(String type) {
        switch(type) {
            case GREATEST_ELEMENT:
                if(! binRelation.isPartialOrder()) {
                    showProcess.append("错误！该二元关系不是偏序关系，无法求取最大元\n");
                    return;
                }
                showProcess.append("最大元：");
                Integer i = binRelation.greatestElement();
                showProcess.append(i == null ? "无" : i.toString());
                break;
            case LEAST_ELEMENT:
                if(! binRelation.isPartialOrder()) {
                    showProcess.append("错误！该二元关系不是偏序关系，无法求取最小元\n");
                    return;
                }
                showProcess.append("最小元：");
                Integer i2 = binRelation.leastElement();
                showProcess.append(i2 == null ? "无" : i2.toString());
                break;
            case MAX_ELEMENT:
                if(! binRelation.isPartialOrder()) {
                    showProcess.append("错误！该二元关系不是偏序关系，无法求取极大元\n");
                    return;
                }
                showProcess.append("极大元：" + Arrays.toString(binRelation.maxElements().toArray()));
                break;
            case MIN_ELEMENT:
                if(! binRelation.isPartialOrder()) {
                    showProcess.append("错误！该二元关系不是偏序关系，无法求取极小元\n");
                    return;
                }
                showProcess.append("极小元：" + Arrays.toString(binRelation.minElements().toArray()));
                break;
            default:
        }
        showProcess.append("\n");
    }

}
