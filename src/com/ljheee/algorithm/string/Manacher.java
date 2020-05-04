package com.ljheee.algorithm.string;

import java.util.Arrays;

/**
 * 马拉车
 * 求解任意字符串str的最长回文子串
 */
public class Manacher {


    public static int manacher(String str) {

        String s = process(str);
        int len = s.length();

        int R = -1;// 当前最大：回文右边界
        int C = -1;// R的中心点
        int[] p = new int[len];

        for (int i = 0; i < p.length; i++) {
            // i在R内，取对称点、或R-i的值
            p[i] = i < R ? Math.min(R - i, p[2 * C - i]) : 1;
            // 尝试扩
            while (i + p[i] < R && i - p[i] > -1) {
                if (s.charAt(i + p[i]) == s.charAt(i - p[i])) {
                    p[i]++;
                } else {
                    break;
                }
            }

            // 找到更大的回文右边界，更新
            if (i + p[i] > R) {
                R = i + p[i];
                C = i;
            }
        }

        int max = Arrays.stream(p).max().getAsInt() - 1;

        /**
         * str的最大回文子串长度为max
         * 子串为:
         * int from = indexOfMax / 2 + max / 2;
         * str.substring(from, max);
         * https://leetcode.com/problems/longest-palindromic-substring/submissions/
         */

        return max;
    }


    /**
     * 将str插入#，变成奇数长度
     */
    private static String process(String str) {
        StringBuffer stringBuffer = new StringBuffer("#");
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            stringBuffer.append(aChar);
            stringBuffer.append('#');
        }
        return stringBuffer.toString();
    }
}
