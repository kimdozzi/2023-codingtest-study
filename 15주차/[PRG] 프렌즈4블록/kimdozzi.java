import java.util.*;

class Solution {
    static class Pair {
        public int x;
        public int y;

        public Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    static int cnt = 0;
    static boolean[][] visited;
    static int[][] dir = { { 0, 0 }, { 1, 1 }, { 1, 0 }, { 0, 1 } };
    static Queue<Pair> q = new LinkedList<>();
    static char[][] grid;

    public int solution(int m, int n, String[] board) {
        grid = new char[m][n];

        // 판 만들기
        for (int i = 0; i < m; i++) {
            String tmp = board[i];
            for (int j = 0; j < n; j++) {
                grid[i][j] = tmp.charAt(j);
            }
        }
        boolean flag = false;
        // 일단 종료조건은 없지만, 모든 블록을 탐색하면서 4개짜리 구하기
        while (!flag) {
            int result = 0;
            visited = new boolean[m][n]; // 한 서클을 돌 때 마다 초기화해줘야 함.
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 4개짜리가 있다면
                    if (check(i, j, m, n) > 0) {
                        // 해당 좌표 저장
                        q.add(new Pair(i, j));
                    }
                }
            }
            while (!q.isEmpty()) {
                Pair p = q.poll();
                result += remove(p.x, p.y, m, n);
                System.out.println(p.x + " " + p.y);
            }
            if (result > 0) {
                rebuildingBoard(m, n, visited, grid);
            } else
                flag = true;

            cnt += result;
        }
        return cnt;
    }

    // 블록 다시 만드는 함수
    static public void rebuildingBoard(int m, int n, boolean[][] visited, char[][] grid) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j])
                    grid[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (grid[j][i] == '.') {
                } else {
                    q.add(grid[j][i]);
                }
            }
            int idx = m - 1;
            while (!q.isEmpty()) {
                grid[idx--][i] = q.poll();
            }
            for (int j = idx; j >= 0; j--) {
                grid[j][i] = '#';
            }
        }
    }

    // 블록 지우는 함수
    static public int remove(int x, int y, int m, int n) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (0 > nx || nx >= m || 0 > ny || ny >= n)
                continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                res++;
            }
        }
        return res;
    }

    // 4개가 만들어지는 지 체크하는 함수
    static public int check(int x, int y, int m, int n) {
        char compareStr = grid[x][y];
        int cnt = 1;
        for (int i = 1; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (0 > nx || nx >= m || 0 > ny || ny >= n)
                continue;
            if (grid[nx][ny] == '#')
                continue;
            if (compareStr == grid[nx][ny])
                cnt++;
        }
        if (cnt == 4)
            return 1;
        else
            return -1;
    }
}