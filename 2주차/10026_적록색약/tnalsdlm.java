package algostudy23.weeks2;

import java.io.*;
import java.util.*;

public class bj_Solution_10026_적록색약 {

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		boolean[][] v = new boolean[N][N];
		Queue<Point> que = new LinkedList<>();

		char[][] cbMap = new char[N][N];
		boolean[][] cbV = new boolean[N][N];
		Queue<Point> cbQue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 'G') {
					cbMap[r][c] = 'R';
				} else {
					cbMap[r][c] = map[r][c];
				}

			}
		}
		int cnt = 0;
		int cbCnt = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!v[r][c]) {
					cnt++;
					que.offer(new Point(r, c));
					v[r][c] = true;
					bfs(map, que, v);

				}
				if (!cbV[r][c]) {
					cbCnt++;
					cbV[r][c] = true;
					cbQue.offer(new Point(r, c));
					bfs(cbMap, cbQue, cbV);

				}
			}
		}
		System.out.println(cnt + " " + cbCnt);

	}

	private static void bfs(char[][] m, Queue<Point> q, boolean[][] vist) {
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!check(nr, nc))
					continue;

				if (!vist[nr][nc] && m[nr][nc] == m[cur.r][cur.c]) {
					vist[nr][nc] = true;
					q.offer(new Point(nr, nc));

				}

			}

		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
