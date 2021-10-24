package model;

import java.util.ArrayList;

/**
 * 基于{@code ArrayList<Integer>}的基础集合类。
 * 这是一个有限集，集合元素按照升序排列。
 * @author Matty
 * @version 1.0
 */
public class BasicSet extends ArrayList<Integer> {

    /**
     * 自动计算合适的插入位置，为集合添加（插入）一个元素，使集合元素仍然保持升序。
     * 建议手动按照升序添加元素，以提高计算速度。
     * @param element 将要添加的元素
     * @return 如果添加成功，则返回true；如果集合中已经有该元素，则返回false。
     */
    @Override
    public boolean add(Integer element) {
        if(contains(element)) {
            return false;
        }
        if(size() == 0) {
            return super.add(element);
        }
        else if(element < get(0)) {
            super.add(0, element);
            return true;
        }
        else if(element > get(size() - 1)) {
            return super.add(element);
        }
        else {
            int low = 0;
            int high = size() - 1;
            int mid = (high + low) / 2;
            while(low < mid) {
                if(element > get(mid)) {
                    low = mid;
                }
                else {
                    high = mid;
                }
                mid = (low + high) / 2;
            }
            super.add(high, element);
            return true;
        }
    }

    /**
     * 返回一个表示集合内容的String对象。
     * @return 一个表示集合内容的String对象。例如："{1,2,3}"
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{" + get(0));
        for(int i = 1; i < size(); i++) {
            str.append(", ");
            str.append(get(i));
        }
        str.append("}");
        return str.toString();
    }

}
