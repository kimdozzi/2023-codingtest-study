package algostudy23.weeks2;

import java.io.*;
import java.util.*;

public class bj_Solution_1012_유기농배추 {

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int T, C, R;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int cnt = 0;

			map = new int[R][C];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int cc = Integer.parseInt(st.nextToken());
				int rr = Integer.parseInt(st.nextToken());
				map[rr][cc] = 1;
			}
			que = new LinkedList<>();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == 1) {
						map[r][c] = 2;
						que.offer(new Point(r, c));
						bfs();
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	static Queue<Point> que;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs() {
		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 1) {
					que.offer(new Point(nr, nc));
					map[nr][nc] = 2;
				}

			}

		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
