import java.io.*;
import java.util.Arrays;

public class Main {
    static int L, C;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]); C = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        arr = new char[C];
        for(int i = 0; i < C; i++){
            arr[i] = input[i].charAt(0);
        }
        Arrays.sort(arr);
        tmp = new char[L];
        password(0, 0);
        bw.close();
    }

    static char[] tmp;
    //암호 만들기
    static void password(int index, int size){
        //암호 길이가 충분할 때,
        if(size == L){
            String pwd = "";
            for(int i = 0; i < L; i++)
                pwd += tmp[i];
            if(isPass(pwd)){
                System.out.println(pwd);
            }
            return;
        }
        for(int i = index; i < C; i++){
            tmp[size] = arr[i];
            password(i + 1, size + 1);
        }
    }
    //모음 체크
    static boolean checkVowel(String str){
        return str.matches(".*[aeiou].*");
    }
    //자음 체크
    static boolean isPass(String str){
        if(checkVowel(str)){
            int i = 0, cnt = 0;
            while(i < str.length()){
                if(!checkVowel(String.valueOf(str.charAt(i))))
                    cnt++;
                i++;
            }
            return 2 <= cnt;
        }
        return false;
    }

}