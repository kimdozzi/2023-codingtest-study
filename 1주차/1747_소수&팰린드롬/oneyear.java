import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747_소수팰린드롬 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=N; N<1000001; i++ ) {
            if(N==1 || N==2) {
                System.out.println(2);
                return;
            }
            else if(prime(i) && palindrome(String.valueOf(i))) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean prime(int x) {
        for(int i=2; i<Math.sqrt(x)+1; i++) {
            if(x%i==0) return false;
        }
        return true;
    }

    public static boolean palindrome(String s) {
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }


}
