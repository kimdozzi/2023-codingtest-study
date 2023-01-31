import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309_일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int [9];
        int [] no = new int [2];
        int add =0;

        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            add += arr[i];
        }

        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if((add-100)==arr[i]+arr[j]) {
                    no[0]=arr[i];
                    no[1]=arr[j];
                    break;
                }
            }
        }

        Arrays.sort(arr);
        for(int i=0; i<9; i++) {
            if(no[0]==arr[i] || no[1]==arr[i]) continue;
            System.out.println(arr[i]);
        }

    }
}
