package test;

import dsaa.chapter9.section1.insertionsort.InsertionSortTest;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        int[] nums = new int[]{32, 26, 87, 72, 26, 17};
//        InsertionSortTest.straightSort(nums, true);
        int[] nums = new int[]{39, 55, 65, 97, 27, 76, 27, 13, 19};
        InsertionSortTest.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
