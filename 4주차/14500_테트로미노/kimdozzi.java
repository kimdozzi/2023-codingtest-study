package samsungCodingTest.Week04;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14500 {
    static FastReader scan = new FastReader();
    static int n, m, ans = 0;
    static ArrayList<Integer>[] matrix;

    static int[][][] tetris = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },
            { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
            { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 2, 0 } },
            { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } },
            { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } },
            { { 0, 2 }, { 1, 1 }, { 1, 2 }, { 1, 0 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } },
            { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 0, 2 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
            { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 2, 0 } },
            { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 } },
            { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } },
            { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, 2 } },
            { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } },
            { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 2, 1 } }
    };

    static int calculate(int[][] dist) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int total = 0;
                int cnt = 4;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dist[k][0];
                    int ny = j + dist[k][1];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        total += matrix[nx].get(ny);
                        cnt--;
                    }
                }
                if (cnt > 0)
                    continue;
                else
                    res = Math.max(total, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        matrix = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                matrix[i].add(scan.nextInt());
            }
        }
        for (int i = 0; i < tetris.length; i++) {
            int tmp = calculate(tetris[i]);
            ans = Math.max(tmp, ans);
        }
        System.out.println(ans);
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
