package com.ljheee.algorithm.string;

import java.util.Arrays;

/**
 * Created by lijianhua04 on 2020/4/8.
 */
public class SimpleKMP {




    private static String kmp(String t, String p) {

        int[] next = new int[p.length()];
        calculateNext(next, p);

        System.out.println(Arrays.toString(next));
        GetNext(p, next);
        System.out.println(Arrays.toString(next));

        return t;
    }

    /**
     * 一次性计算完 next
     * 时间复杂度O(n^2)
     * <p>
     * "算法的关键在于next数组的生成,用动态规范法生成"
     *
     * @param next
     * @param p
     */
    private static void calculateNext(int[] next, String p) {
        next[0] = 0;
        int length = p.length();

        for (int i = 1; i < length; i++) {
            int left = 0;
            int right = i;

            while (right > 0) {
                if (p.substring(0, left + 1).equals(p.substring(right, i + 1))) {
                    next[i] = left + 1;
                }
                left++;
                right--;
            }

        }
    }


    /**
     * O(n)的方法
     * https://segmentfault.com/a/1190000008575379
     *
     * @param P
     * @param next
     */
    static void GetNext(String P, int next[]) {
        int p_len = P.length();

        next = new int[p_len + 1];
        int i = 0;   // P 的下标
        int j = -1;
        next[0] = -1;

        while (i < p_len) {
            if (j == -1 || P.charAt(i) == P.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else
                j = next[j];
        }
        System.out.println(Arrays.toString(next));
    }


    public static String maxPrefixSuffix(String s){
        int len = s.length();





        return s;
    }


    /**
     * 返回 next 数组的最后一个值
     * https://leetcode-cn.com/problems/shortest-palindrome/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--44/
     * @param s
     * @return
     */
    public static int getLastNext(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] next = new int[n + 1];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i <= n) {
            if (k == -1 || c[i - 1] == c[k]) {
                next[i] = k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next[n];
    }


    public static void main(String[] args) {
        System.out.println(getLastNext("abcabcabc"));
        System.out.println(getLastNext("abcabc"));
        System.out.println(getLastNext("acccacccaccc"));
        System.out.println(kmp("bacbababaabcbab", "abababca"));
    }

}
