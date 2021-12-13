package chapter06.tree;

/**
 * 由广义表表示字符串构造的只能是BinaryTree<String>二叉树对象，不能构造BinaryTree<T>对象。
 * 因此，只能在BinaryTree<T>类之外，给出补充方法。
 */
public class BinaryTreeCreator {

    /**
     * 根据二叉树的广义表表示构建String型二叉树
     * 已测试
     */
    private static int size;
    private static int i;
    public static BinaryTree<String> createByGenListStr(String genList) {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        size = 0;
        i = 0;
        binaryTree.root = create(genList);
        binaryTree.size = size;
        return binaryTree;
    }
    private static BinaryNode<String> create(String genList) {
        BinaryNode<String> p = null;
        if(i < genList.length()) {
            //取到当前字符之后，下标马上后移一位
            char ch = genList.charAt(i);
            i++;
            //遇到'^'说明当前结点不存在
            if(ch == '^') {
                return null;
            }
            //没有遇到'^'说明，当前结点存在。（可能还有子树）
            p = new BinaryNode<>(ch + "");
            size++;
            //遇到'('说明当前结点有子树。（可能只有左子树或右子树，也可能都有）
            if(i < genList.length() && genList.charAt(i) == '(') {
                i++;    //跳过'('
                p.left = create(genList);
                i++;    //跳过','
                p.right = create(genList);
                i++;    //跳过')'
            }
            //没有遇到'('说明当前结点是叶子结点，无子树
        }
        return p;
    }
}
