import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] first = new int[] { 1, 3, 6, 10, 15, 21 };
        int[] second = new int[] { 1, 3, 7, 15, 31 };
        int[] fArr = new int[] { 0, 5000000, 3000000, 2000000, 500000, 300000, 100000 };
        int[] sArr = new int[] { 0, 5120000, 2560000, 1280000, 640000, 320000 };
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = 0, y = 0;
            if (1 <= a && a <= 21) {
                for (int i = 0; i < first.length; i++) {
                    if (a <= first[i]) {
                        x = i + 1;
                        break;
                    }
                }
            }
            if (1 <= b && b <= 31) {
                for (int i = 0; i < second.length; i++) {
                    if (b <= second[i]) {
                        y = i + 1;
                        break;
                    }
                }
            }
            System.out.println(fArr[x] + sArr[y]);
        }
    }
}
