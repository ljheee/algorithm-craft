package com.ljheee.algorithm.string.rolling_hash;

/**
 * 滚动hash
 * 寻找最长的回文前缀
 * https://leetcode.com/problems/shortest-palindrome/submissions/
 */
public class RollingHash {

    /**
     * 最大回文前缀
     * <p>
     * 滚动hash：
     * 重点是两个hash函数
     * long hash1 = 0, hash2 = 0;
     * hash1 = hash1 * base + a[i];
     * hash2 = hash2 + a[i]*base^[0~n];
     * <p>
     * 子串相等，hash值一定相等。
     *
     * @param arr
     */
    public static void maxPalindromePrefix(int[] arr) {
        int n = arr.length, pos = -1;

        long base = 10, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * base) {
            hash1 = (hash1 * base + arr[i]);
            hash2 = (hash2 + arr[i] * POW);
            if (hash1 == hash2) {
                pos = i;
            }
        }

        System.out.println("maxPalindromePrefix end of pos: " + pos);
    }


    public static void main(String[] args) {
        maxPalindromePrefix(new int[]{1, 2, 1, 5});
        maxPalindromePrefix(new int[]{1, 2, 2, 2, 1, 8});
        maxPalindromePrefix(new int[]{2, 2, 1, 5, 1, 2, 2, 0});
    }


}
