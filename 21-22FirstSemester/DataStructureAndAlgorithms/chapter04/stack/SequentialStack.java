package chapter04.stack;

import chapter02.linearlist.sequential.SequentialList;

/**
 * 4.1.2栈的存储结构和实现（1）顺序栈
 */
public class SequentialStack<T> implements Stack<T> {

    private final SequentialList<T> seqList;

    /**
     * O(1)
     */
    public SequentialStack() {
        seqList = new SequentialList<>();
    }

    /**
     * O(1)
     */
    public SequentialStack(int length) {
        seqList = new SequentialList<>(length);
    }

    /**
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return seqList.isEmpty();
    }

    /**
     * O(N)
     */
    @Override
    public void push(T x) {
        seqList.insert(x);
    }

    /**
     * O(1)
     */
    @Override
    public T peek() {
        return seqList.get(seqList.size() - 1);
    }

    /**
     * O(N)
     */
    @Override
    public T pop() {
        return seqList.remove(seqList.size() - 1);
    }

    /**
     * O(1)
     */
    @Override
    public void clear() {
        seqList.clear();
    }

    /**
     * O(1)
     */
    public int size() {
        return seqList.size();
    }

    /**
     * 测试用，勿深究
     */
    @Override
    public String toString() {
        return seqList.toString();
    }
}
