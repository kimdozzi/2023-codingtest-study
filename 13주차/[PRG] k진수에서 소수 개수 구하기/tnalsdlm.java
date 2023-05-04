import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
       
        String[] str = Integer.toString(n,k).split("0");
        System.out.println(Arrays.toString(str));
        a:for(int i=0;i<str.length;i++){
            if(str[i].equals("") || str[i].equals("1")) continue;
            long num = Long.parseLong(str[i]);
             
            for(int j=2;j<=Math.sqrt(num);j++){
                if(num%j==0) continue a;
            }
            answer++;        
        }
        return answer;
    }
}
