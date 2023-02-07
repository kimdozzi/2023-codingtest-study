package samsungCodingTest.Week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    static int N;
    static int[] seq;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int mx = -1;
        for (int i = 0; i < N; i++) {
            mx = Math.max(mx, dp[i]);
        }
        System.out.println(mx);
    }
}
