package com.ljheee.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序：分治+二路归并
 */
public class BinaryMergeSort {


    public static void mergeSort(int[] data, int left, int right) {

        if (left < right) {
            // 拆分的过程
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);

            // 归并的过程
            merge(data, left, mid, right);
        }
    }


    public static void merge(int[] data, int left, int mid, int right) {

        //开辟临时数组
        int[] temp = new int[data.length];

        int point1 = left;//最左指针
        int point2 = mid + 1;//最右指针

        int pos = left;
        while (point1 <= mid && point2 <= right) {
            if (data[point1] <= data[point2]) {
                temp[pos] = data[point1];
                point1++;
                pos++;
            } else {
                temp[pos] = data[point2];
                point2++;
                pos++;
            }
        }

        // 完成剩下的
        while (point1 <= mid) {
            temp[pos++] = data[point1++];
        }

        while (point2 <= right) {
            temp[pos++] = data[point2++];
        }

        // 把临时数组有序的数据 赋给data；也可直接返回temp
        for (int i = left; i <= right; i++) {
            data[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[] data = {5, 9, 6, 8, 0, 3, 1, 7};

        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }


}
