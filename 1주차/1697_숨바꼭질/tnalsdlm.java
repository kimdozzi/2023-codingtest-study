package algostudy23.weeks1;

import java.io.*;
import java.util.*;

public class bj_Solution_1697_숨바꼭질 {
	static class Point {
		int idx;
		int dist;

		public Point(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
	}

	static int N, K;
	static int[] arr;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[100001];

		Arrays.fill(arr, Integer.MAX_VALUE);

		que = new LinkedList<>();

		arr[N] = 0;
		que.offer(new Point(N, 0));
		bfs();

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			Point cur = que.poll();
			if (cur.idx == K) {
				System.out.println(cur.dist);
				break;
			}

			int nr = cur.idx + 1;
			move(nr, cur);

			nr = cur.idx - 1;
			move(nr, cur);

			nr = cur.idx * 2;

			move(nr, cur);
		}
	}

	private static void move(int nr, Point cur) {
		if (check(nr) && (arr[nr] > cur.dist + 1)) {
			que.offer(new Point(nr, cur.dist + 1));
			arr[nr] = cur.dist + 1;
		}
	}

	private static boolean check(int nr) {
		return nr >= 0 && nr < arr.length;
	}
}
// 1. r배열 (수빈, 동생 위치를 알기위한 배열) -> 배열 초기화 INF
// 2. Point 객체 사용
// 3. queue에 초기값 넣어주기
// 4. BFS 돌리기
//    que에 값 넣기 전, x-1, x+1, 2*x값이 r배열 위치 값보다 작을 경우 넣어주고 그 배열값 갱신해주기

// check 하는 메서드에서 nr의 범위를 100001까지 줘버림 당연 IndexOutOfBounds남
