package chapter02.linearlist.linked;

/**
 * @author Matty's PC
 */
public class DoublyNode<T> {
    public T data;
    public DoublyNode<T> prev;
    public DoublyNode<T> next;

    public DoublyNode(T data, DoublyNode<T> prev, DoublyNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoublyNode() {}

    @Override
    public String toString() {
        return data == null ? null : data.toString();
    }
}
