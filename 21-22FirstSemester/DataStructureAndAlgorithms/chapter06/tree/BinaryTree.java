package chapter06.tree;

import chapter04.queue.LinkedQueue;
import chapter04.queue.Queue;
import chapter04.stack.LinkedStack;
import chapter04.stack.Stack;

/**
 * @author Matty
 **/
public class BinaryTree<T> {

    public int size;

    public BinaryNode<T> root;

    public BinaryTree() {}

    /**
     * 以标明空子树的先根序列构建二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public BinaryTree(T[] prelist) {
        root = create(prelist);
    }
    private int i = 0;
    private BinaryNode<T> create(T[] prelist) {
        T data;
        if(i >= prelist.length || (data = prelist[i++]) == null) {
            return null;
        }
        BinaryNode<T> p = new BinaryNode<>(data);
        size++;
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
            size++;
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
    public void preOrder() {
        System.out.print("先根遍历二叉树：");
        preOrder(root);
        System.out.println();
    }
    private void preOrder(BinaryNode<T> p) {
        if(p != null) {
            System.out.print(p + "  ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    /**
     * 同上，先根遍历整个二叉树，不过用的是栈，没有递归
     * 已测试
     */
    public void preOrder2() {
        System.out.print("先根遍历二叉树（非递归、带空子树）：");
        Stack<BinaryNode<T>> stack = new LinkedStack<>();
        BinaryNode<T> p = root;
        //p不为空，说明p可以往下访问；
        //p为空，只要栈不为空，就可以pop给p，p往回访问
        while(p != null || !stack.isEmpty()) {
            //p不为空，说明当前结点可以作为“根”。
            //先根遍历就是“根->左->右”，那肯定先输出”根“，然后访问”左“
            if(p != null) {
                System.out.print(p);
                stack.push(p);
                p = p.left;
            }
            //p为空，说明当前结点是空结点，输出"^"
            //回到p的父树（如果stack里有的话），再进入父树的右子树
            else {
                System.out.print("^");
                p = stack.pop();
                p = p.right;
            }
        }
        //补上最后一次遍历p == null && stack.isEmpty()时的p
        System.out.println("^");
    }

    /**
     * 中根遍历（中序遍历）整个二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void inOrder() {
        System.out.print("中根遍历二叉树：");
        inOrder(root);
        System.out.println();
    }
    private void inOrder(BinaryNode<T> p) {
        if(p != null) {
            inOrder(p.left);
            System.out.print(p + "  ");
            inOrder(p.right);
        }
    }

    /**
     * 后根遍历（后序遍历）整个二叉树
     * 时间复杂度O(N)
     * 已测试
     */
    public void postOrder() {
        System.out.print("后根遍历二叉树：");
        postOrder(root);
        System.out.println();
    }
    private void postOrder(BinaryNode<T> p) {
        if(p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p + "  ");
        }
    }

    /**
     * 二叉树的层次遍历
     * 已测试
     */
    public void levelOrder() {
        Queue<BinaryNode<T>> queue = new LinkedQueue<>();
        queue.add(root);
        System.out.print("二叉树的层次遍历：");
        while(! queue.isEmpty()) {
            BinaryNode<T> p = queue.poll();
            System.out.print(p);
            if(p.left != null) {
                queue.add(p.left);
            }
            if(p.right != null) {
                queue.add(p.right);
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return toGenListString();
    }

    /**
     * 返回二叉树的广义表表示字符串
     * 已测试
     */
    public String toGenListString() {
        return "二叉树的广义表表示：" + toGenListString(root);
    }
    private String toGenListString(BinaryNode<T> p) {
        if(p == null) {
            return null;
        }
        if(p.left == null && p.right == null) {
            return p.toString();
        }
        return p.toString() + "(" + toGenListString(p.left) + ", " + toGenListString(p.right) + ")";
    }

    /**
     * 返回二叉树结点个数
     * 已测试
     */
    public int size() {
        return size;
    }

    /**
     * 返回二叉树叶子结点个数
     * 改编自preOrder2()的栈遍历
     * 已测试
     */
    public int leafSize() {
        Stack<BinaryNode<T>> stack = new LinkedStack<>();
        int leafSize = 0;
        BinaryNode<T> p = root;
        while(p != null || !stack.isEmpty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                if(p.right == null && p.left == null) {
                    leafSize++;
                }
                p = p.right;
            }
        }
        return leafSize;
    }

    /**
     * 返回二叉树高度
     * 改变自GenListImpl的depth()方法
     * 已测试
     * 二叉树的高度，其实就是该二叉树的作为广义表的深度+1
     */
    public int height() {
        String str = toString();
        int depth = 0;
        LinkedStack<Character> stack = new LinkedStack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push('(');
                depth = Math.max(stack.size(), depth);
            }
            else if(ch == ')') {
                stack.pop();
            }
        }
        return depth + 1;
    }

    
    //有一个insert和remove都还没测试，需要search方法支持
//    public BinaryNode<T> search(T key) {}

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

}
