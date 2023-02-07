package samsungCodingTest.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9372 {
    static int T, N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static StringTokenizer st;
    static BufferedReader br;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 1; i < graph.length; i++) {
            System.out.println(graph[i]);
        }
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visit[1] = true;
        int cnt = 0;
        while (!que.isEmpty()) {
            cnt++;
            int num = que.poll();
            for (int v : graph[num]) {
                if (!visit[v]) {
                    visit[v] = true;
                    que.add(v);
                }
            }
        }
        System.out.println(cnt - 1);

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            input();
            visit[0] = true; // 0번째 정점을 생각안해준 실수 (1)
            bfs();
        }
    }
}