package chapter06.tree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        //例6.1（课本163页）二叉树的构造、遍历和插入
        Character[] characters = new Character[]{'A', 'B', 'D', null, 'G', null, null, null, 'C', 'E', null, null, 'F', 'H', null, null, null};
        BinaryTree<Character> binTree = new BinaryTree<>(characters);
        binTree.preOrder();
        binTree.inOrder();
        binTree.postOrder();
        binTree.preOrder2();
        binTree.levelOrder();
        System.out.println("二叉树广义表表示：" + binTree.toGenListString());
    }
}
