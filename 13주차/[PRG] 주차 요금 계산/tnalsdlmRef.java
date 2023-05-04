import java.util.*;
class Solution {
 
    final int lastTime = (23*60) + 59;
    public int[] solution(int[] fees, String[] records) {
        
        TreeMap<String, Integer> tm = new TreeMap<>();
        // 분단위로 환산 -> 시 * 60 + 분
        for(int i=0;i<records.length;i++){
            String[] carInfo = records[i].split(" ");
            String[] t = carInfo[0].split(":");
            
            int time = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
            
            int b = carInfo[2].equals("IN")? -1:1;
            
            tm.put(carInfo[1],tm.getOrDefault(carInfo[1],0)+(time*b));

        }
        int[] answer = new int[tm.size()];
        
        int j = 0;
        for(Integer i: tm.values()){
            if(i<1) i+=lastTime;
            int money = 0;
            money = fees[1];
            if(fees[0]<i){
                i-=fees[0];
                money += (i%fees[2]==0? i/fees[2]:i/fees[2]+1) *fees[3];
            }
            answer[j++] = money;
        }
        
        return answer;
    }
}
