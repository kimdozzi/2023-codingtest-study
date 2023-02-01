import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] matrix;
    static boolean[][] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //static 주의
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        visited = new boolean[n][n];

        //방문 체크
        for(int i = 0; i < n; i++){
            String row = br.readLine();
            int tmp;
            for(int j = 0; j < n; j++) {
                matrix[i][j] = tmp = Integer.parseInt(String.valueOf(row.charAt(j)));
                if(tmp == 0)
                    visited[i][j] = true;
            }
        }

        //배열 탐색
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j])
                    bfs(i, j);
            }
        }
        //출력
        list.sort(Comparator.naturalOrder());
        bw.write(list.size()+"\n");
        for(int i = 0; i < list.size(); i++)
            bw.write(String.valueOf(list.get(i)) + "\n");
        bw.flush();
        bw.close();
    }
    static void bfs(int x, int y) throws IOException {
        int sum = 0;
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        sum += 1;
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int curX = cur[0], curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < n){
                    if(matrix[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        sum += 1;
                    }
                }
            }
        }
        list.add(sum);
    }
}