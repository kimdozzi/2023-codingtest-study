import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class oneyear {
    static int N,M,cnt;
    static int [] di = {-1,0,1,0}, dj = {0,-1,0,1};
    static int [][] arr;
    static Queue<Point> q;
    static class Point  {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int [N][M];
        q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) q.add(new Point(i,j));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0; i<4; i++) {
                int ni = p.x + di[i];
                int nj = p.y + dj[i];

                if(ni>=0 && ni<N && nj>=0 && nj<M && arr[ni][nj]==0) {
                    arr[ni][nj]=arr[p.x][p.y]+1;
                    q.add(new Point(ni,nj));
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]==0) return -1;
                cnt = Math.max(cnt,arr[i][j]);
            }
        }
        return cnt-1;
    }
}
