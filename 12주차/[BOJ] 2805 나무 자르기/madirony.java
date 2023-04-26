import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        long max = 0, min = 0, mid = 0;
        //입력
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(max < tree[i])
                max = tree[i];
        }
        max++;
        //찾기
	//로직은 랜선 자르기랑 똑같음 ..
        while(min < max){
            mid = (min + max)/2;
            long sum = 0;
            for(int i = 0; i < tree.length; i++){
                if(mid < tree[i]) {
                    long tmp = tree[i] - mid;
                    sum += tmp;
                }
            }
            if(sum < m)
                max = mid;
            else
                min = mid+1;
        }
        System.out.println(min-1);
    }
}