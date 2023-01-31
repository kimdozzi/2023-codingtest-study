import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class oneyear {

    static int N, cnt ;
    static int [] di = {-1,0,1,0}, dj = {0,-1,0,1};
    static int [][] arr;
    static boolean [][] visited;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++)  {
            char [] ch = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(ch[j]));
            }
        }

        visited = new boolean[N][N];
        cnt = 0;
        result = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j]==1 && !visited[i][j]) {
                    cnt=1;
                    search(i,j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int r : result) System.out.println(r);
    }

    public  static int search(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int ni = x + di[i];
            int nj = y + dj[i];

            if(ni>=0 && ni<N && nj>=0 && nj<N && !visited[ni][nj] && arr[ni][nj]==1) {
                visited[ni][nj] = true;
                search(ni,nj);
                cnt++;
            }
        }
        return cnt;
    }
}
