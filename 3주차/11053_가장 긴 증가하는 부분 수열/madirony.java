import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && ans[i] < ans[j] + 1)
                    ans[i] = ans[j] + 1;
            }
        }
        bw.write(String.valueOf(Arrays.stream(ans).max().getAsInt()));
        bw.flush();
        bw.close();
    }
}