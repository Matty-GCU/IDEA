package chapter05.generalizedlist;

/**
 * 广义表类
 * @author Matty's PC
 */
public class GenListImpl<T> {

    /**
     * 广义表长度
     */
    int size;

    /**
     * 头结点（若data不为空，则data为表名）
     */
    public GenNode<T> head;

    /**
     * 构造空广义表，data指定表名
     * 已测试
     */
    public GenListImpl(T name) {
        head = new GenNode<>(name, null, null);
        size = 0;
    }

    /**
     * 构造的是线性表（若广义表的所有元素都是原子，则它是线性表）
     * 构造方法仿照SinglyLinkedList
     * 不用测试
     */
    public GenListImpl(T name, T[] atoms) {
        this(name);
        GenNode<T> p = head;
        size = 0;
        for(T t: atoms) {
            if(t != null) {
                p.next = new GenNode<>(t, null, null);
                p = p.next;
                size++;
            }
        }
    }

    /**
     * 返回genList广义表的描述字符串
     * 先遍历child子表，再遍历next后继结点
     * 已测试
     */
    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(head.data == null ? "" : head.data.toString());
        strBuild.append("(");
        //头结点head是原子结点，无child，它的data是表名，next指向表中第一个结点
        //要从第一个结点head.next开始，才会对child和next进行遍历。
        for(GenNode<T> node = head.next; node != null; node = node.next) {
            strBuild.append(node);
            strBuild.append(node.next == null ? "" : ", ");
        }
        strBuild.append(")");
        return strBuild.toString();
    }


    /**
     * 判断是否为空表
     * 无需测试，直接参照SinglyLinkedList
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 返回广义表长度
     * 无需测试，直接参照SinglyLinkedList
     */
    public int size() {
        return size;
    }

    /**
     * 删除所有结点
     * 无需测试，直接参照SinglyLinkedList
     */
    public void clear() {
        head.next = null;
        size = 0;
    }




    /////////////////////////////////////
    public int depth() {
        return 0;
    }
    ////////////////////////////



    
    /**
     * 插入子表genList作为第i个结点
     * 已测试
     */
    public GenNode<T> insert(int i, GenListImpl<T> genList) {
        if(genList == null || this == genList) {
            return  null;
        }
        //这个遍历可以参照SinglyLinkedList，其实，完全一样。就是找到第i-1个结点或最后一个结点
        GenNode<T> front = head;
        for(int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        //下面这行如何理解？A(a)头插入B(b)会变成A(B(B(b)), a)吗？
        //答案是不会！请注意GenNode的toString()方法。
        front.next = new GenNode<>(genList.head.data, genList, front.next);
        return front.next;
    }

    //以下方法都是把广义表当单链表来处理，过程非常非常非常相似，不再实现。详见chapter02.linearlist.linked.SinglyLinkedList
//    public GenNode<T> get(int i) {}   //返回第i个结点
//    public GenNode<T> insert(int i, T x) {}   //插入原子x作为第i个结点
//    public GenNode<T> remove(int i) {}    //删除第i个结点
//    public GenNode<T> remove(T key) {}    //查找并删除首个与key相等的原子结点
//    public GenNode<T> search(T key) {}    //查找并返回首个与key相等的原子结点

}
