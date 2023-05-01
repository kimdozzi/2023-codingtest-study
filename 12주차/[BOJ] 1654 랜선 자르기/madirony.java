import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max = 0, min = 0, mid = 0;
        //입력
        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];
        }
        max++;
        //찾기 (이분 탐색)
        while(min < max){
            mid = (min + max)/2;
            long sum = 0;
            for(int i = 0; i < arr.length; i++){
                long tmp = arr[i]/mid;
                sum += tmp;
            }
            if(sum < n)
                max = mid;
            else
                min = mid+1;
        }
        System.out.println(min-1);
    }
}