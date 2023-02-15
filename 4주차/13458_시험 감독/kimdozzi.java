package samsungCodingTest.Week04;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13458 {
    static FastReader scan = new FastReader();
    static long[] student;
    static int n;
    static long head, manager, cnt = 0;

    public static void main(String[] args) {
        n = scan.nextInt();
        student = new long[n];
        for (int i = 0; i < n; i++) {
            student[i] = scan.nextInt();
        }
        head = scan.nextInt();
        manager = scan.nextInt();

        for (int i = 0; i < student.length; i++) {
            student[i] = Math.max(0, student[i] - head);
            cnt++;
        }

        for (int i = 0; i < student.length; i++) {
            if (student[i] < 1)
                continue;
            long number = student[i] / manager;
            cnt += number;
            if (student[i] % manager != 0)
                cnt++;
            student[i] = 0;
        }
        System.out.println(cnt);
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
