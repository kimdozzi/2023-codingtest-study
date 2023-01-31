import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v;
    static boolean[][] matrix;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        matrix = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        //꼭 꼭 인덱스 체크 하기 TT
        for(int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            matrix[x][y] = matrix[y][x] = true;
        }
        dfs(v);
        Arrays.fill(visited, false);
        bw.write("\n");
        bfs(v);
        bw.flush();
        bw.close();
    }
    static void dfs(int v) throws IOException {
        visited[v] = true;
        bw.write(String.valueOf(v)+" ");
        for(int i = 1; i <= n; i++){
            if(matrix[v][i] && !visited[i])
                dfs(i);
        }
    }
    static void bfs(int v) throws IOException {
        visited[v] = true;
        queue.add(v);
        while(!queue.isEmpty()){
            int tmp = queue.remove();
            bw.write(String.valueOf(tmp)+" ");
            for(int i = 1; i <= n; i++){
                if(matrix[tmp][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}