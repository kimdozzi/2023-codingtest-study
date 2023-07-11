import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int p1 = 0;
		int p2 = 0;
		int hal = 0;
		int zak = 0;
		int answer = 0;

		while (p2 < N) {
			if (arr[p2] % 2 != 0) {
				hal++;
			} else {
				zak++;
			}

			answer = Math.max(answer, zak);
			if (hal > K) {
				if (arr[p1] % 2 != 0) {
					hal--;
				} else {
					zak--;
				}
				p1++;
			}
			p2++;
		}
		System.out.println(answer);

	}
}
