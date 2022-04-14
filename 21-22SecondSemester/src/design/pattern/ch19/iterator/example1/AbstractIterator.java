package design.pattern.ch19.iterator.example1;

public interface AbstractIterator {
    
    //正向遍历
    /**
     * 游标移至下一个元素
     */
    void next();
    
    /**
     * 获取下一个元素
     */
    Object getNextItem();
    
    /**
     * 是否为最后一个元素
     */
    boolean isLast();
    
    
    //逆向遍历
    /**
     * 游标移至上一个元素
     */
    void previous();
    
    /**
     * 是否为第一个元素
     */
    boolean isFirst();
    
    /**
     * 获取上一个元素
     */
    Object getPreviousItem();
}
