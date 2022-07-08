package com.ljheee.algorithm.math;

import java.util.Arrays;

/**
 * 正整数n，分解成两个数相乘，和最小
 */
public class DevideTwoNumWithMinSum {


    /**
     * 暴力法
     * 分别尝试1~Math.sqrt(n)
     *
     * @param n
     * @return
     */
    public static int[] devideTwoNum0(int n) {
        int sqrt = (int) Math.sqrt(n);
        int a = 1, b = n;
        int minSum = 1 + n;
        for (int i = a; i <= sqrt; i++) {
            if (n % i == 0) {
                a = i;
                b = n / a;
                if (a + b < minSum) {
                    minSum = a + b;
                }
            }
        }
        return new int[]{a, b};
    }

    /**
     * a,b应该越接近 Math.sqrt(n) 越好
     * a从Math.sqrt(n) 倒序开始找，第一个能除尽的，a,b和最小
     *
     * @param n
     * @return
     */
    public static int[] devideTwoNum(int n) {
        int sqrt = (int) Math.sqrt(n);
        int a = 1, b = n;

        for (int i = sqrt; i >= 1; i--) {
            if (n % i == 0) {
                a = i;
                b = n / i;
                break;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(8));//2~2
        System.out.println(Math.sqrt(12));//3~4
        System.out.println(Math.sqrt(120));//10~4
        System.out.println(Math.sqrt(160));//10~4


        System.out.println(Arrays.toString(devideTwoNum(400)));


        for (int i = 0; i < 10000; i++) {
            int[] twoNum = devideTwoNum(i);
            int[] twoNum0 = devideTwoNum0(i);
            if (twoNum[0] != twoNum0[0] || twoNum[1] != twoNum0[1]) {
                System.out.println("oops=" + i);
            }
        }
    }
}
