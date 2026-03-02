package com.ljheee.algorithm.sort;

/**
 * Created by lijianhua04 on 2018/8/19.
 */
public class MergeSort {

    /**
     * 归并排序
     * 将2个有序数组  归并排序
     *
     * @param leftArray
     * @param rightArray
     * @return
     */
    public int[] merge(int[] leftArray, int[] rightArray) {

        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int mergedArrayPos = 0;
        int leftArrayPos = 0;
        int rightArrayPos = 0;

        while (leftArrayPos < leftArray.length && rightArrayPos < rightArray.length) {

            if (leftArray[leftArrayPos] <= rightArray[rightArrayPos]) {
                mergedArray[mergedArrayPos] = leftArray[leftArrayPos];
                leftArrayPos++;
            } else {
                mergedArray[mergedArrayPos] = rightArray[rightArrayPos];
                rightArrayPos++;
            }
            mergedArrayPos++;
        }

        //如果 还有剩余的
        while (leftArrayPos < leftArray.length) {
            mergedArray[mergedArrayPos] = leftArray[leftArrayPos];
            leftArrayPos++;
            mergedArrayPos++;
        }

        while (rightArrayPos < rightArray.length) {
            mergedArray[mergedArrayPos] = rightArray[rightArrayPos];
            rightArrayPos++;
            mergedArrayPos++;
        }
        return mergedArray;
    }


    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 4};
        int[] a2 = new int[]{2, 5, 6};

        int[] merge = new MergeSort().merge(a1, a2);

        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i]);
        }
    }


}
