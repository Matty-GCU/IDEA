package chapter06.tree;

public class Exp6 {
    public static void main(String[] args) {
        Character[] characters = new Character[]{'A', 'B', null, 'D', null, null, 'C', null, null};
        BinaryTree<Character> binaryTree = new BinaryTree<>(characters);
        binaryTree.preOrder();
        binaryTree.inOrder();
        binaryTree.postOrder();
        System.out.println(binaryTree);
        System.out.println("二叉树的高度：" + binaryTree.height());
        System.out.println("二叉树的结点总数为：" + binaryTree.size());
        System.out.println("二叉树的叶子结点总数为：" + binaryTree.leafSize());
    }
}
