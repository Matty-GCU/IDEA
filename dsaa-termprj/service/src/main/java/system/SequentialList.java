package system;

/**
 * 2.2线性表的顺序存储结构和实现
 * 记得把没用的方法、注释删掉！！
 */
public class SequentialList<T> {
    
    private int size;
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 16;
    
    /**
     * O(1)
     */
    public SequentialList(int length) {
        if(length < DEFAULT_CAPACITY) {
            length = DEFAULT_CAPACITY;
        }
        elementData = new Object[length];
        size = 0;
    }
    
    /**
     * O(1)
     */
    public SequentialList() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * O(1)
     */
    public int size() {
        return size;
    }
    
    /**
     * O(1)
     */
    @SuppressWarnings("unchecked")
    public T get(int i) {
        if(i >= 0 && i < size) {
            return (T) elementData[i];
        }
        return null;
    }
    
    /**
     * 时间复杂度：O(N)
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.getClass().getSimpleName());
        str.append("(");
        if(size > 0) {
            str.append(elementData[0]);
        }
        for(int i = 1; i < size; i++) {
            str.append(",");
            str.append(elementData[i]);
        }
        str.append(")");
        return str.toString();
    }
    
    /**
     * 时间复杂度：O(N)
     * @param i 试图插入的位置
     * @return 实际插入的位置
     */
    public int insert(int i, T x) {
        if(x == null) {
            return -1;
        }
        if(i < 0) {
            i = 0;
        }
        else if(i > size) {
            i = size;
        }
        Object[] source = elementData;
        //自动扩容
        if(size == elementData.length) {
            elementData = new Object[source.length * 2];
            for(int j = 0; j < i; j++) {
                elementData[j] = source[j];
            }
        }
        for(int j = i; j < size; j++) {
            elementData[j + 1] = source[j];
        }
        elementData[i] = x;
        size++;
        return i;
    }
    
    public void insert(T x) {
        insert(size, x);
    }
    
    /**
     * 时间复杂度：O(N)
     * @param i 要删除的元素所在下标
     * @return 被删除的元素
     */
    @SuppressWarnings("unchecked")
    public T remove(int i) {
        if(i >= 0 && i < size) {
            T x = (T) elementData[i];
            for(int j = i; j < size - 1; j++) {
                elementData[j] = elementData[j + 1];
            }
            elementData[size - 1] = null;
            size--;
            return x;
        }
        return null;
    }
    
    /**
     * O(N)
     */
    public int indexOf(T key) {
        for(int i = 0; i < size; i++) {
            if(elementData[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
    
}
