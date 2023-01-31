package algostudy23.weeks2;

import java.io.*;
import java.util.*;

public class bj_Solution_1260_DFS와BFS {

	static ArrayList<ArrayList<Integer>> list;
	static boolean[] v;
	static int N, M;
	static StringBuilder sb;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();

		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			list.get(n).add(m);
			list.get(m).add(n);
		}
		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i));
		}
		sb = new StringBuilder();

		v = new boolean[N + 1];
		sb.append(k + " ");
		v[k] = true;

		dfs(k);

		que = new LinkedList<>();
		v = new boolean[N + 1];
		v[k] = true;

		que.offer(k);
		sb.append("\n").append(k+" ");
		bfs();

		System.out.println(sb.toString());

	}

	private static void dfs(int k) {
		for (int i = 0; i < list.get(k).size(); i++) {
			if (!v[list.get(k).get(i)]) {
				v[list.get(k).get(i)] = true;
				sb.append(list.get(k).get(i)).append(" ");
				dfs(list.get(k).get(i));
			}
		}
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int i = 0; i < list.get(cur).size(); i++) {
				if (!v[list.get(cur).get(i)]) {
					v[list.get(cur).get(i)] = true;
					sb.append(list.get(cur).get(i) + " ");
					que.offer(list.get(cur).get(i));
				}
			}
		}
	}
}
