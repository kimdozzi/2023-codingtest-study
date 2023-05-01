import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] cf1 = new int[101];
		int[] cf2 = new int[65];
		int k = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				if (i == 1) {
					cf1[++k] = 5000000;
				} else if (i == 2) {
					cf1[++k] = 3000000;
				} else if (i == 3) {
					cf1[++k] = 2000000;
				} else if (i == 4) {
					cf1[++k] = 500000;
				} else if (i == 5) {
					cf1[++k] = 300000;
				} else if (i == 6) {
					cf1[++k] = 100000;
				}
			}
		}
		k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < Math.pow(2, i); j++) {
				if (i == 0) {
					cf2[++k] = 5120000;
				} else if (i == 1) {
					cf2[++k] = 2560000;
				} else if (i == 2) {
					cf2[++k] = 1280000;
				} else if (i == 3) {
					cf2[++k] = 640000;
				} else if (i == 4) {
					cf2[++k] = 320000;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println((long) (cf1[a]+cf2[b]));
		}
	}
}
