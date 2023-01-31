import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int num = Integer.parseInt(input);
        //++예외 추가 n==1 / n==1,000,000일 경우
        if(num == 1){
            bw.write(String.valueOf(2));
            bw.flush();
            bw.close();
            return;
        }
        for(int i = num; i <= 10000000; i++){
            //시간초과..?
            if(palindrome(i)){
                if(prime(i)){
                    bw.write(String.valueOf(i));
                    break;
                }
            }
        }
        bw.flush();
        bw.close();

    }

    //소수
    static boolean prime(int value){
        for(int i = 2; i <= value/2; i++){
            if(value % i == 0)
                return false;
        }
        return true;
    }
    //팰린드롬
    static boolean palindrome (int value){
        String checkStr = String.valueOf(value);
        int valueLen = checkStr.length();

        for(int i = 0; i < valueLen / 2; i++) {
            if (checkStr.charAt(i) != checkStr.charAt(valueLen - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}