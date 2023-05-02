import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //신고
        boolean[][] rep = new boolean[id_list.length][id_list.length];
        //누적 
        int[] repSum = new int[id_list.length];
        //받은 메일 수
        int[] answer = new int[id_list.length];
        for(int i = 0; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i], " ");
            String a = st.nextToken();
            String b = st.nextToken();
            int idx1 = findIdx(id_list, a);
            int idx2 = findIdx(id_list, b);
            if(!rep[idx1][idx2]){
                rep[idx1][idx2] = true;
                repSum[idx2]++;
            }
        }
        //초기화
        rep = new boolean[id_list.length][id_list.length];
        for(int i = 0; i < report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i], " ");
            String a = st.nextToken();
            String b = st.nextToken();
            int idx1 = findIdx(id_list, a);
            int idx2 = findIdx(id_list, b);
            if(!rep[idx1][idx2] && k <= repSum[idx2]){
                rep[idx1][idx2] = true;
                answer[idx1]++;
            }
        }
        return answer;
    }
    static int findIdx(String[] id, String a){
        for(int i = 0; i < id.length; i++){
            if(id[i].equals(a))
                return i;
        }
        return -1;
    }
}