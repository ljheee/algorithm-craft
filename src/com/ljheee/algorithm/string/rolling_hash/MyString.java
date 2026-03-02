package com.ljheee.algorithm.string.rolling_hash;

/**
 * 滚动hash 实现 indexOf
 * https://leetcode-cn.com/problems/implement-strstr/
 * 没有使用hash溢出，
 * 只是小写字母
 */
public class MyString {


    public int indexOf(String s, String str) {

        if (!"".equals(s) && "".equals(str)) {
            return -1;
        }

        int n = s.length();
        int m = str.length();

        if (m > n) return -1;

        /**
         *
         */
        int base = 26;
        long subHash = 0, hash = 0, aL = 1;
        for (int i = 0; i < m; i++) {
            subHash = subHash * base + (str.charAt(i) - 'a');
            hash = hash * base + (s.charAt(i) - 'a');
            aL = aL * base;
        }
        aL /= base;

        if (subHash == hash) {
            return 0;
        }

        for (int i = 1; i < n - m + 1; i++) {
            hash = (hash - (s.charAt(i - 1) - 'a') * aL) * base + (s.charAt(m + i - 1) - 'a');
            if (subHash == hash) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new MyString().indexOf("abcde", "cd"));//2
        System.out.println(new MyString().indexOf("mmabcba", "cb"));//4
        System.out.println(new MyString().indexOf("mqmq", "mq"));//0
    }
}
