package chapter06.tree;

/**
 * @author Matty
 **/
public class BinaryTree<T> {

    public BinaryNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 照着课本写的，暂时不知道为什么要这样设计：插入结点
     */
    public void insert(T x) {
        if(x != null) {
            root = new BinaryNode<>(x, root.left, null);
        }
    }
}
