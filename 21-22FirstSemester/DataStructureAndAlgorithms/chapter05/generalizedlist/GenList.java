package chapter05.generalizedlist;

/**
 * 广义表类
 * @author Matty's PC
 */
public class GenList<T> {

    /**
     * 头结点
     */
    public GenNode<T> head;

    /**
     * 构造空广义表，表名为null
     */
    public GenList() {
        head = new GenNode<>(null, null, null);
    }
    /**
     * 构造空广义表，data指定表名
     * @param name
     */
    public GenList(T name) {
        head = new GenNode<>(name, null, null);
    }

    

}
