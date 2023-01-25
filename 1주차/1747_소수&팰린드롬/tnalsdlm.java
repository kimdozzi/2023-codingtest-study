package algostudy23.weeks1;

import java.io.*;

public class bj_Solution_1747_소수and팰린드롬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[2000000];

		for (int i = 2; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(arr.length); i++) {
			if (arr[i] == 0)
				continue;

			for (int j = i * 2; j < arr.length; j += i) {
				arr[j] = 0;
			}
		}

		int k = N;

		while (true) {
			StringBuilder sb = new StringBuilder();
			if (arr[k] != 0) {
				sb.append(arr[k]);

				if (sb.toString().equals(sb.reverse().toString())) {
					System.out.println(sb.toString());
					return;
				}
			}
			k++;

		}
	}
}

//소수 찾기 + 팰린드롬 찾기 소수 찾기는 10000000이상의 값의 소수를 확인 해야했기 때문에 "에라토스테네스의 체" 사용 (sqrt함수이용) 
//팰린드롬은 현재 소수 값을 StringBuilder에 저장하고, 저장한 값 reverse() 이용해서 값이 같으면 return 해줬음

//1번째 제출 IndexOutOfBoundsException 나왔음 -> 배열의 범위를 1000001로 줬음 하지만 N이 1000000까지라
//같거나 큰 값을 찾아야 했음 그니깐 바로 배열 범위를 초과 하게됨 그래서 배열 범위를 2000000으로 잡아서 문제 해결해줬음 (^_^)
