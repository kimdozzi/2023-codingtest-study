import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_숨바꼭질 {

    static int N,K;
    static int [] arr, di={-1,1,2};


    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];

        System.out.println(find(N));
    }

    // x-1, x+1, 2x
    public static int find(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()) {
            int p = q.poll();

            if(p==K) return arr[p];

            for(int i=0; i<3; i++) {
                int ni = p + di[i];
                if(i==2) ni = p*di[i];

                if(ni>=0 && ni<100001 && arr[ni]==0) {
                    arr[ni]=arr[p]+1;
                    q.add(ni);
                }
            }
        }
        return 0;
    }
}
