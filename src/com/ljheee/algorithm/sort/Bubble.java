package com.ljheee.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * O(n^2)
 */
public class Bubble {

    public static void bubble(int[] data) {

        for (int i = 0, len = data.length; i < len - 1; i++) {  //第一次for用于控制循环次数，n个数，比较n趟，由于第一个数不用比较、所有n-1
            for (int j = 0; j < len - 1 - i; j++) {     //两两比较
                if (data[j] > data[j + 1]) {
                    //swap();
                    data[j] = data[j] + data[j + 1];
                    data[j + 1] = data[j] - data[j + 1];
                    data[j] = data[j] - data[j + 1];
                }
            }
        }
    }

    private static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }


    public static void main(String[] args) {
        int[] data = {1, 4, 7, 0, 3, 9};
        bubble(data);
        System.out.println(Arrays.toString(data));
    }

}
