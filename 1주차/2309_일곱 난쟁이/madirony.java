import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[9];
        //정렬
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        //제외 수
        int ex1 = 0, ex2 = 1;
        label:
        while(ex1 < 8){
            while(ex2 < 9){
                int sum = 0;
                for(int i = 0; i < 9; i++){
                    if(i != ex1 && i != ex2){
                        sum += num[i];
                    }
                }
                if(sum == 100)
                    break label;
                ex2++;
            }
            ex1++;
            ex2 = ex1 + 1;
        }

        for(int i = 0; i < 9; i++){
            if(i != ex1 && i != ex2){
                bw.write(String.valueOf(num[i])+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}