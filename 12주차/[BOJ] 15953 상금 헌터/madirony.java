import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = 0;
            if(a != 0){
                if(a == 1)
                    sum += 5000000;
                else if(a == 2 || a == 3)
                    sum += 3000000;
                else if(4 <= a && a <= 6)
                    sum += 2000000;
                else if(7 <= a && a <= 10)
                    sum += 500000;
                else if(11 <= a && a <= 15)
                    sum += 300000;
                else if(16 <= a && a <= 21)
                    sum += 100000;
            }
            if(b != 0){
                if(b == 1)
                    sum += 5120000;
                else if(b == 2 || b == 3)
                    sum += 2560000;
                else if(4 <= b && b <= 7)
                    sum += 1280000;
                else if(8 <= b && b <= 15)
                    sum += 640000;
                else if(16 <= b && b <= 31)
                    sum += 320000;
            }
            System.out.println(sum);
        }
    }
}