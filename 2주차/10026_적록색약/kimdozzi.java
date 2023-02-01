package samsungCodingTest.Week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class BOJ10026 {
    static int N;
    static int p1, p2;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static String[] a;
    static boolean[][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = "";
        a = new String[N];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            a[i] = str;
        }
    }

    static void dfs1(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (visit[nx][ny])
                continue;
            if (a[nx].charAt(ny) != a[x].charAt(y))
                continue;
            dfs1(nx, ny);
        }
    }

    static void dfs2(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (visit[nx][ny])
                continue;
            if (a[nx].charAt(ny) == a[x].charAt(y)) { // 같을 때
                dfs2(nx, ny);
            } else { // 다를 때
                if ((a[x].charAt(y) == 'G' && a[nx].charAt(ny) == 'R') ||
                        (a[x].charAt(y) == 'R' && a[nx].charAt(ny) == 'G')) {
                    dfs2(nx, ny);
                }
            }
        }
    }

    static void process() {
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs1(i, j);
                    p1++;
                }
            }
        }
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs2(i, j);
                    p2++;
                }
            }
        }
        System.out.println(p1 + " " + p2);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
