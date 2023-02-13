package samsungCodingTest.Week03;

import java.io.*;
import java.util.*;

public class BOJ1405 {
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        probability = new double[4];
        for (int i = 0; i < 4; i++) {
            probability[i] = Integer.parseInt(st.nextToken());
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static double N, ans;
    static boolean[][] visit = new boolean[30][30];
    static double[] probability;

    static void backTracking(int x, int y, int k, double total) {
        if (k == N) {
            ans += total;
        } else {
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    backTracking(nx, ny, k + 1, total * probability[i]);
                    visit[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        backTracking(15, 15, 0, 1);
        System.out.println(ans * Math.pow(0.01, N));
    }
}