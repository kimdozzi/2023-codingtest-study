package algostudy23.weeks1;

import java.io.*;
import java.util.*;

public class bj_Solution_2178_미로탐색 {

	static class Point {
		int r;
		int c;
		int dist;

		public Point(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static int[][] map;
	static char[][] m;
	static int N, M;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		m = new char[N][M];

		que = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			m[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = m[r][c] - '0';
			}
		}

		que.offer(new Point(0, 0, 1));
		bfs();

	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	private static void bfs() {
		while (!que.isEmpty()) {
			Point cur = que.poll();
			if(cur.r == N-1 && cur.c==M-1) {
				System.out.println(cur.dist);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 1) {
					que.offer(new Point(nr, nc, cur.dist + 1));
					map[nr][nc] = 2;
				}
				
			}

		}
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}

// 전형적인 BFS문제 
// BFS 돌려서 (n,m) 위치에 도달으면 값 출력
