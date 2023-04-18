import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int answer = 0;

		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		arr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		sum[0] = arr[0];
		sum[1] = arr[1];

		if (N > 1) {
			for (int i = 1; i < sum.length; i++) {
				sum[i] = sum[i - 1] + arr[i];
			}
		} else {
			if (sum[1] == M) {
				System.out.println(1);
				return;
			}

		}

		for (int i = 1; i < sum.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (sum[i] - sum[j] > M || sum[i] - sum[j] == 0) {
					break;
				}
				if (sum[i] - sum[j] == M) {
					answer++;
					break;
				}

			}
		}
		System.out.println(answer);

	}
}
