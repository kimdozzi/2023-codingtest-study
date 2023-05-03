import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int cnt = 0;
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for(int i = n-1; 0 <= i; i--){
            while(arr[i] <= k){
                k -= arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}