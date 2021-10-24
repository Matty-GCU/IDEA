package chapter01;

import java.util.HashSet;

public class Exp1Array {
    //输出对象数组元素吗，以空格分隔元素
    //时间复杂度O(N)
    public void print1(Integer[] arr) {
        System.out.print(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
    //输出对象数组元素，形式为“{,}”，以“,”分隔元素
    //时间复杂度O(N)
    public void print2(Integer[] arr) {
        System.out.print("{" + arr[0]);
        for(int i = 1; i < arr.length; i++) {
            System.out.print("," + arr[i]);
        }
        System.out.println("}");
    }
    //产生n个随机数（可重复），范围是0～size-1，返回整数对象数组
    //时间复杂度O(N)
    public Integer[] random1(int n, int size) {
        Integer[] randomNums = new Integer[n];
        for(int i = 0; i < randomNums.length; i++) {
            //自动装箱
            randomNums[i] = (int)(Math.random() * size);
        }
        return randomNums;
    }
    //产生n个随机数（可重复），范围是1～size-1，不包含0，返回整数对象数组
    //时间复杂度O(N)
    public Integer[] random2(int n, int size) {
        Integer[] randomNums = new Integer[n];
        for(int i = 0; i < randomNums.length; i++) {
            randomNums[i] = (int)(Math.random() * (size - 1)) + 1;
        }
        return randomNums;
    }
    //产生n个随机数（不可重复），范围是1～size-1，不包含0，返回整数对象数组
    //时间复杂度O(N)
    public Integer[] random3(int n, int size) {
        Integer[] randomNums = new Integer[n];
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < randomNums.length; i++) {
            while(true) {
                if(! hashSet.add(randomNums[i] = (int)(Math.random() * (size - 1)) + 1)) {
                    break;
                }
            }
        }
        return randomNums;
    }
}
