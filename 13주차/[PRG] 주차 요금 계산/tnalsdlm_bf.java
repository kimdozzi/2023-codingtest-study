import java.util.*;
class Solution {
 
    final int lastTime = (23*60) + 59;
    TreeMap<String, Integer> tm = new TreeMap<>();
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        // 분단위로 환산 -> 시 * 60 + 분
        for(int i=0;i<records.length;i++){
            String[] carInfo = records[i].split(" ");
            String[] t = carInfo[0].split(":");
            
            int time = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
            
            if(!map.containsKey(carInfo[1])){
                map.put(carInfo[1],new ArrayList<>());
            }
            map.get(carInfo[1]).add(time);
        }
        int[] answer = new int[map.size()];
        

        for(String i: map.keySet()){
            if(map.get(i).size()%2==1){ // 23:59 까지 차를 안뺀거임
                int time = 0;
            for(int j=0;j<map.get(i).size();j+=2){
                int in  = map.get(i).get(j);
                
                if(j== map.get(i).size()-1){
                    time += (lastTime - in);
                    break;
                }
                int out = map.get(i).get(j+1);
                time+= (out - in);
            }
                getFee(i, time,fees);
            }else{
                 int time = 0;
                for(int j=0;j<map.get(i).size();j+=2){
                    int in  = map.get(i).get(j);
                    int out = map.get(i).get(j+1);
                    // 시간, 입출차 정보
                    time+= (out - in);
            }  
                getFee(i,time,fees);
            }
        }
        int j = 0;
        for(String i: tm.keySet()){
            answer[j++] = tm.get(i);
        }
        
        return answer;
        }
    private void getFee(String num, int time, int[] fees){
        if(fees[0]>=time){
            tm.put(num, fees[1]);
        }else{
            time-=fees[0];
            int money = fees[1];
            
            if(time%fees[2]!=0){ // 올림 처리해야함
                double c = (double)time/ (double) fees[2];
                
                money+= (int)Math.ceil(c) * fees[3];
                
            }else{ // 나누어 떨어지면 그냥 나누면 됨
                money+= (time/fees[2]) *fees[3];
            }
            
            tm.put(num, money);
        }
    }
}
