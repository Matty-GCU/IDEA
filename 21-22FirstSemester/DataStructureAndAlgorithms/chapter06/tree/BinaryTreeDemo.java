package chapter06.tree;


public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.preorder();
        tree.insert(5);
    }
}
