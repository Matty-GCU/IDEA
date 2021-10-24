package controller;

import model.BinaryRelation;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 针对控制台窗口“判断”菜单的菜单项监听器。
 * @author Matty
 * @version 1.0
 */
public class JudgeListener implements ActionListener {

    BinaryRelation binRelation;
    JTextArea showProcess;
    final String REFLEXIVE = "自反性";
    final String ANTI_REFLEXIVE = "反自反性";
    final String SYMMETRIC = "对称性";
    final String ANTI_SYMMETRIC = "反对称性";
    final String TRANSITIVE = "传递性";
    final String EQU_RELATION = "等价关系";
    final String PARTIAL_ORDER = "偏序关系";

    public JudgeListener() {
    }

    public void setBinaryRelation(BinaryRelation binRelation) {
        this.binRelation = binRelation;
    }

    public void setShowProcess(JTextArea showProcess) {
        this.showProcess = showProcess;
    }

    /**
     * 监听“判断”菜单中的所有菜单项的单击事件，将对应操作的计算结果呈现到文本区域中。
     * 注意：只有调用过两个setter后，此监视器才能根据点击事件进行相应操作。
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(binRelation == null || showProcess == null) {
            return;
        }
        String text = ((JMenuItem)e.getSource()).getText();
        switch(text) {
            case REFLEXIVE:
                showProcess.append("自反性：" + (binRelation.isReflexive()));
                break;
            case ANTI_REFLEXIVE:
                showProcess.append("反自反性：" + (binRelation.isAntiReflexive()));
                break;
            case SYMMETRIC:
                showProcess.append("对称性：" + (binRelation.isSymmetric()));
                break;
            case ANTI_SYMMETRIC:
                showProcess.append("反对称性：" + (binRelation.isAntiSymmetric()));
                break;
            case TRANSITIVE:
                showProcess.append("传递性：" + (binRelation.isTransitive()));
                break;
            case EQU_RELATION:
                showProcess.append("等价关系：" + (binRelation.isEquRelation()));
                break;
            case PARTIAL_ORDER:
                showProcess.append("偏序关系：" + (binRelation.isPartialOrder()));
                break;
            default:
                showProcess.append("ERROR");
        }
        showProcess.append("\n");
    }

}
