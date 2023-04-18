import java.util.*;
class Solution {
    static boolean[] visited;
    static int[] discount = {10,20,30,40};
    static int emolen;
    static int uselen;
    static int[] disemo;
    static int[][] user;
    static int[] emoticon;
    
    static ArrayList<Node> list = new ArrayList<>();
    static class Node implements Comparable<Node>{
        int sign, amount;
        Node(int s, int a){
            this.sign = s;
            this.amount = a;
        }
        @Override
        public int compareTo(Node o){
            if(this.sign == o.sign)
                return Integer.compare(o.amount, this.amount);
            return Integer.compare(o.sign, this.sign);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        emolen = emoticons.length;
        disemo = new int[emolen];
        //전역 변수로
        emoticon = emoticons;
        user = users;
       // for(int i = 0; i < emolen; i++){
            dfs(0);
     //   }
        Collections.sort(list);
        System.out.println(list.get(0).sign + " " + list.get(0).amount);
        answer[0] = list.get(0).sign; answer[1] = list.get(0).amount;
        return answer;
    }
    static void dfs(int cnt){
        if(cnt == emolen){
            int plus = 0;
            int sales = 0;
            for(int j = 0; j < user.length; j++){
                int tmp = 0;
                for(int i = 0; i < disemo.length; i++){
                    if(user[j][0] <= disemo[i]){
                        tmp += (int)(emoticon[i] * (100 - disemo[i]))/100;
                    }
                }
                if(user[j][1] <= tmp){
                    plus++;
                }
                else
                    sales += tmp;
            }
            list.add(new Node(plus, sales));
            System.out.println(plus + " "+ sales);
            return;
        }
        for(int i = 0; i < discount.length; i++){
            disemo[cnt] = discount[i];
            dfs(cnt+1);
        }
        
    }
}