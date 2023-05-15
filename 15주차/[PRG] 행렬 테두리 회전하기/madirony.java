import java.util.*;
class Solution {
    static int[][] arr;
    static int r, c;
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] answer;
    public int[] solution(int rows, int columns, int[][] queries) {
        r = rows;
        c = columns;
        arr = new int[r][c];
        makeArr();
        answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            rotate(i, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }    
    
        return answer;
    }
    static void rotate(int idx, int r1, int c1, int r2, int c2){
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Integer> numArr = new ArrayList<>();
        for(int i = c1; i <= c2; i++){
            list.add(new Node(r1, i));
            numArr.add(arr[r1][i]);
        }
        for(int i = r1 + 1; i <= r2; i++){
            list.add(new Node(i, c2));
            numArr.add(arr[i][c2]);
        }
        for(int i = c2 - 1; c1 <= i; i--){
            list.add(new Node(r2, i));
            numArr.add(arr[r2][i]);
        }
        for(int i = r2 - 1; r1 < i; i--){
            list.add(new Node(i, c1));
            numArr.add(arr[i][c1]);
        }
        numArr.add(0, numArr.remove(numArr.size()-1));
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            Node tmp = list.get(i);
            arr[tmp.x][tmp.y] = numArr.get(i);
            min = Math.min(min, numArr.get(i));
        }
        answer[idx] = min;
    }
    static void makeArr(){
        int n = 1;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = n++;
            }
        }
    }
}