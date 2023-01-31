import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oneyear {

    static int T, M, N, K, ans ;
    static int [] di = {-1,0,1,0}, dj={0,-1,0,1};
    static int [][] arr;
    static boolean [][] visited;

    public  static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            ans=0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new boolean[N][M];

            for(int k=0; k<K; k++ ) {
                st = new StringTokenizer(br.readLine(), " ");
                int ti = Integer.parseInt(st.nextToken());
                int tj = Integer.parseInt(st.nextToken());
                arr[tj][ti] = 1;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j]==1 && !visited[i][j]) {
                        area(i,j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void area(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int ni = x + di[i];
            int nj = y + dj[i];

            if(ni>=0 && ni<N && nj>=0 && nj<M && !visited[ni][nj] && arr[ni][nj]==1) {
                visited[ni][nj]=true;
                area(ni,nj);
            }
        }

    }
}
