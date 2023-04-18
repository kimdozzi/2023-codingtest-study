import java.util.*;
class Solution {
    //수용량 / 집 / 배달량 / 픽업량
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dcap = 0, pcap = 0;
        for(int i = n-1; 0 <= i; i--){
            int cnt = 0;
            dcap -= deliveries[i]; pcap -= pickups[i];
            while(true){
                if(0 <= dcap && 0 <= pcap)
                    break;
                dcap += cap;
                pcap += cap;
                cnt++;
              //  System.out.println("gd" + i);
           //     System.out.println(i);
            //    System.out.println(Arrays.toString(deliveries));
           //         System.out.println(Arrays.toString(pickups));
             //                   System.out.println(i + "답" + answer);
            }
            answer += cnt * (i+1) * 2;
        }
        
        return answer;
    }
}