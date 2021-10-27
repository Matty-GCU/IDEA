package chapter04.stack;

import chapter02.linearlist.SinglyLinkedList;

/**
 * 4.1.2栈的存储结构和实现（2）链式栈
 */
public class LinkedStack<T> implements Stack<T>{

    private final SinglyLinkedList<T> singlyLinkedList;

    /**
     * O(1)
     */
    public LinkedStack() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    /**
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return singlyLinkedList.isEmpty();
    }

    /**
     * O(N)
     * 使用头插入、头删除可以极大地提高效率
     */
    @Override
    public void push(T x) {
        singlyLinkedList.insert(0, x);
    }

    /**
     * O(1)
     */
    @Override
    public T peek() {
        return singlyLinkedList.get(0);
    }

    /**
     * O(1)
     */
    @Override
    public T pop() {
        return singlyLinkedList.remove(0);
    }

    /**
     * O(1)
     */
    @Override
    public void clear() {
        singlyLinkedList.clear();
    }

    /**
     * 测试用，勿深究
     */
    @Override
    public String toString() {
        return singlyLinkedList.toString();
    }
}
