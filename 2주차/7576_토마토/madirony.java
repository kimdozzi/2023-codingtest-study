import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[][] matrix;
    static boolean[][] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];

        //방문 체크 ++ 쓸데없이 시간초과가 나던 이유 : 큐에 바로 안 넣고, ArrayList로 복잡하게 구현했음 TT
        //trash code 줄이기
        for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                matrix[i][j] = tmp;
                if(tmp == -1)
                    visited[i][j] = true;
                if(tmp == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        //배열 탐색
//        for(int i = 0; i < list.size(); i++){
            bfs();
//        }

        //가장 큰 수 찾기
        int max = 0, min = Integer.MAX_VALUE;
        boolean flag = true;
//        loop:
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                if(matrix[i][j] == 0) {
//                    bw.write(String.valueOf(max-1));
//                    flag = false;
//                    break loop;
//                }
//                int num = Arrays.stream(matrix[i]).max().getAsInt();
//                if(max < num)
//                    max = num;
//            }
//        }
        int row = 0;
        while(row < n){
            int num = Arrays.stream(matrix[row]).max().getAsInt();
            if(max < num)
                max = num;
            if(Arrays.stream(matrix[row]).anyMatch(a-> a == 0)) {
                bw.write(String.valueOf(-1));
                flag = false;
                break;
            }
            row++;
        }
        if(flag)
            bw.write(String.valueOf(max-1));
        bw.flush();
        bw.close();
    }
    static void bfs() throws IOException {
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int curX = cur[0], curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
                    if(matrix[nextX][nextY] == 0 && !visited[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = matrix[curX][curY] + 1;
                    }
                }
            }
        }
    }
}