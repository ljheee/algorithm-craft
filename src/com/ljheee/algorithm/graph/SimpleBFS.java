package com.ljheee.algorithm.graph;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


class Point {
    int x;
    int y;
}

/**
 * BFS和DFS 都是针对图的遍历
 * BFS 性能最快，但不能解决所有问题，只能解决路径是否可达，不能“最快达到”
 */
public class SimpleBFS {


    private int n;// n行
    private int m;// m列
    private int dx;
    private int dy; //目的地 坐标
    private int data[][]; //邻接矩阵 表示地图

    private boolean mark[][]; //标记是否走过

    public SimpleBFS(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = mark;
    }

    public void bfs(int x, int y) {//起点
        mark[x][y] = true;
        int next[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//四个方向

        Queue<Point> queue = new ArrayBlockingQueue<>(n * m);//记录下一步 能走的点
        Point start = new Point();
        start.x = x;
        start.y = y;

        queue.add(start);
        while (!queue.isEmpty()) {
            Point current = queue.poll();//当前点

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + next[i][0];
                int nextY = current.y + next[i][1];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > m) {//(下一步)是否越界
                    continue;
                }

                if (data[nextX][nextY] == 0 && !mark[nextX][nextY]) {//(下一步)非障碍物，且还没走过
                    if (nextX == dx && nextY == dy) {//是否已到达终点
                        System.out.println("True");
                        return;
                    }
                    Point nextPoint = new Point();
                    nextPoint.x = nextX;
                    nextPoint.y = nextY;
                    mark[nextX][nextY] = true;
                    queue.add(nextPoint);//nextPoint不是终点且能走，加入下一步待走队列
                }
            }
        }
        System.out.println("False");
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
        SimpleBFS bfs = new SimpleBFS(5, 4, 4, 3, map, mark);
        bfs.bfs(1, 1);

    }
}