import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int max = 0, n;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n+1];
        for(int i = 0; i < n; i++) {
            if(arr[i][0] + i <= n)
                dp[arr[i][0] + i] = Integer.max(arr[i][1] + dp[i], dp[arr[i][0] + i]);
            dp[i+1] = Integer.max(dp[i+1], dp[i]);

        }
//        System.out.println(Arrays.toString(dp));
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}