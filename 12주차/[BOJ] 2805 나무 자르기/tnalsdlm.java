import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		long L = 1;
		long R = arr[N - 1];

		while (R >= L) {

			long mid = (L + R) / 2;
			long h = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					h += (arr[i] - mid);
				}
			}
			if (h >= M) {
				L = mid + 1;

			} else {
				R = mid - 1;
			}
		}
		System.out.println(R);
	}
}
