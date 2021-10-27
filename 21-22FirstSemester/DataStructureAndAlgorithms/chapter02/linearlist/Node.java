package chapter02.linearlist;

/**
 * 0 problems（数据结构作业代码-增强版）
 */
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node() {}

    public Node(T data) {
        this();
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this(data);
        this.next = next;
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
