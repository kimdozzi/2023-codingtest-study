import java.util.*;
class Solution {
    static LinkedList<String> list = new LinkedList<>();
    static char[] arr = {'A','E', 'I', 'O', 'U'};
    public int solution(String word) {
        for(int i = 1; i <= 5; i++){
            makeStr("", 0, i);
        }
        Collections.sort(list);
        int answer = list.indexOf(word) + 1;
        return answer;
    }
    static void makeStr(String str, int len, int std){
        if(len == std){
            list.add(str);
            return;
        }
        for(int i = 0; i < 5; i++){
            makeStr((str+arr[i]), len+1, std);
        }
    }
}