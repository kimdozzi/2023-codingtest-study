package samsungCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            total += n;
            arr[i] = n;
        }
        Arrays.sort(arr);
        int a = 0, b = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j)
                    continue;
                if (total - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (i == a || i == b)
                continue;
            System.out.println(arr[i]);
        }
    }
}
