import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int num;
		int dist;

		public Point(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}

	static int a, b;
	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] v;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		v = new boolean[N + 1];
		que = new LinkedList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			list.get(s1).add(s2);
			list.get(s2).add(s1);
		}
		v[a] = true;
		que.offer(new Point(a, 0));

		System.out.println(bfs());

	}

	private static int bfs() {
		while (!que.isEmpty()) {
			Point cur = que.poll();
			if (cur.num == b) {
				return cur.dist;
			}

			for (int i = 0; i < list.get(cur.num).size(); i++) {
				if (!v[list.get(cur.num).get(i)]) {
					v[list.get(cur.num).get(i)] = true;
					que.add(new Point(list.get(cur.num).get(i), cur.dist + 1));
				}

			}
		}
		return -1;

	}
}
