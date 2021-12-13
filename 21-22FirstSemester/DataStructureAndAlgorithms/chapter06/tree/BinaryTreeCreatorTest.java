package chapter06.tree;

public class BinaryTreeCreatorTest {
    public static void main(String[] args) {
        String genListStr = "A(B(D(^,G),^),C(E,F(H,^)))";
        BinaryTree<String> binaryTree = BinaryTreeCreator.createByGenListStr(genListStr);
        System.out.println(binaryTree.toGenListString());
    }
}
