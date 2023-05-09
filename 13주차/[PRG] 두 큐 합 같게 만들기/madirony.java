import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int a : queue1){
            sum1 += a;
            q1.add(a);
        }
        for(int a : queue2){
            sum2 += a;
            q2.add(a);
        }
        while(sum1 != sum2){
            if(q1.isEmpty() || q2.isEmpty() || 600000 < answer){
                answer = -1;
                break;
            }
            if(sum1 < sum2){
                int tmp = q2.poll();
                q1.add(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            }
            else{
                int tmp = q1.poll();
                q2.add(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            }
            answer++;
        }
        return answer;
    }
}