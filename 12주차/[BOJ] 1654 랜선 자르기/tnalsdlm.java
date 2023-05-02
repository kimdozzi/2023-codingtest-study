import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		long L = 1;
		long R = arr[K - 1];

		while (R >= L) {
			long mid = (L + R) / 2;
			long len = 0;
			for (int i = 0; i < arr.length; i++) {
				len += (arr[i] / mid);
			}
			if (len >= N) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(R);

	}
}
