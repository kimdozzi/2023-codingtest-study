import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] -= b;
            sum++;
        }
        for(int i = 0; i < n; i++) {
            if (0 < arr[i])
                sum += arr[i] / c;
            if (0 < arr[i] % c)
                sum++;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}