import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            map.put(id_list[i],new HashSet<>());
        }
        
        for(int i=0;i<report.length;i++){
            String[] str = report[i].split(" ");
            
            map.get(str[1]).add(str[0]);
        }
        
        HashMap<String, Integer> sigoCnt = new HashMap<>();
        
        for(String i: map.keySet()){
            if(map.get(i).size()>=k){
               for(String j: map.get(i)){
                   sigoCnt.put(j,sigoCnt.getOrDefault(j,0)+1);
                } 
            }
        }
        int[] answer = new int[id_list.length];
        
        for(int i=0;i<id_list.length;i++){
            if(sigoCnt.containsKey(id_list[i])){
                answer[i] = sigoCnt.get(id_list[i]);
            }
        }
        
        return answer;
    }
}
