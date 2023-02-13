import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE, n;
    static int[][] arr;
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();

    }
    static void dfs(int cnt, int sum){
        if(cnt == 3) {
            min = Integer.min(min, sum);
            return;
        }
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++){
                if(check(i,j)) {
                    for (int k = 0; k < 5; k++)
                        visited[i+dx[k]][j+dy[k]] = true;
                    dfs(cnt + 1, sum + sum(i, j));
                    for (int k = 0; k < 5; k++)
                        visited[i + dx[k]][j + dy[k]] = false;
                }
            }
        }
    }
    static boolean check(int i, int j){
        for(int k = 0; k < 5; k++){
            if(visited[i+dx[k]][j+dy[k]])
                return false;
        }
        return true;
    }

    static int sum(int i,int j){
        int sum = 0;
        for(int index = 0; index < 5; index++)
            sum += arr[i+dx[index]][j+dy[index]];
        return sum;
    }
}