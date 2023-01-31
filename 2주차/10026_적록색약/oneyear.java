import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, normal, colorBlind;
    static int [] di = {-1,0,1,0}, dj = {0,-1,0,1};
    static String [][] arr, brr;
    static boolean [][] visited;
    static class Point {
        int x,y;
        String [] s;
        public Point(int x, int y, String [] s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new String[N][N];
        brr = new String[N][N];
        for(int i=0; i<N; i++)  {
            char [] ch = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                arr[i][j] = String.valueOf(ch[j]);
                brr[i][j] = String.valueOf(ch[j]);
                if(brr[i][j].equals("G")) brr[i][j]="R";
            }
        }

        // 일반인
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && arr[i][j].equals("R")) {
                    dfs(new Point(i,j, new String[]{"R"}));
                    normal++;
                } else if(!visited[i][j] && arr[i][j].equals("G")) {
                    dfs(new Point(i,j,new String[]{"G"}));
                    normal++;
                } else if(!visited[i][j] && arr[i][j].equals("B")) {
                    dfs(new Point(i,j,new String[]{"B"}));
                    normal++;
                }
            }
        }

        // 적록색약
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && ( arr[i][j].equals("G") || arr[i][j].equals("R")) ) {
                    dfs(new Point(i,j,new String[] {"R","G"}));
                    colorBlind++;
                } else if(!visited[i][j] && arr[i][j].equals("B")) {
                    dfs(new Point(i,j,new String[] {"B"}));
                    colorBlind++;
                }
            }
        }

        System.out.println(normal+" "+colorBlind);
    }

    public static void dfs(Point p) {
        visited[p.x][p.y] = true;

        for(int i=0; i<4; i++) {
            int ni = p.x + di[i];
            int nj = p.y + dj[i];

            if(p.s.length==1) {
                if (ni >= 0 && ni < N && nj >= 0 && nj < N &&
                        !visited[ni][nj] && arr[ni][nj].equals(p.s[0])) {
                    visited[ni][nj] = true;
                    dfs(new Point(ni, nj, p.s));
                }
            } else if (p.s.length==2) {
                if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]
                        && (arr[ni][nj].equals(p.s[0]) || arr[ni][nj].equals(p.s[1]))) {
                    visited[ni][nj] = true;
                    dfs(new Point(ni, nj, p.s));
                }
            }
        }
    }

}

// 엥 근데 생각해보니 애초에 답 구할 때 arr[i][j]="G"이면 arr[i][j]="R"로 바꾸고
// dfs 돌려도 되네.. 후..