package samsungCodingTest.Week02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667 {
    // 전역 선언
    static StringBuilder sb = new StringBuilder();
    static int N, group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    static ArrayList<Integer> group;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new String[N];
        String str = "";
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            a[i] = str;
        }
        visit = new boolean[N][N];
    }

    static void process() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    bfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        // 찾은 단지의 정보 출력하기
        /* TODO */
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (int cnt : group)
            sb.append(cnt).append('\n');
        System.out.println(sb);
    }

    // x, y를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) { // O(V+E) = O(N^2) + O(N^2 * 4) = O(N^2)
        // 단지에 속한 집의 개수 증가, visit 체크
        visit[x][y] = true;
        group_cnt++;

        /* TODO */
        // 인접한 집으로 새로 방문하기
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue; // 격자를 벗어난다면
            if (a[nx].charAt(ny) == '0')
                continue; // 방문할 수 없는 칸이라면
            if (visit[nx][ny])
                continue; // 방문한 적이 있다면
            bfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
