package algostudy23.weeks2;

import java.io.*;
import java.util.*;

public class bj_Solution_2470_두용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] solution = new int[N];
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(solution);

		

		int start = 0;
		int end = solution.length - 1;

		int s1 = solution[start];
		int s2 = solution[end];

		int min = Integer.MAX_VALUE;
		while (start != end) {

			if (min > Math.abs(solution[start] + solution[end])) {
				s1 = solution[start];
				s2 = solution[end];

				min = Math.abs(solution[start] + solution[end]);
			}

			if (min == 0)
				break;

			if (solution[start] + solution[end] < 0) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(s1 + " " + s2);

	}
}
