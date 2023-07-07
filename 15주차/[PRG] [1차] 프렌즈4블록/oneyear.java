import java.io.*;
import java.util.*;

class Solution {
    static int n,m,ans;
    static String [][] arr;
    static boolean [][] visited;

    public int solution(int n, int m, String[] board) {
        arr = new String [n][m];

        for(int i=0; i<n; i++) {
            char [] ch = board[i].toCharArray();
            for(int j=0; j<m; j++) {
                arr[i][j] = String.valueOf(ch[j]);
            }
        }

        while(true) {
            boolean check = false;
            visited = new boolean [n][m];

            for(int i=0; i<n-1; i++) {
                for(int j=0; j<m-1; j++) {
                    String st = arr[i][j];
                    if(st.equals(".")) continue;

                    if(arr[i+1][j].equals(st) && arr[i+1][j+1].equals(st) && arr[i][j+1].equals(st)) {
                        check = true; visited[i][j]=true; visited[i+1][j]=true;
                        visited[i+1][j+1]=true; visited[i][j+1]=true;
                    }
                }
            }
            if(!check) break;

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(visited[i][j]) {
                        ans++;
                        arr[i][j]=".";
                    }
                }
            }

            for(int j=0; j<m; j++) {
                for(int i=n-2; i>=0; i--) {
                    if(arr[i][j].equals(".")) continue;

                    boolean first = false;
                    for(int k=i+1; k<n; k++) {
                        if(arr[k][j].equals(".")) { // "" 의 경우
                            if(!first) {
                                if(k==n-1) {
                                    arr[k][j]=arr[i][j];
                                    arr[i][j]=".";
                                } else first=true;
                            } else if (k==n-1) {
                                arr[k][j]=arr[i][j];
                                arr[i][j]=".";
                            } else continue;
                        } else {                   // 다른  블록이 있는 경우
                            if(!first) break;
                            arr[k-1][j]=arr[i][j];
                            arr[i][j]=".";
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}