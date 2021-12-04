package chapter05.generalizedlist;

/**
 * 广义表类
 * @author Matty's PC
 */
public class GenList<T> {

    /**
     * 头结点（若data不为空，则data为表名）
     */
    public GenNode<T> head;

    /**
     * 构造空广义表，无表名
     */
    public GenList() {
        this(null);
    }
    /**
     * 构造空广义表，data指定表名
     * @param name
     */
    public GenList(T name) {
        head = new GenNode<>(name, null, null);
    }

    //构造的是线性表（若广义表的所有元素都是原子，则它是线性表。详见课本142页）
    //public GenList(T name, T[] atoms) {}

    /**
     * 返回genList广义表的描述字符串
     * 【先遍历child子表，再遍历next后继结点】
     */
    public String toStringGenList(GenList<T> genList) {//这个递归有点麻烦，等写出测试用例再仔细测试
        //加上表名
        StringBuffer s = new StringBuffer();
        s.append(genList.head.data == null ? "" : genList.head.data.toString());
        s.append("(");
        //照这样子看，课本默认头结点无child；要从头结点的下一个结点开始，才会对child和next进行遍历。
        for(GenNode<T> p = genList.head.next; p != null; p = p.next) {
            s.append(toStringGenNode(p));
            s.append(p.next == null ? "" : ", ");
        }
        s.append(")");
        return s.toString();
    }

    /**
     * 返回p结点的描述字符串
     */
    public String toStringGenNode(GenNode<T> p) {//这个递归有点麻烦，等写出测试用例再仔细测试
        if(p == null) {
            return null;
        }
        return p.child == null ? p.data.toString() : toStringGenList(p.child);
    }

//    public int depth() {}
//    public GenNode<T> insert(int i, T x) {}
//    public GenNode<T> insert(T x) {}

    public GenNode<T> insert(int i, GenList<T> genList) {
        if(genList == null || this == genList) {
            return  null;
        }
        GenNode<T> front = head;
        for(int j = 0; front.next != null && j < i; j++) {
            front = front.next;
        }
        front.next = new GenNode<>(genList.head.data, genList, front.next);//这行如何理解？(A)插入(B)会变成(A(B(B)))吗？
        return null;
    }

}
