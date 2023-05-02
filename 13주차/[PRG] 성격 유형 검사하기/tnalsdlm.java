import java.util.*;

class Solution {
    
    final int[] score = {0,3,2,1,0,1,2,3}; // +1 해주기 구할 때 (0부터 시작이니깐)
    final char[][] mbti = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};  // 성격
    public String solution(String[] survey, int[] choices) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<mbti.length;i++){
            map.put(mbti[i][0],0);
            map.put(mbti[i][1],0);
        }
        
        for(int i=0;i<choices.length;i++){
            char[] ch = survey[i].toCharArray();
            if(choices[i]<=3){ // 앞에꺼
                map.put(ch[0],map.getOrDefault(ch[0],0)+score[choices[i]]);
            }else if(choices[i]>=5){ // 뒤에꺼
                map.put(ch[1],map.getOrDefault(ch[1],0)+score[choices[i]]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<mbti.length;i++){
            if(map.get(mbti[i][0]) >= map.get(mbti[i][1])){
                sb.append(mbti[i][0]);
            }else{
                sb.append(mbti[i][1]);
            }
        }
        
        return sb.toString();
    }
}
