package chapter05.generalizedlist;

/**
 * 广义表结点类
 * @author Matty's PC
 */
public class GenNode<T> {
    /**
     * 结点数据
     * 若child为空（不存在子表），则data表示该结点数据；
     * 若child不未空（存在子表），则data也可以理解为子表的表名。
     */
    public T data;

    /**
     * 子表
     */
    public GenListImpl<T> child;

    /**
     * 后继结点
     */
    public GenNode<T> next;

    public GenNode(T data, GenListImpl<T> child, GenNode<T> next) {
        this.data = data;
        this.child = child;
        this.next = next;
    }

    @Override
    public String toString() {
        //下面这行如何理解？如果存在子表，会不会就漏了data.toString()？
        //答案是不会！请注意GenListCreator的create2()方法是如何处理结点的子表的。
        return child == null ? data.toString() : child.toString();
    }
}
