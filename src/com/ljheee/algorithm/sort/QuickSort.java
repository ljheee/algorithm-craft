package com.ljheee.algorithm.sort;

import java.util.Arrays;

/**
 * 快排
 * O(N*logN)
 */
public class QuickSort {

    public static void sort(int[] data, int left, int right) {

        int ll = left;  //记录当前左边 位置
        int rr = right; //记录当前右边 位置
        int base = data[left];  //当前base

        while (ll < rr) {

            // 从右边开始找 第一个小于base的数
            while (ll < rr && data[rr] >= base) {       // 大于就跳过
                rr--;
            }
            if (ll < rr) {  //找到了，交换
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                ll++;
            }

            // 从左边找 第一个大于base的数
            while (ll < rr && data[ll] <= base) {       // 小于就跳过
                ll++;
            }
            if (ll < rr) {  //找到了
                int temp = data[rr];
                data[rr] = data[ll];
                data[ll] = temp;
                rr--;
            }
        }

//        System.out.println(Arrays.toString(data));
        if (left < ll) {
            sort(data, left, ll - 1);
        }
        if (ll < right) {
            sort(data, ll + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {45, 28, 80, 90, 50, 16, 100, 10};
        sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
