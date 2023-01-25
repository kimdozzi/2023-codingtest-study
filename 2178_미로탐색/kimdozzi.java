package samsungCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[][] graph = new int[101][101];
    static int n = 0;
    static int m = 0;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited = new boolean[101][101];
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            // st = new StringTokenizer(br.readLine()); 틀린부분
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                // graph[i][j] = Integer.parseInt(st.nextToken());
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        int start = graph[0][0];
        visited[0][0] = true;
        q.add(new int[] { 0, 0 });
        System.out.println(Mybfs());
    }

    private static Integer Mybfs() {
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[x][y] + 1;
                    q.add(new int[] { nx, ny });
                }
            }
        }
        return graph[n - 1][m - 1];
    }
}
