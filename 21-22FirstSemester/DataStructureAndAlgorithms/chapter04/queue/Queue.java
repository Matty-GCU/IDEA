package chapter04.queue;

/**
 * @author Matty's PC
 */
public interface Queue<T> {

    boolean isEmpty();

    /**
     * enqueue
     */
    boolean add(T x);

    /**
     * dequeue
     */
    T poll();

    T peek();

}
