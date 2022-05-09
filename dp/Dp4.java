package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1463

public class Dp4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Dp4 dp = new Dp4();
        System.out.println(dp.solution(n));

        sc.close();
    }

    private int solution(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
        }

        return dp[n];
    }
}