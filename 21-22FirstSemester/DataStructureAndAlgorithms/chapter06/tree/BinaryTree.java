package chapter06.tree;

/**
 * @author Matty
 **/
public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {}

    /**
     * 以标明空子树的先根序列构建二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public BinaryTree(T[] prelist) {
        root = create(prelist);
    }

    /**
     * 已测试
     */
    private int i = 0;
    private BinaryNode<T> create(T[] prelist) {
        T data;
        if(i >= prelist.length || (data = prelist[i++]) == null) {
            return null;
        }
        BinaryNode<T> p = new BinaryNode<>(data);
        p.left = create(prelist);
        p.right = create(prelist);
        return p;
    }

    /**
     * 已测试
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 插入结点X情况1：原根节点作为X的左孩子，X作为根节点（见课本图6-7(a)）
     * 时间复杂度O(1)
     * 已测试
     */
    public void insert(T x) {
        if(x != null) {
            root = new BinaryNode<>(x, root, null);
        }
    }

    /**
     * 插入结点X情况2：X作为指定结点p的左或右孩子，原结点的原左或右结点作为X的左或右结点（见课本图6-7(b)）
     * 时间复杂度O(1)
     *                          未测试（没有获取特定结点引用的方法，根本没法对特定结点进行操作）
     */
    public BinaryNode<T> insert(BinaryNode<T> p, boolean asLeft, T x) {
        if(p == null || x == null) {
            return null;
        }
        return asLeft ? (p.left = new BinaryNode<>(x, p.left, null)) : (p.right = new BinaryNode<>(x, p.right, null));
    }

    /**
     * 删除指定结点的左子树或右子树
     * 时间复杂度O(1)
     *                          未测试（没有获取特定结点引用的方法，根本没法对特定结点进行操作）
     */
    public void remove(BinaryNode<T> p, boolean removeLeft) {
        if(p != null) {
            if(removeLeft) {
                p.left = null;
            }
            else {
                p.right = null;
            }
        }
    }

    /**
     * 删除二叉树所有结点，包括根结点
     * 时间复杂度O(1)
     * 已测试
     */
    public void clear() {
        root = null;
    }

    /**
     * 先根遍历（前序遍历）整个二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void preorder() {
        System.out.println();
        preorder(root);
    }

    /**
     * 先根遍历（前序遍历）特定二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void preorder(BinaryNode<T> p) {
        if(p != null) {
            System.out.print(p + "  ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    /**
     * 中根遍历（中序遍历）整个二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void inorder() {
        System.out.println();
        inorder(root);
    }

    /**
     * 中根遍历（中序遍历）特定二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void inorder(BinaryNode<T> p) {
        if(p != null) {
            inorder(p.left);
            System.out.print(p + "  ");
            inorder(p.right);
        }
    }

    /**
     * 后根遍历（后序遍历）整个二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void postorder() {
        System.out.println();
        postorder(root);
    }

    /**
     * 后根遍历（后序遍历）特定二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void postorder(BinaryNode<T> p) {
        if(p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p + "  ");
        }
    }

    //实验6要求：实现对生成的二叉树进行前序、中序、后序遍历，计算高度、节点总数、叶子节点数。
    //有一个insert和remove都还没测试
//    public int size() {
//    }

}
