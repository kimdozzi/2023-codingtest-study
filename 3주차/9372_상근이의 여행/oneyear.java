import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T,N,M,cnt;
    static int [][] arr;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N+1][N+1];
            visited = new boolean[N+1];

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b]=arr[b][a]=1;
            }

            bfs();
            System.out.println(cnt-1);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1]=true;
        q.add(1);
        cnt=0;

        while(!q.isEmpty()) {
            int p = q.poll();

            for(int i=1; i<N+1; i++) {
                if(arr[p][i]==1 && !visited[i]) {
                    visited[i]=true;;
                    q.add(i);
                    cnt++;
                }
            }
        }
    }
}
