package chapter04.stack;

public interface Stack<T> {
    boolean isEmpty();
    void push(T x);
    T peek();
    T pop();
    void clear();
}
