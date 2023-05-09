import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0;i<queue1.length;i++){
            que1.offer(queue1[i]);
            sum1+=queue1[i];
        }
        for(int i=0;i<queue2.length;i++){
            que2.offer(queue2[i]);
            sum2+=queue2[i];
        }
        
        int size = Math.max(queue1.length, queue2.length) *3;
        
        while(size-->0){
            if(sum1 == sum2){
                return answer;
            }
            
            if(sum1>sum2){
                int num = que1.poll();
                sum1-=num;
                sum2+=num;
                que2.offer(num);
            }else if(sum1<sum2){
                int num = que2.poll();
                sum2-=num;
                sum1+=num;
                que1.offer(num);
            }
            answer++;        
        }
        return -1;
    }
}
