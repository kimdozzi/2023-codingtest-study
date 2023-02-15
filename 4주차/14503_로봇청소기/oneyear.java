package BOJ.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M,r,c,d,ans;
    static int [] di = {-1,0,1,0}, dj = {0,1,0,-1}; // 북동남서
    static int [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(r,c,d);
        System.out.println(ans);
    }


    public static void func(int x, int y, int direct) {
        if(arr[x][y]==0) {
            ans++;
            arr[x][y] = 2;
        }

        for(int i=0; i<4; i++) {
            direct = ( direct + 3 ) % 4;
            int ni = x + di[direct];
            int nj = y + dj[direct];

            if(ni>=0 && ni<N && nj>=0 && nj<M && arr[ni][nj]==0) {
                func(ni,nj,direct);
                return;
            }
        }

        int back = (direct + 2) % 4;
        int ni = x + di[back];
        int nj = y + dj[back];

        if(ni>=0 && ni< N && nj>=0 && nj< M && arr[ni][nj] != 1) {
            func(ni,nj,direct);
        }
    }
}
