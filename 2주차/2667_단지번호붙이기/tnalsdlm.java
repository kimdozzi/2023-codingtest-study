package algostudy23.weeks2;

import java.io.*;
import java.util.*;

public class bj_Solution_2667_단지번호붙이기 {

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	static int N;
	static Queue<Point> que;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int cnt;
	static int house;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		que = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			char[] ch = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = ch[c] - '0';
			}
		}
		cnt = 2;
		list = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					que.offer(new Point(r, c));
					map[r][c] = cnt;
					house = 1;
					bfs();
					cnt++;
				}

			}
		}

		System.out.println(cnt - 2);
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			Point cur = que.poll();

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + cur.r;
				int nc = dc[d] + cur.c;

				if (!check(nr, nc))
					continue;

				if (map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					house++;
					que.offer(new Point(nr, nc));

				}
			}
		}
		list.add(house);

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
