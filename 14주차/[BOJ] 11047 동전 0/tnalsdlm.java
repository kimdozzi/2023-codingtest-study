import java.util.*;
import java.io.*;

public class Main {
	static int[] coin;
	static int[] num;
	static int K;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		v = new boolean[N];
		num = new int[N];
		for (int i = 0; i < coin.length; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int min = 0;
		for (int i = coin.length - 1; i >= 0; i--) {
			if (K >= coin[i]) {
				min += K / coin[i];
				K = K % coin[i];
			}
		}
		System.out.println(min);
	}

}
