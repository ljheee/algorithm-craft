package com.ljheee.algorithm.graph;

import java.util.Scanner;

/**
 * 最短路径问题---Dijkstra算法详解
 *
 * 6 8 1
 * 1 3 10
 * 1 5 30
 * 1 6 100
 * 2 3 5
 * 3 4 50
 * 4 6 10
 * 5 4 20
 * 5 6 60
 */
public class Dijkstra {

    public static void main(String[] args) {

        int n, m, x; //n,m表示N个点，m条边，x表示要求的最短路径的起点

        Scanner cin = new Scanner(System.in);

//        System.out.println("请输入点数 :");
        n = cin.nextInt();

//        System.out.println("请输入边数 :");
        m = cin.nextInt();

//        System.out.println("请输开始点数");
        x = cin.nextInt();


        int value[][] = new int[n + 1][n + 1];    //表示 a到 b的路径权重，存储图信息
        int dis[] = new int[n + 1];    //表示存最短路径的数组

        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE; //做路径的初始化，默认全部为INF
            for (int j = 1; j <= n; j++) {
                if (i == j) {//i == j时表示的就是自己
                    value[i][j] = 0;
                } else {
                    value[i][j] = -1;
                }
            }
        }

        //输入 路径权重
        for (int i = 0; i < m; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int v = cin.nextInt();
            value[a][b] = v;
            if (a == x) {
                dis[b] = v;
            }
        }
        search(x, dis, value, n);
    }


    /**
     * @param from  最短路径起点
     * @param dis
     * @param value 存储图 的二维数组
     * @param n     N个点
     */
    private static void search(int from, int[] dis, int value[][], int n) {
        boolean mark[] = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            mark[i] = false;
        }

        mark[from] = true;    //表示当前这个点已经被加过了
        dis[from] = 0;    //自己走自己

        int count = 1;    //表示 当前加了几个点了
        while (count <= n) {
            int loc = 0;    //表示贪 婪策略里面要加的那个点

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                if (!mark[i] && dis[i] < min) {
                    min = dis[i];
                    loc = i;
                }
            }

            if (loc == 0) {
                break; //表示当前已经没有点可以加了
            }
            mark[loc] = true;
            count++;

            for (int i = 1; i <= n; i++) {
                if (!mark[i] && value[loc][i] != -1 && (dis[loc] + value[loc][i] < dis[i])) {
                    dis[i] = dis[loc] + value[loc][i];
                }
            }
        }

        System.out.println("以" + from + "为起点的最短路径");
        for (int i = 1; i <= n; i++) {

            if (dis[i] != Integer.MAX_VALUE) {
                System.out.println(i + "最短为：" + dis[i]);
            } else {
                System.out.println(i + "无路径");
            }
        }
    }

}
