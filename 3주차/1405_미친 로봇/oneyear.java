import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static double ans;
    static double [] prop;
    static int [] di = {0,0,1,-1}, dj = {1,-1,0,0};
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        prop = new double[4];

        for(int i=0; i<4; i++) {
            prop[i] = Double.parseDouble(st.nextToken())/100;
        }

        visited = new boolean [29][29];
        dfs(14,14,0,1);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int cnt, double p) {
        if(cnt==N) {
            ans+=p;
            return;
        }

        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int ni = x + di[i];
            int nj = y + dj[i];

            if(!visited[ni][nj]) {
                dfs(ni,nj,cnt+1, p*prop[i]);
            }
        }
        visited[x][y]=false;
    }
}
