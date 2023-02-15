import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int [][] arr;
    static int cnt = 0, n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int curX = Integer.parseInt(st.nextToken()); int curY = Integer.parseInt(st.nextToken());
        int curClean = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        robot(curX, curY, curClean);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
    static void robot(int x, int y, int clean){
        if(arr[x][y] == 0) {
            arr[x][y] = -1;
            cnt++;
        }
        boolean flag = false;
        loop : for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m){
                if(arr[nextX][nextY] == 0)
                    flag = true;
                if(flag){
                    do{
                        clean -= 1;
                        if(clean < 0)
                            clean = 3;

                        if(arr[x + dx[clean]][y + dy[clean]] == 0) {
                            robot(x + dx[clean], y + dy[clean], clean);
                            break loop;
                        }
                    }while(arr[x + dx[clean]][y + dy[clean]] != 0);
                }
            }
        }
        if(!flag){
            if(0 <= x + dx[(clean + 2)%4] && x + dx[(clean + 2)%4] < n && 0 <= y + dy[(clean + 2)%4] && y + dy[(clean + 2)%4] < m) {
                if (arr[x + dx[(clean + 2) % 4]][y + dy[(clean + 2) % 4]] != 0 && arr[x + dx[(clean + 2) % 4]][y + dy[(clean + 2) % 4]] != 1){
                    robot(x + dx[(clean + 2) % 4], y + dy[(clean + 2) % 4], clean);
                }
                return;
            }
        }
    }
}