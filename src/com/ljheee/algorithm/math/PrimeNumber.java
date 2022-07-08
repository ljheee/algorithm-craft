package com.ljheee.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 前n 质数的个数 https://leetcode.com/problems/count-primes/description/
 *
 */
public class PrimeNumber {


    public List<Integer> primeNumber0(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(2);

        label:
        for (int i = 3; i <= n; i++) {
            if ((i & 1) == 0) continue;// 过滤偶数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) continue label;
            }
            list.add(i);
        }
        return list;
    }

    public List<Integer> primeNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        label:
        for (int i = 3; i <= n; i++) {
            if ((i & 1) == 0) continue;// 过滤偶数
            //位数是1,3,7,9的才有可能是质数
            if ((i & 1) == 1 || (i & 3) == 1 || (i & 7) == 1 || (i & 9) == 1) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) continue label;
                }
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        List<Integer> list0 = primeNumber.primeNumber0(1000);
        List<Integer> list = primeNumber.primeNumber(1000);
        System.out.println(list);

        System.out.println(list.removeAll(list0) + "=" + list0.size());



    }


}
