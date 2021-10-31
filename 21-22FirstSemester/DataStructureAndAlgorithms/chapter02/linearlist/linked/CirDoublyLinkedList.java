package chapter02.linearlist.linked;

/**
 * @author Matty's PC
 */
public class CirDoublyLinkedList<T> {
    /**
     * 头结点
     */
    public DoublyNode<T> head;

    public CirDoublyLinkedList() {
        head = new DoublyNode<>();
        head.prev = head;
        head.next = head;
    }

    public boolean isEmpty() {
        return head == head.next;
    }

    public DoublyNode<T> insert(int i, T x) {
        if(x == null) {
            return null;
        }
        DoublyNode<T> front = head;
        //找到第i-1个结点
        for(int j = 0; j < i && front.next != head; j++) {
            front = front.next;
        }
        //这里画图非常有助于直观理解
        DoublyNode<T> newNode = new DoublyNode<>(x, front, front.next);
        front.next.prev = newNode;
        front.next = newNode;
        return newNode;
    }

    public DoublyNode<T> insert(T x) {
        if(x == null) {
            return null;
        }
        DoublyNode<T> newRearNode = new DoublyNode<>(x, head.prev, head);
        head.prev.next = newRearNode;
        head.prev = newRearNode;
        return newRearNode;
    }

    /**
     * 测试用，勿深究
     */
    @Override
    public String toString() {
        DoublyNode<T> temp = head;
        StringBuilder str = new StringBuilder("[");
        if(temp.next != head) {
            str.append(temp.next.toString());
            temp = temp.next;
        }
        while(temp.next != head) {
            str.append(", ");
            str.append(temp.next.toString());
            temp = temp.next;
        }
        str.append("]");
        return str.toString();
    }

}