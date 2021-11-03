package chapter04.queue;

/**
 * 4.2.2队列的存储结构和实现
 * 顺序**循环**队列
 * 因为循环，所以指针（以front为例）前进1位不能用front++，要用(front + 1) % element.length
 * @author Matty's PC
 */
public class SeqQueue<T> implements Queue<T> {

    private Object[] element;
    private static final int MIN_CAPACITY = 16;
    private int size;
    /**
     * 队头元素下标都加上
     */
    private int front;

    /**
     * 下一个队尾元素下标
     */
    private int rear;

    public SeqQueue(int length) {
        if(length < MIN_CAPACITY) {
            length = MIN_CAPACITY;
        }
        element = new Object[length];
        front = rear = 0;
        size = 0;
    }

    public SeqQueue() {
        this(MIN_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isOutOfMemory() {
        return (rear + 1) % element.length == front;
    }

    @Override
    public boolean add(T x) {
        if(x == null) {
            return false;
        }
        //若队列满则扩容
        if(isOutOfMemory()) {
            Object[] oldArray = element;
            element = new Object[element.length * 2];
            int newRear = 0;
            for(int i = front; i != rear; i = (i + 1) % oldArray.length) {
                element[newRear++] = oldArray[i];
            }
            front = 0;
            rear = newRear;
        }
        element[rear] = x;
        rear = (rear + 1) % element.length;
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if(isEmpty()) {
            return null;
        }
        T temp = (T) element[front];
        front = (front + 1) % element.length;
        size--;
        return temp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        return isEmpty() ? null : (T) element[front];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(isEmpty()) {
            return "SeqQueue[]";
        }
        str.append("SeqQueue[");
        for(int i = front; i != rear; i = (i+1) % element.length) {
            str.append(element[i]);
            str.append(", ");
        }
        str.replace(str.length() - 2, str.length(), "");
        str.append("]");
        return str.toString();
    }
}
