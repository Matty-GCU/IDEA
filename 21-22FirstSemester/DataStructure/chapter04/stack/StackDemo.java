package chapter04.stack;

public class StackDemo {
    public static void main(String[] args) {
        SequentialStack<Integer> s = new SequentialStack<>();
        System.out.println(s);
        s.push(0);
        s.push(11);
        s.push(22);
        s.push(33);
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
        LinkedStack<Integer> l = new LinkedStack<>();
        System.out.println(l);
        l.push(0);
        l.push(11);
        l.push(22);
        l.push(33);
        System.out.println(l);
        System.out.println(l.peek());
        System.out.println(l);
        System.out.println(l.pop());
        System.out.println(l);
    }
}
