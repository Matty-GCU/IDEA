package dsaa.ch09.section01;

import java.util.Arrays;

public class InsertionSortTest {

    /**
     * 直接插入排序
     */
    public static void straightSort(int[] keys, boolean asc) {
        //初始的已排序序列由第0个元素构成，所以从第1个元素开始遍历
        for(int i = 1; i < keys.length; i++) {
            int x = keys[i];
            int j;
            //若asc==true，则将已排序序列中比x大的元素都往后挪一位
            for(j = i - 1; j >= 0 && (asc ? keys[j] > x : keys[j] < x); j--) {
                keys[j + 1] = keys[j];
            }
            //若asc==true，退出上面那个循环时，j停在刚好小于等于x的元素上
            keys[j + 1] = x;
        }
    }

    /**
     * 希尔排序，又叫缩小增量排序
     * 是对直接插入排序的改进。
     * 这个算法强烈建议看书看图+画图！否则太绕！
     */
    public static void shellSort(int[] keys) {
        //若干轮
        for(int gap = keys.length / 2; gap > 0; gap /= 2) {
            //若干组（gap刚好是第一组的第二个元素）
            for(int i = gap; i < keys.length; i++) {
                //组内有若干元素，对这些元素进行直接插入排序
                int x = keys[i];    //待插入元素下标
                int j = i - gap;    //已排序序列的最后一个元素下标
                while(j >= 0 && keys[j] > x) {
                    keys[j + gap] = keys[j];
                    j -= gap;
                }
                keys[j + gap] = x;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{32, 26, 87, 72, 26, 17};
        straightSort(nums, true);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{39, 55, 65, 97, 27, 76, 27, 13, 19};
        InsertionSortTest.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
