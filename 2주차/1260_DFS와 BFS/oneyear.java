import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class onyear {
    static int N,M,V;
    static int [][] arr;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++)  {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b]=arr[b][a]=1;
        }

        visited = new boolean[N+1];
        dfs(V);
        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x+" ");
        for(int i=1; i<N+1; i++) {
            if(arr[x][i]==1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int x) {
        System.out.println();
        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.add(x);

        while(!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p+" ");

            for(int i=1; i<N+1; i++) {
                if(arr[p][i]==1 && !visited[i]) {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}
