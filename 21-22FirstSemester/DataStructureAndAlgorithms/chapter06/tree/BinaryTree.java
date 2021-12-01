package chapter06.tree;

/**
 * @author Matty
 **/
public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {}

    public BinaryTree(String s5r) {

    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 插入结点X情况1：原根节点作为X的左孩子，X作为根节点（见课本图6-7(a)）
     * 时间复杂度O(1)
     */
    public void insert(T x) {
        if(x != null) {
            root = new BinaryNode<>(x, root, null);
        }
    }

    /**
     * 插入结点X情况2：X作为指定结点p的左或右孩子，原结点的原左或右结点作为X的左或右结点（见课本图6-7(b)）
     * 时间复杂度O(1)
     */
    public BinaryNode<T> insert(BinaryNode<T> p, boolean asLeft, T x) {
        if(p == null || x == null) {
            return null;
        }
        if(asLeft) {
            return p.left = new BinaryNode<>(x, p.left, null);
        }
        return p.left = new BinaryNode<>(x, p.left, null);
    }

    /**
     * 删除指定结点的左子树或右子树
     * 时间复杂度O(1)
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
     */
    public void clear() {
        root = null;
    }

    /**
     * 先根遍历（前序遍历）整个二叉树
     * 时间复杂度O(N)
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * 先根遍历（前序遍历）特定二叉树
     * 时间复杂度O(N)
     */
    public void preorder(BinaryNode<T> p) {
        if(p != null) {
            System.out.println(p);
            preorder(p.left);
            preorder(p.right);
        }
    }

    /**
     * 中根遍历（中序遍历）整个二叉树
     * 时间复杂度O(N)
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * 中根遍历（中序遍历）特定二叉树
     * 时间复杂度O(N)
     */
    public void inorder(BinaryNode<T> p) {
        if(p != null) {
            inorder(p.left);
            System.out.println(p);
            inorder(p.right);
        }
    }

    /**
     * 后根遍历（后序遍历）整个二叉树
     * 时间复杂度O(N)
     */
    public void postorder() {
        postorder(root);
    }

    /**
     * 后根遍历（后序遍历）特定二叉树
     * 时间复杂度O(N)
     */
    public void postorder(BinaryNode<T> p) {
        if(p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p);
        }
    }

//    public int size() {
//
//    }

}
