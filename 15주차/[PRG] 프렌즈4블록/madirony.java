import java.util.*;
class Solution {
    static char[][] arr;
    static int cnt = 0;
    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = board[i].charAt(j);
            }
        }
        while(check(m,n)){
            dropBlock(m,n);
        }
        int answer = cnt;
        return answer;
    }
    //블럭 아래로
    static void dropBlock(int m, int n){
        for(int i = 0; i < n; i++){
            for(int j = m-1; 0 <= j; j--){
                if(arr[j][i] == 'X'){
                    int k = j - 1;
                    while(0 <= k){
                        if(arr[k][i] != 'X'){
                            arr[j][i] = arr[k][i];
                            arr[k][i] = 'X';
                            break;
                        }
                        k--;
                    }
                }
            }
        }
    }
    
    static boolean check(int m, int n){
        boolean flag = false;
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 0, 1};
        boolean[][] visited = new boolean[m][n];
        //why -1? -> 2x2씩 검사할 것이기 때문..
        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n - 1; j++){
                char mark = arr[i][j];
                if(mark == 'X')
                    continue;
                for(int k = 1; k < 4; k++){
                    if(mark != arr[i+dx[k]][j+dy[k]]){
                        break;
                    }
                    //k방향까지 모든 블럭이 같다?? -> 터지는 블록 계산
                    else if(k == 3){
                        if(!flag)
                            flag = true;
                        for(int l = 0; l < 4; l++){
                            if(!visited[i+dx[l]][j+dy[l]]){
                                visited[i+dx[l]][j+dy[l]] = true;
                                cnt++;
                            }
                        }
                    }
                }
            }
        }
        //pang!
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]){
                    arr[i][j] = 'X';
                }
            }
        }
        return flag;
    }
}