import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]), len = 100001;

        //방문 체크
        boolean[] visited = new boolean[len];
        visited[n] = true;
        int[] arr = new int[len];

        //메모 : bfs에서는 queue 사용
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        //2178 미로탐색 변형
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int[] nextX = {cur - 1, cur + 1, 2 * cur};
            for(int i = 0; i < 3; i++) {
                if(0 <= nextX[i] && nextX[i] < len){
                    if(!visited[nextX[i]]){
                        queue.add(nextX[i]);
                        visited[nextX[i]] = true;
                        arr[nextX[i]] = arr[cur] + 1;
                    }
                }
            }
        }
        bw.write(String.valueOf(arr[k]));
        bw.flush();
        bw.close();
    }
}