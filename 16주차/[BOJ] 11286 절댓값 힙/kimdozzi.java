import java.io.*;
import java.util.*;

public class Main { // IDE없이 문제푸는 연습장
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Queue<Integer> mnPq = new PriorityQueue<>(); // 양수를 담을 최소 힙
		Queue<Integer> mxPq = new PriorityQueue<>(Collections.reverseOrder()); // 음수를 담을 최대 힙

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				// 둘다 비어있을 때
				if (mnPq.isEmpty() && mxPq.isEmpty()) {
					System.out.println(0);
					continue;
				}
				// 음수만 존재할 때
				else if (mnPq.isEmpty()) {
					int remove = mxPq.poll();
					System.out.println(remove);
				}
				// 양수만 존재할 때
				else if (mxPq.isEmpty()) {
					int remove = mnPq.poll();
					System.out.println(remove);
				}
				// 둘 다 존재할 때
				else {
					if (Math.abs(mxPq.peek()) <= Math.abs(mnPq.peek())) {
						int remove = mxPq.poll();
						System.out.println(remove);
					} else {
						int remove = mnPq.poll();
						System.out.println(remove);
					}
				}

			} else {
				// 양수
				if (num > 0) {
					mnPq.add(num);
				}
				// 음수
				else {
					mxPq.add(num);
				}
			}

		}

	}
}