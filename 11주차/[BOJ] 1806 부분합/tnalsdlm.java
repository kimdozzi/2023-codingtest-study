import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] sum = new int[N + 1];
		int min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum[0] = 0;
		sum[1] = arr[0];

		for (int i = 1; i < N; i++) {
			sum[i + 1] = arr[i] + sum[i];
		}

		int s = 0;
		int e = 1;

		while (true) {
			if (s == e || e == N + 1)
				break;
			if (sum[e] - sum[s] >= S) {
				min = Math.min(e - s, min);
				s++;
			}
			// 범위보다 작으면 sum[e]- sum[s] <S
			if (sum[e] - sum[s] < S) {
				e++;
			}
		}

		System.out.println(min == Integer.MAX_VALUE ? 0 : min);

	}
}
