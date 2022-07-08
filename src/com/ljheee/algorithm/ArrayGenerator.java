package com.ljheee.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by lijianhua04 on 2020/5/6.
 */
public class ArrayGenerator {

    static ThreadLocalRandom random = ThreadLocalRandom.current();


    public static int randomPositive(int bound) {
        return random.nextInt(0, bound);
    }


    public static int randomNegative(int bound) {
        return random.nextInt(-bound, bound);
    }

    public static int[] generateRangeArray(int size) {
        int[] arr = new int[size + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        shuffle(arr);
        return arr;
    }

    //经典洗牌算法
    public static void shuffle(int[] a) {
        Random random = new Random();
        int n = a.length;
        for (int i = n - 1; i >= 1; i--) {
            int temp = a[i];
            int j = random.nextInt(n);
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static int[] generateRandomArray(int size, int beginRange, int endRange) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(beginRange, endRange);
        }
        return arr;
    }

    /**
     * 指定范围，生成非重复的数
     *
     * @param size
     * @param beginRange
     * @param endRange
     * @return
     */
    public static int[] generateDistinctArray(int size, int beginRange, int endRange) {
        int[] arr = new int[size];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ) {
            int nextInt = random.nextInt(beginRange, endRange);
            if (set.add(nextInt)) {
                arr[i++] = nextInt;
            }
        }
        return arr;
    }

    public static int[] distinctSortedArray(int size, int beginRange, int endRange) {
        int[] array = generateDistinctArray(size, beginRange, endRange);
        Arrays.sort(array);
        return array;
    }

    /**
     * 生成 0 1二进制串
     *
     * @param size
     * @return
     */
    public static int[] generateBinaryArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; ) {
            int nextInt = random.nextInt(0, 2);
            arr[i++] = nextInt;
        }
        return arr;
    }

    public static int[] randomSortedArray(int size, int beginRange, int endRange) {
        int[] array = generateRandomArray(size, beginRange, endRange);
        Arrays.sort(array);
        return array;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRangeArray(8)));
    }


}
