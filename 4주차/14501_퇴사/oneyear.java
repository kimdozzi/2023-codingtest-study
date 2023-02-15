import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] dp,T,P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];
        dp = new int[N+2];
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>0; i--) {
            if(i-1+T[i-1]>N) dp[i] = dp[i+1];
            else dp[i] = Math.max(dp[i+1], dp[i+T[i-1]]+P[i-1] );
        }

        System.out.println(dp[1]);
    }
}
