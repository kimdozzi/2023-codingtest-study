import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k;
    static int[][] matrix;
    static boolean[][] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int z = 0; z < tc; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            matrix = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++)
                Arrays.fill(visited[i], true);

            //방문 체크
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
                visited[x][y] = false;
            }

            //배열 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j])
                        bfs(i, j);
                }
            }
            //출력
            list.sort(Comparator.naturalOrder());
            bw.write(list.size() + "\n");
            list.clear();
        }
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
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
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