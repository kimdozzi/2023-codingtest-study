import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, max = 0;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1)
                    visited[i][j] = true;
            }
        }
        dfs(0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
    static void dfs(int cnt){
        if(cnt == 3)
            bfs();
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 0){
                        arr[i][j] = 1;
                        visited[i][j] = true;
                        dfs(cnt + 1);
                        arr[i][j] = 0;
                        visited[i][j] = false;
                    }
                }
            }
        }
    }
    static void bfs(){
        boolean[][] ansArr = new boolean[n][m];
        for(int i = 0; i < n; i++)
            if(m >= 0) System.arraycopy(visited[i], 0, ansArr[i], 0, m);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 2) {
                    ansArr[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0]; int curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
                    if(!ansArr[nextX][nextY]){
                        ansArr[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!ansArr[i][j])
                    sum++;
            }
        }
        max = Integer.max(max, sum);
    }
}