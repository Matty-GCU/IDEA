package model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 基于{@code LinkedList<BasicSet>}的商集类。
 * @author Matty
 * @version 1.0
 */
public class QuotientSet extends LinkedList<BasicSet> {

    /**
     * 返回一个表示商集内容的String对象。
     * @return 一个表示商集内容的String对象。例如："{{1, 2}, {3}, {5}}"
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        Iterator<BasicSet> itr = iterator();
        str.append(itr.next().toString());
        while (itr.hasNext()) {
            str.append(", ");
            str.append(itr.next().toString());
        }
        str.append("}");
        return str.toString();
    }
}
