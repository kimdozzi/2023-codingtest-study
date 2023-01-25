package algostudy23.weeks1;

import java.io.*;
import java.util.*;

public class bj_Solution_1759_암호만들기 {

	static int L, C;
	static String[] selected;
	static String[] encryption;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		selected = new String[L];
		v = new boolean[C];
		encryption = br.readLine().split(" ");
		ans = new StringBuilder();

		Arrays.sort(encryption);

		nPr(0);
		System.out.println(ans.toString().trim());

	}

	static StringBuilder ans;

	private static void nPr(int cnt) {
		if (cnt == L) {
			int count = 0;

			for (int i = 0; i < selected.length; i++) {
				if (selected[i].contains("a") || selected[i].contains("e") || selected[i].contains("i") // stream으로 풀기!!
						|| selected[i].contains("o") || selected[i].contains("u")) {
					count++;
				}
			}

			if (count >= 1 && L - count >= 2) {
				for (int i = 0; i < selected.length; i++) {
					ans.append(selected[i]);
				}
				ans.append("\n");
			}
			return;
		}

		for (int i = 0; i < C; i++) {
			if (v[i])
				continue;

			if (cnt >= 1 && selected[cnt - 1].charAt(0) - encryption[i].charAt(0) > 0) {
				continue;
			}

			selected[cnt] = encryption[i];
			v[i] = true;
			nPr(cnt + 1);
			v[i] = false;
		}
	}
}

// cPl로 순열 구해준 다음에
// a,e,i,o,u 가 뽑은 순열에 몇개가 들어가있는지 세어주고 (가지치기 포함)
// count>=1 && L-count >=2 조건 만족 시 StringBuilder에 저장해주고 출력해주기!!

// 1차 도전 nPr 시간초과
// 2차 도전 15P15는 계산해보니 1000억 정도 값임... 그래서 시초 난듯.. -> 그래서 백트레킹 해줬음... 돌기전에 자기 자신보다 큰 애가 먼저 나오게 된다면.. 가지치기 해줬음
