package com.ljheee.algorithm.math;

/**
 * 实现Math.sqrt(n)
 * 二分查找 https://segmentfault.com/a/1190000016825704#item-2
 * <p>
 * Created by lijianhua04 on 2020/6/9.
 */
public class Sqrt {


    public static void main(String[] args) {

        System.out.println(mqSqrt(9));
        System.out.println(mqSqrt(12));

        Math.sqrt(12);
    }


    public static double mqSqrt(int n) {
        if (n <= 1) return 1;

        int low = 1;
        int high = n - 1;

        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (mid * mid == n) {
                return mid;
            } else if ((mid * mid > n)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }

}
