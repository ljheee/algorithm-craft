package com.ljheee.algorithm.string.rolling_hash;

/**
 * 滚动hash
 * 寻找最长的回文前缀
 * https://leetcode.com/problems/shortest-palindrome/submissions/
 */
public class RollingHash4Palindrome {

    /**
     * 重点是两个hash函数
     * long hash1 = 0, hash2 = 0;
     * hash1 = hash1 * base + a[i];
     * hash2 = hash2 + a[i]*base^[0~n];
     *
     * @param s
     */
    public String maxPalindromePrefix(String s) {
        int n = s.length(), pos = -1;

        long base = 26, POW = 1, hash1 = 0, hash2 = 0;
        for (int i = 0; i < n; i++, POW = POW * base) {
            int v = s.charAt(i) - 'a' + 1;
            hash1 = (hash1 * base + v);
            hash2 = (hash2 + v * POW);
            if (hash1 == hash2) {
                pos = i;
            }
        }
        System.out.println("maxPalindromePrefix end of pos: " + pos);
        return new StringBuffer(s.substring(pos + 1)).reverse().toString() + s;
    }


    public static void main(String[] args) {

        System.out.println(new RollingHash4Palindrome().maxPalindromePrefix("aacecaaa"));
        System.out.println(new RollingHash4Palindrome().maxPalindromePrefix("aacecaaa"));
        System.out.println(new RollingHash4Palindrome().maxPalindromePrefix("adcba"));
        System.out.println(new RollingHash4Palindrome().maxPalindromePrefix("abab"));
    }


}
