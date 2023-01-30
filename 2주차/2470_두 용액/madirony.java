import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = Integer.MAX_VALUE, tmp, tmp_i = 0, tmp_j = 0;
        int i = 0, j = size - 1;
        while(i < j){
            tmp = arr[i] + arr[j];
            if(Math.abs(tmp) < sum) {
                sum = Math.abs(tmp);
                tmp_i = i;
                tmp_j = j;
            }
            if(0 < tmp)
                j--;
            else
                i++;
        }
        bw.write(String.valueOf(arr[tmp_i]) + " " + String.valueOf(arr[tmp_j]));
        bw.flush();
        bw.close();
    }
}