package com.ljheee.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 此实现 是大顶堆
 * https://zhuanlan.zhihu.com/p/83247978
 */
public class HeapSort {

    //声明全局变量，用于记录数组array的长度；
    static int len;


    public static int[] heapSort(int[] array) {
        len = array.length;
        if (len <= 1) {
            return array;
        }

        //1.构建一个最大堆
        buildMaxHeap(array);

        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }


    private static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    /**
     * 调整使之成为最大堆
     * 就是比较 array[i]、array[2*i]、array[2*i+1] 当前子树：根节点 及其左右孩子节点，找出最大值，当做子树的根
     *
     * @param array
     * @param i
     */
    private static void adjustHeap(int[] array, int i) {

        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (2 * i < len && array[2 * i] > array[maxIndex]) {
            maxIndex = 2 * i;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (2 * i + 1 < len && array[2 * i + 1] > array[maxIndex]) {
            maxIndex = 2 * i + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    private static void swap(int[] array, int a, int b) {
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }


    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 0, 10, 22, 11};
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));//[5, 2, 1, 9, 0, 10, 22, 11]

        System.out.println(Arrays.toString(heapSort(arr)));//[0, 1, 2, 5, 9, 10, 11, 22]
    }
}
