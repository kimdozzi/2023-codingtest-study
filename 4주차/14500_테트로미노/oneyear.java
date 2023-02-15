import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M,ans;
    static int [][] arr;
    static int [][][] di = {
            { {1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0} },
            { {1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0} },
            { {1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0} },

            { {1,1,0,0},{1,0,0,0},{1,0,0,0},{0,0,0,0} },
            { {1,1,1,0},{0,0,1,0},{0,0,0,0},{0,0,0,0} },
            { {0,1,0,0},{0,1,0,0},{1,1,0,0},{0,0,0,0} },
            { {1,0,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0} },
            { {1,1,0,0},{0,1,0,0},{0,1,0,0},{0,0,0,0} },
            { {0,0,1,0},{1,1,1,0},{0,0,0,0},{0,0,0,0} },
            { {1,0,0,0},{1,0,0,0},{1,1,0,0},{0,0,0,0} },
            { {1,1,1,0},{1,0,0,0},{0,0,0,0},{0,0,0,0} },

            { {1,0,0,0},{1,1,0,0},{1,0,0,0},{0,0,0,0} },
            { {1,1,1,0},{0,1,0,0},{0,0,0,0},{0,0,0,0} },
            { {0,1,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0} },
            { {0,1,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0} },

            { {1,0,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0} },
            { {1,1,0,0},{0,1,1,0},{0,0,0,0},{0,0,0,0} },
            { {0,1,0,0},{1,1,0,0},{1,0,0,0},{0,0,0,0} },
            { {0,1,1,0},{1,1,0,0},{0,0,0,0},{0,0,0,0} }
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+3][M+3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<19; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int tmp = add(i,j,k);
                    ans = Math.max(tmp,ans);
                }
            }
        }

        System.out.println(ans);
    }

    public static int add(int x, int y, int k) {
        int sum=0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                sum+=arr[x+i][y+j]*di[k][i][j];
            }
        }
        return sum;
    }


}
