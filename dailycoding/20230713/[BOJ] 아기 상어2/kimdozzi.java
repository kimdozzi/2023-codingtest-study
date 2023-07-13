package 2023-codingtest-study.dailycoding.20230713.[BOJ] 아기 상어2;

package com.ll.boj.silver.p17086;

import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
    static int[][] grid;
    static int n, m;

    static class Pair {
        int x;
        int y;
        int dist;
        public Pair(int _x, int _y, int _dist) {
            this.x = _x;
            this.y = _y;
            this.dist = _dist;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int res = 0;
        grid = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (grid[i][j] == 0)
                    res = Math.max(bfs(i, j), res);
            }
        }
        System.out.println(res);
    }
    private static int bfs(int r, int c){
        // 근본 크기가 정해진 check 배열 이용하기
        boolean[][] check = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r, c, 0));
        check[r][c] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(int i=0; i<8; i++) {
                int nx = pair.x + dir[i][0];
                int ny = pair.y + dir[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (check[nx][ny]) continue;
                if (grid[nx][ny] == 1) return pair.dist + 1;
                check[nx][ny] = true;
                queue.add(new Pair(nx, ny, pair.dist + 1));
            }
        }
        return 0;
    }
}
