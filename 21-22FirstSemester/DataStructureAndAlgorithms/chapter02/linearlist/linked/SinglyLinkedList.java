package chapter02.linearlist.linked;

/**
 * 2.3线性表的链式存储结构和实现
 * 非循环 单链表
 */
public class SinglyLinkedList<T> {

    /**
     * 头指针
     */
    public Node<T> head;

    int size = 0;

    /**
     * 构造只有头结点的空链表
     * 已测试
     * O(1)
     */
    public SinglyLinkedList() {
        //头指针指向头结点
        head = new Node<>();
    }

    /**
     * 已测试
     * O(N)
     */
    public SinglyLinkedList(T[] values) {
        this();
        //尾指针
        Node<T> rear = head;
        int i = 0;
        for(T data: values) {
            if(data != null) {
                rear.next = new Node<>(data, null);
                rear = rear.next;
                i++;
            }
        }
        size = i;
    }

    /**
     * 已测试
     * O(1)
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 已测试
     * O(N)
     */
    public T get(int i) {
        //”链表简单遍历“：p指向第0个结点，查找下标为i的结点
        Node<T> p = head.next;
        for(int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        return (i>=0 && p!=null) ? p.data : null;
    }

    /**
     * 这个方法课本省略，所以是原创
     * 已测试
     * O(N)
     */
    public void set(int i, T x) {
        Node<T> p = head.next;
        //”链表简单遍历“：p指向第0个结点，查找下标为i的结点
        for(int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        if(i < 0 || x == null || p == null) {
            return;
        }
        p.data = x;
    }

    /**
     * 这个方法课本省略，所以是原创
     * 已测试
     * O(1)
     */
    public int size() {
        return size;
    }

    /**
     * 已测试
     * O(N)
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(getClass().getSimpleName());
        str.append("(");
        if(head.next == null) {
            str.append(")");
            return str.toString();
        }
        for(Node<T> p = head.next; p != null; p = p.next) {
            str.append(p.data.toString());
            str.append(p.next != null ? ", " : ")");
        }
        return str.toString();
    }

    /**
     * 已测试
     * O(N)
     */
    public Node<T> insert(int i, T x) {
        if(x == null) {
            return null;
        }
        //front指向头结点，查找下标为i-1的结点（若i=0则找到头结点）或最后一个结点
        Node<T> front = head;
        for(int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        //为什么不能这样写？因为不支持空表插入(此时front是null，会报空指针异常)
//        Node<T> front = head.next;
//        for(int j = 0; front.next != null && j < i-1; j++) {
//            front = front.next;
//        }
        front.next = new Node<>(x, front.next);
        size++;
        return front.next;
    }

    /**
     * 已测试
     * O(N)
     */
    public Node<T> insert(T x) {
        return insert(Integer.MAX_VALUE, x);
    }

    /**
     * 已测试
     * O(1)
     */
    public void clear() {
        head.next = null;
        size = 0;
    }

    /**
     * 算法不可抄，写完再对照。（从这里开始）
     * 已测试
     * O(N)
     */
    public T remove(int i) {
        //同insert遍历，找到第i-1个结点
        Node<T> front = head;
        for(int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        if(i >= 0 && front.next != null) {
            T x = front.next.data;
            front.next = front.next.next;
            size--;
            return x;
        }
        return null;
    }

    /**
     * 原创
     * 已测试
     * O(N)
     */
    public T remove(T key) {
        Node<T> front = head;
        while(front != null && front.next != null) {
            if(front.next.data.equals(key)) {
                T x = front.next.data;
                front.next = front.next.next;
                size--;
                return x;
            }
            front = front.next;
        }
        return null;
    }

    /**
     * 原创
     * 已测试
     * O(N)
     */
    public Node<T> search(T key) {
        Node<T> p = head.next;
        //顺序查找并返回首个与key相同的元素
        while(p != null) {
            if(p.data.equals(key)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

}
