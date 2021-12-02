package chapter05.generalizedlist;

/**
 * 广义表结点类
 * @author Matty's PC
 */
public class GenNode<T> {
    public T data;
    public GenList<T> child;
    public GenNode<T> next;

//    public GenNode() {}

    public GenNode(T data, GenList<T> child, GenNode<T> next) {
        this.data = data;
        this.child = child;
        this.next = next;
    }
}
