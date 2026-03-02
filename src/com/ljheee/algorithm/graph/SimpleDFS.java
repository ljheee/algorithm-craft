package com.ljheee.algorithm.graph;

/**
 * 求 最快到达终点 “需要的最小的步数”
 */
public class SimpleDFS {

    private int n;// n行
    private int m;// m列
    private int dx;
    private int dy; //目的地 坐标
    private int data[][]; //邻接矩阵 表示地图
    private boolean mark[][]; //标记是否走过
    private int minSetp = Integer.MAX_VALUE;//到达终点 需要的最小步数

    public SimpleDFS(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = mark;
    }

    public void dfs(int x, int y, int step) {//起点
        mark[x][y] = true;
        int next[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//四个方向

        if (x == dx && y == dy) {//是否已到达终点(递归的终止条件)
            if (step < minSetp) {
                minSetp = step;
            }
            return;
        }

        //遍历四个方向
        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];
            if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {//(下一步)是否越界
                continue;
            }

            if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {//(下一步)非障碍物，且还没走过
                mark[nextX][nextY] = true;
                dfs(nextX, nextY, step + 1);//递归
                mark[nextX][nextY] = false;//回溯
            }
        }
        return;
    }


    public static void main(String[] args) {

        //构建地图和mark采用 [n+1][m+1]
        int[][] map = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        boolean[][] mark = new boolean[5 + 1][4 + 1];
        SimpleDFS dfs = new SimpleDFS(5, 4, 4, 3, map, mark);
        dfs.dfs(1, 1, 0);
        System.out.println(dfs.minSetp);//输出需要的最小步数

    }
}

