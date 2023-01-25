package algostudy23.weeks1;

import java.io.*;
import java.util.*;

public class bj_Solution_2309_일곱난쟁이 {

	static int[] smallPeople;
	static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		smallPeople = new int[9];
		for (int i = 0; i < smallPeople.length; i++) {
			smallPeople[i] = Integer.parseInt(br.readLine());
		}
		selected = new int[8];
		check = false;

		nCr(0, 0);
	}

	static boolean check;

	private static void nCr(int cnt, int start) {
		if (!check && cnt == 7) {
			int sum = 0;
			for (int i = 0; i < selected.length - 1; i++) {
				sum += selected[i];
			}

			if (sum == 100) {
				Arrays.sort(selected);
				for (int i = 1; i < selected.length; i++) {
					System.out.println(selected[i]);
				}
				check = true;
				return;
			}

			return;
		}

		for (int i = start; i < 9; i++) {
			selected[cnt] = smallPeople[i];
			nCr(cnt + 1, i + 1);
		}
	}
}

// nCr 조합으로 풀었음
// 9C7해서 뽑은 배열의 합이 100일 경우 정렬해서 출력한 뒤 return;
// check한 이유는 이미 100이라는 답을 구했기 때문에 더이상 재귀 돌 필요가 없기 때문이다.
