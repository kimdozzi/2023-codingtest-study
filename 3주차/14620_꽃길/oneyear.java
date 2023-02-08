import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,min,ans=Integer.MAX_VALUE;
    static int [] di = {-1,0,1,0}, dj = {0,-1,0,1};
    static int [][] arr;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        combination(0,0);
        System.out.println(ans);
    }

    public static void combination(int sum, int cnt) {
        if(cnt==3) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=1; i<N-1; i++) {
            for(int j=1; j<N-1; j++) {
                if(visited[i][j]) continue;
                min=addFlower(i,j);
                if(min==-1) continue;
                insideOut(i,j,true);
                combination(sum+min,cnt+1);
                insideOut(i,j,false);
            }
        }
    }

    public static int addFlower(int x, int y) {
        min=arr[x][y];
        for(int d=0; d<4; d++) {
            int ni = x + di[d];
            int nj = y + dj[d];

            if(!visited[ni][nj]) min+=arr[ni][nj];
            else return -1;
        }
        return min;
    }

    public static void insideOut(int x, int y, boolean bool) {
        visited[x][y]=bool;
        for(int i=0; i<4; i++) {
            int ni = x + di[i];
            int nj = y + dj[i];
            visited[ni][nj]=bool;
        }
    }
}
