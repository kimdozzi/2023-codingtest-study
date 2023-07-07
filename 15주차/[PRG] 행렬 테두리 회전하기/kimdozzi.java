import java.util.*;

class Solution {
    /*
     * for(int i=1; i<=rows; i++) {
     * for(int j=1; j<=columns; j++) {
     * System.out.print(grid[i][j] + " ");
     * }
     * System.out.println();
     * }
     */
    static int[][] grid;
    static int[] ans;

    public int[] solution(int rows, int columns, int[][] queries) {
        grid = new int[rows + 1][columns + 1];
        int cnt = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                grid[i][j] = cnt++;
            }
        }
        ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            int d = queries[i][3];
            int mn = 1000000;
            ans[i] = rotateArray(a, b, c, d, mn);
        }
        return ans;

    }

    static public int rotateArray(int a, int b, int c, int d, int mn) {
        int temp = grid[a][b]; // 제일 처음 꺼 빼둠
        for (int i = a; i < c; i++) { // 아래 -> 위
            grid[i][b] = grid[i + 1][b];
            mn = Math.min(mn, grid[i][b]);
        }
        for (int i = b; i < d; i++) { // 오른쪽 -> 왼쪽
            grid[c][i] = grid[c][i + 1];
            mn = Math.min(mn, grid[c][i]);
        }
        for (int i = c; i > a; i--) {
            grid[i][d] = grid[i - 1][d]; // 위 -> 아래
            mn = Math.min(mn, grid[i][d]);
        }
        for (int i = d; i > b + 1; i--) {
            grid[a][i] = grid[a][i - 1]; // 왼쪽 -> 오른쪽
            mn = Math.min(mn, grid[a][i]);
        }
        grid[a][b + 1] = temp; // 처음꺼 다시 넣음
        mn = Math.min(mn, grid[a][b + 1]);

        return mn;
    }
}
