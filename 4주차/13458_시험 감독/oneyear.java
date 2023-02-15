import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,B,C;
    static long ans;
    static int [] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        room = new int [N];
        for(int i=0; i<N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            ans++;
            if( (room[i]-B)>0 ) {
                ans +=(room[i]-B)/C;
                if( (room[i]-B)%C!=0) ans++;
            }
        }
        System.out.println(ans);
    }
}
