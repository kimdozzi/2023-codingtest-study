import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,ans;
    static int [] di = {-1,0,1,0}, dj = {0,-1,0,1};
    static int [][] arr, brr;
    static Queue<Point> q;
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }

    public static void main(String[ ] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        brr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countWall(0);
        System.out.println(ans);
    }

    public static void countWall(int cnt) {
        if(cnt==3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=1;
                    countWall(cnt+1);
                    arr[i][j]=0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]==2) q.add(new Point(i,j));
                brr[i][j]=arr[i][j];
            }
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0; i<4; i++) {
                int ni = p.x + di[i];
                int nj = p.y + dj[i];

                if(ni>=0 && ni<N && nj>=0 && nj<M  && brr[ni][nj]==0) {
                    brr[ni][nj]=2;
                    q.add(new Point(ni,nj));
                }
            }
        }

        int tmp=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(brr[i][j]==0) tmp++;
            }
        }
        ans = Math.max(tmp,ans);

    }
}
