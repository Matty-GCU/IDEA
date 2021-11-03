package chapter04.queue;

import chapter02.linearlist.linked.Node;

/**
 * 4.2.2队列的存储结构和实现
 * 链式队列
 * 维护一个尾指针，以保证入队出队的时间复杂度都为O(1)。那为什么不用循环双链表？
 * @author Matty's PC
 */
public class LinkedQueue<T> {

    /**
     * 头指针指向队头
     */
    private Node<T> front;

    /**
     * 头指针指向队尾
     */
    private Node<T> rear;

    public LinkedQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null && rear ==null;
    }

    /**
     * 已测试
     */
    public boolean add(T x) {
        if(x == null) {
            return false;
        }
        Node<T> newNode = new Node<>(x, null);
        if(isEmpty()) {
            front = newNode;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
        return true;
    }

    /**
     * 从这一行以下，都是不看书写的
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(isEmpty()) {
            return "LinkedQueue[]";
        }
        str.append("LinkedQueue[");
        Node node = front;
        while(node != null) {
            str.append(node.toString()).append(", ");
            node = node.next;
        }
        str.replace(str.length() - 2, str.length(), "");
        str.append("]");
        return str.toString();
    }

    int size = 0;

    public int getSize() {
        return size;
    }

    public T peek() {
        return rear.data;
    }

    public T poll() {
        T oldNodeData = peek();
        if(isEmpty()) {
            return null;
        }
        else {
            //TODO
            return null;
        }
    }

}
