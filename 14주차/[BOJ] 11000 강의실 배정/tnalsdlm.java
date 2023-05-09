import java.util.*;
import java.io.*;

public class Main {
	static class Point implements Comparable<Point> {
		int s;
		int t;

		public Point(int s, int t) {
			this.s = s;
			this.t = t;
		}

		public int compareTo(Point o) {
			return Integer.compare(this.t, o.t);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>();
		int[][] cr = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cr[i][0] = Integer.parseInt(st.nextToken());
			cr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cr, (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		});

		for (int i = 0; i < cr.length; i++) {
			if (!pq.isEmpty()) {

				Point pk = pq.peek();

				if (cr[i][0] >= pk.t) {
					pq.poll();
				}
			}
			pq.offer(new Point(cr[i][0], cr[i][1]));
		}
		System.out.println(pq.size());

	}

}
