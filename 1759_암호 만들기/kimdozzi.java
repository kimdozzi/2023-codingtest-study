package samsungCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759 {

    static boolean check(String password) {
        int vowel = 0; // 모음
        int consonant = 0;// 자음
        for (char arr : password.toCharArray()) {
            if (arr == 'a' || arr == 'e' || arr == 'i' || arr == 'o' || arr == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        return vowel >= 1 && consonant >= 2;
    }

    static void go(int n, String[] alpha, String password, int index) {
        if (password.length() == n) {
            if (check(password)) {
                System.out.println(password);
            }
            return;

        }

        if (index >= alpha.length) {
            return;
        }

        go(n, alpha, password + alpha[index], index + 1);
        go(n, alpha, password, index + 1);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();

        String[] alpha = new String[C];

        for (int i = 0; i < C; i++) {
            alpha[i] = sc.next();
        }

        Arrays.parallelSort(alpha);

        go(L, alpha, "", 0);

    }

}