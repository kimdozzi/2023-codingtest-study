package algostudy23.weeks2;

import java.io.*;
import java.util.*;

public class bj_Solution_7576_토마토 {

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int M, N;
	static int[][] map;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		// 4방탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		que = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					que.offer(new Point(r, c));

				}
			}
		}

		bfs();
		int max = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					System.out.println(-1);
					return;
				} else {
					max = Math.max(max, map[r][c]);
				}
			}
		}
		System.out.println(max - 1);

	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	private static void bfs() {
		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 0) {
					map[nr][nc] = map[cur.r][cur.c] + 1;
					que.offer(new Point(nr, nc));

				}

			}
		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
