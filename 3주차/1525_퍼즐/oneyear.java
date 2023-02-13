import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
          1 2 3                   0 1 2
          4 5 6                   3 4 5
          7 8 9    (-1,1,3,-3)    6 7 8
     */
    static int ans;
    static int [] di = {-1,1,3,-3};
    static String first="", line="123456780";
    static boolean result;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                first+=st.nextToken();
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(first);
        set.add(first);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                String s = q.poll();
                int idx = s.indexOf("0");

                if(s.equals(line)) {
                    result=true;
                    break;
                }

                for(int i=0; i<4; i++) {
                    int ni = idx + di[i];

                    if((i==0 && idx%3==0 ) || (i==1 && (idx+1)%3==0) ) continue;
                    if(ni>=0 && ni<9) {
                        String ns = change(s, idx, ni);
                        if(!set.contains(ns)) {
                            set.add(ns);
                            q.add(ns);
                        }
                    }
                }
                size--;
            }
            if(result) break;
            ans++;
        }
        if(result) return ans;
        else return -1;
    }

    public static String change(String s, int idx, int ni) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(idx, s.charAt(ni));
        sb.setCharAt(ni, s.charAt(idx));
        return sb.toString();
    }
}