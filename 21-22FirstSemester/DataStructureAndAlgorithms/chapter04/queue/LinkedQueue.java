package chapter04.queue;

import chapter02.linearlist.linked.Node;

/**
 * 4.2.2队列的存储结构和实现
 * 链式队列
 * 维护一个尾指针，以保证入队出队的时间复杂度都为O(1)。那为什么不用循环双链表？
 * @author Matty's PC
 */
public class LinkedQueue<T> implements Queue<T> {

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

    @Override
    public boolean isEmpty() {
        return front == null && rear ==null;
    }

    /**
     * 已测试
     */
    @Override
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
        Node<T> node = front;
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

    @Override
    public T peek() {
        return front.data;
    }

    @Override
    public T poll() {
        //队列为空
        if(isEmpty()) {
            return null;
        }
        T oldFrontData = peek();
        //队列只有一个元素
        if(front == rear) {
            front = rear = null;
        }
        //队列超过两个元素
        else {
            front = front.next;
        }
        size--;
        return oldFrontData;
    }

}
