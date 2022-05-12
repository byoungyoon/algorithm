package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2156

public class Dp18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Dp18 dp = new Dp18();
        System.out.println(dp.solution(n, arr));

        sc.close();
    }

    private int solution(int n, int[] arr) {
        int[] dp = new int[10001];
        dp[1] = arr[0];

        if (n <= 1)
            return dp[n];

        dp[2] = arr[0] + arr[1];

        for (int i = 3; i <= arr.length; i++) {
            dp[i] = Math.max(Math.max(dp[i - 3] + arr[i - 2], dp[i - 2]) + arr[i - 1], dp[i - 1]);
        }

        return dp[n];
    }
}
