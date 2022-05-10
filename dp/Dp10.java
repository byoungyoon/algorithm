package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2193

public class Dp10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Dp10 dp = new Dp10();
        System.out.println(dp.solution(n));

        sc.close();
    }

    private long solution(int n) {
        long[] dp = new long[91];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
