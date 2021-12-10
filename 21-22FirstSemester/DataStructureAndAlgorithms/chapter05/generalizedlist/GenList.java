package chapter05.generalizedlist;

/**
 * ADT
 * @author Matty's PC
 */
public interface GenList<T> {

    /**
     * 判断是否为空表
     */
    boolean isEmpty();

    /**
     * 返回广义表长度
     */
    int size();

    /**
     * 返回广义表深度
     */
    int depth();

    /**
     * 返回第i个结点
     */
    GenNode<T> get(int i);

    /**
     * 插入原子x作为第i个结点
     */
    GenNode<T> insert(int i, T x);

    /**
     * 插入子表genList作为第i个结点
     */
    GenNode<T> insert(int i, GenListImpl<T> genList);

    /**
     * 删除第i个结点
     */
    GenNode<T> remove(int i);

    /**
     * 删除所有结点
     */
    void clear();

    /**
     * 查找并返回首个与key相等的原子结点
     */
    GenNode<T> search(T key);

    /**
     * 查找并删除首个与key相等的原子结点
     */
    GenNode<T> remove(T key);
}
