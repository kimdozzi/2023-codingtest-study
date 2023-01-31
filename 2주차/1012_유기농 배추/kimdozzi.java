package samsungCodingTest.Week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1012 {
    // 전역 변수
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T,N,M,K,ans;
    static boolean[][] visit;
    static int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    static StringBuilder sb = new StringBuilder();

    static int[][] graph;

    static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        // 0으로 초기화
        for(int i = 0; i < N; i++) {
            Arrays.fill(graph[i], 0);
        }
        // K개 배추를 심자.
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
        }
    }
    static void dfs(int x, int y) {
        // 방문 체크 !
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if (visit[nx][ny]) continue;
            if (graph[nx][ny] == 0) continue;
            dfs(nx,ny);
        }
    }
    static void process() {
        ans = 0;
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && graph[i][j] == 1) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int testcase = 0; testcase < T; testcase++) {
            input();
            process();
        }
    }
}
