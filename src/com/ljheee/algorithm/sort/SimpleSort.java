package com.ljheee.algorithm.sort;

import com.ljheee.algorithm.ArrayGenerator;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lijianhua.
 */
public class SimpleSort {


    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minValueIndex = i;
            for (int j = i; j < length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) swap(arr, j - 1, j);
            }
        }
    }


    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j + 1] < arr[j]) swap(arr, j + 1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 120000; i++) {
            int[] array = ArrayGenerator.generateRandomArray(20, -10, 30);
            int[] clone = array.clone();

            insertionSort(array);
            Arrays.sort(clone);
            if (!Objects.equals(Arrays.toString(array), Arrays.toString(clone))) {
                System.out.println(Arrays.toString(array));
            }
        }

    }


}
