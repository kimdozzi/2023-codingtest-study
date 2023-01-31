package samsungCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1697 {
    static boolean[] visited = new boolean[1000001];
    static int[] dist = { -1, 1, 2 };
    static int n;
    static int k;
    static boolean flag = true;
    static Queue<Integer> que = new LinkedList<>();
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        que.add(n);
        count = new int[100001];
        count[n] = 1;
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == k)
                return count[x] - 1;
            for (int i = 0; i < 3; i++) {
                int subin;
                if (i == 2)
                    subin = x * dist[i];
                else
                    subin = x + dist[i];

                if ((0 <= subin && subin <= 100000) && count[subin] == 0) {
                    que.add(subin);
                    count[subin] = count[x] + 1;
                }
            }
        }
        return -1;
    }
}
