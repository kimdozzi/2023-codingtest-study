package samsungCodingTest.Week02;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    static StringBuilder sb = new StringBuilder();

    // 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 번호 V
    static int N, M, V;
    // 방문 여부 체크
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]); // O(NlogN)
        }
    }

    static void dfs(int x) { // O(V + E)
        visited[x] = true;
        sb.append(x).append(' ');
        for (int y : adj[x]) {
            if (visited[y])
                continue;
            dfs(y);
        }
    }

    static void bfs(int x) { // O(V + E)
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(x);
        visited[x] = true;
        while (!que.isEmpty()) {
            x = que.poll();
            sb.append(x).append(' ');
            for (int y : adj[x]) {
                if (visited[y])
                    continue;
                que.add(y);
                visited[y] = true;
            }
        }
    }

    static void process() {
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        for (int i = 1; i <= N; i++)
            visited[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
