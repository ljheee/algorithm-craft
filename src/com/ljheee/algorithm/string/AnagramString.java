package com.ljheee.algorithm.string;

/**
 * 同分异构词
 */
public class AnagramString {


    /**
     * a，b 是否是同分异构词
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] cs1 = a.toCharArray();
        char[] cs2 = b.toCharArray();

        int[] count = new int[256];
        for (int i = 0; i < cs1.length; i++) {
            count[cs1[i]]++;
        }

        for (int i = 0; i < cs2.length; i++) {
            if (count[cs2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 找出a 中包含 b的同分异构词
     * 返回第一次出现的下标
     *
     * @param a
     * @param b
     * @return
     */
    public int findAnagram(String a, String b) {

        int n = a.length();
        int m = b.length();
        if (n < m) {
            return -1;
        }

        int[] count = new int[256];
        for (int i = 0; i < m; i++) {
            count[b.charAt(i)]++;
        }

        int invalid = 0;
        for (int i = 0; i < m; i++) {
            if (count[a.charAt(i)]-- == 0) {
                invalid++;
            }
        }
        if (invalid == 0) {
            return 0;
        }

        for (int i = 1; i < n - m + 1; i++) {
            if (count[a.charAt(m + i - 1)]-- <= 0) {
                invalid++;
            }
            if (count[a.charAt(i - 1)]++ < 0) {
                invalid--;
            }
            if (invalid == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new AnagramString().findAnagram("abccapdd", "accab"));
        System.out.println(new AnagramString().findAnagram("mabccadd", "accab"));
        System.out.println(new AnagramString().findAnagram("aqaccabdd", "accab"));
        System.out.println(new AnagramString().findAnagram("aqaaccbdd", "accab"));


        System.out.println(new AnagramString().isAnagram("abac", "aabc"));
        System.out.println(new AnagramString().isAnagram("akak", "akka"));
        System.out.println(new AnagramString().isAnagram("abcdd", "aabcd"));
    }

}
