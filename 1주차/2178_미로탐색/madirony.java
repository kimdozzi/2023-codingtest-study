import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < m; j++)
                matrix[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
        }
        //방문 체크
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    visited[i][j] = true;
                visited[i][j] = matrix[i][j] == 0;
            }
        }

        //메모 : bfs에서는 queue 사용
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0], curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                //인덱스 실수 줄이기 1
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
                    if(!visited[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        matrix[nextX][nextY] = matrix[curX][curY] + 1;
                    }
                }
            }

        }
        //인덱스 실수 줄이기 2
        bw.write(String.valueOf(matrix[n-1][m-1]));
        bw.flush();
        bw.close();
    }

}