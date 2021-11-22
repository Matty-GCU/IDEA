package chapter06.tree;

/**
 * @author Matty
 **/
public class BinaryNode<T> {

    public T data;
    public BinaryNode<T> left, right;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
