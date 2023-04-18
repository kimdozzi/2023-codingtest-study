package samsungCodingTest.Week04;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14501 {
    static class Pair<T, P> { // pair 클래스 구현 Time, Profit을 받기 위해
        T time;
        P profit;

        public Pair(T timeValue, P profitValue) {
            time = timeValue;
            profit = profitValue;
        }
    }

    static Pair<Integer, Integer>[] arr;
    static int n;
    static int[] dp;

    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;
        n = scan.nextInt(); // 남은 N일
        dp = new int[n + 1]; // N일만큼의 dp 배열
        arr = new Pair[n + 1]; // N개의 상담완료 기간, 받을 수 있는 금액을 저장하기 위한 배열
        for (int i = 0; i < n; i++) {
            // st = new StringTokenizer(br.readLine());
            int t = scan.nextInt(), p = scan.nextInt();
            arr[i] = new Pair<>(t, p); // Use dynamic arr of pairs.
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + arr[i].time; j < n + 1; j++) {
                if (dp[j] < dp[i] + arr[i].profit)
                    dp[j] = dp[i] + arr[i].profit;
            }
        }
        System.out.println(dp[dp.length - 1]);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
