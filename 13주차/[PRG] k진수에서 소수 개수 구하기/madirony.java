import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String str = ari(n, k);
        StringTokenizer st = new StringTokenizer(str, "0");
        int answer = 0;
        while(st.hasMoreTokens()){
            long num = Long.parseLong(st.nextToken());
            if(isPrime(num) && num != 1)
                answer++;
        }
        return answer;
    }
    static boolean isPrime(long n){
        for(long i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    static String ari(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(0 < n){
            int tmp = n % k;
            sb.insert(0, String.valueOf(tmp));
            n /= k;
        }
        return String.valueOf(sb);
    }
}