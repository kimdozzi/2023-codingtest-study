import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine()), n, m;
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for(int j = 0; j < m; j++)
                br.readLine();
            bw.write(String.valueOf(n-1) + "\n");
        }
        bw.flush();
        bw.close();

    }
}