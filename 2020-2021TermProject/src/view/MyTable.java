package view;

import model.BinaryRelation;

import javax.swing.event.TableModelEvent;
import javax.swing.JTable;
import java.awt.Dimension;

/**
 * 基于BinaryRelation的表格组件。
 * 以可视化关系矩阵的形式，提供对二元关系的同步化查看、修改功能。
 * @author Matty
 * @version 1.0
 */
public class MyTable extends JTable {

    boolean[][] matrix;
    final String TRUE = "1";

    public MyTable(Object[][] rowData, Object[] columnNames, BinaryRelation binRelation) {
        super(rowData, columnNames);
        matrix = binRelation.getMatrix();
        getTableHeader().setPreferredSize(new Dimension(getColumnModel().getTotalColumnWidth(), 15));
    }

    /**
     * 当表格被修改时，自动更新它所代表的二元关系的底层矩阵数据。
     */
    @Override
    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
        int row = e.getFirstRow();
        int column = e.getColumn();
        if(matrix == null) {
            return;
        }
        String newValue = getModel().getValueAt(row, column).toString();
        if(newValue.equals(TRUE)) {
            matrix[row][column - 1]  = true;
            return;
        }
        matrix[row][column - 1]  = false;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }

}
