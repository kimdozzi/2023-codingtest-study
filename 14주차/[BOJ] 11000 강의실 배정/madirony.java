import java.io.*;
import java.util.*;
public class Main {
    //7:55 - 8:20
    static class Node implements Comparable<Node>{
        int s;
        int t;
        Node(int s, int t){
            this.s = s;
            this.t = t;
        }
        @Override
        public int compareTo(Node o){
            if(this.s == o.s){
                return Integer.compare(this.t, o.t);
            }
            return Integer.compare(this.s, o.s);
        }
    }
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Node a : list){
                if(!pq.isEmpty()){
                    if((pq.peek() <= a.s))
                        pq.poll();
                }
                pq.add(a.t);
        }
        System.out.println(pq.size());
    }
}