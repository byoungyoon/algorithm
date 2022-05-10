package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11727

public class Dp9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Dp9 dp = new Dp9();
        System.out.println(dp.solution(n));

        sc.close();
    }

    private int solution(int n) {
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        if (n <= 2)
            return dp[n];

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        return dp[n];
    }
}
