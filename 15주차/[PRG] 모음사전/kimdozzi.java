import java.util.*;
import java.io.*;

class Solution {
    static int cnt = 0;
    static String[] arr = {"A","E","I","O","U"};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        rec_func(word, "", 0);
        Collections.sort(list);
        return list.indexOf(word);
    }
    
    static void rec_func(String word, String str, int depth) {
        list.add(str);
        if(depth == 5) { 
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                rec_func(word, str + arr[i], depth + 1);
            }
        }
    } 
}
