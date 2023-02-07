package samsungCodingTest.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14620 {
    static int N; // 한 변의 길이
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 상 하 좌 우
    static int[][] grid; // 격자
    static boolean[][] visit; // 방문 여부
    static StringTokenizer st;
    static BufferedReader br;
    static int mn = Integer.MAX_VALUE;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int calculator() {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j])
                    total += grid[i][j];
            }
        }
        return total;
    }

    static boolean isCheck(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (visit[nx][ny])
                return false;
        }
        return true;
    }

    static void isVisit(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            visit[nx][ny] = true;
        }
    }

    static void ClearVisit(int x, int y) {
        visit[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            visit[nx][ny] = false;
        }
    }

    static void backTracking(int k) {
        if (k == 3) {
            mn = Math.min(mn, calculator());
        } else {
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (!visit[i][j] && isCheck(i, j)) {
                        isVisit(i, j);
                        backTracking(k + 1);
                        ClearVisit(i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        backTracking(0);
        System.out.println(mn);
    }
}