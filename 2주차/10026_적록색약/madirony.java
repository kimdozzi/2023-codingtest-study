import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int[][] normal;
    static boolean[][] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Boolean> list = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        normal = new int[n][n];
        visited = new boolean[n][n];

        //R 구하기
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                char cmp = str.charAt(j);
                if(cmp == 'R')
                    normal[i][j] = 0;
                else if(cmp == 'G') {
                    normal[i][j] = 1;
                    visited[i][j] = true;
                }
                else {
                    normal[i][j] = 2;
                    visited[i][j] = true;
                }
            }
        }
        getVisited();

        //G 구하기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(normal[i][j] == 0)
                    visited[i][j] = true;
                else if(normal[i][j] == 2)
                    visited[i][j] = true;
            }
        }
        getVisited();

        //B 구하기 + 카운팅
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(normal[i][j] == 0)
                    visited[i][j] = true;
                else if(normal[i][j] == 1)
                    visited[i][j] = true;
            }
        }
        int blue = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                    blue++;
                }
            }
        }
        bw.write(String.valueOf(list.size()));
        list.clear();

        //적녹색맹
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(normal[i][j] == 2)
                    visited[i][j] = true;
            }
        }
        getVisited();

        bw.write(String.valueOf(" " + (list.size()+blue)));
        bw.flush();
        bw.close();
    }

    private static void getVisited() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        visited = new boolean[n][n];
    }

    static void bfs(int x, int y) {
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.remove();
            int curX = cur[0], curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(0 <= nextX && nextX < n && 0 <= nextY && nextY < n){
                    if(!visited[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        list.add(true);
    }
}