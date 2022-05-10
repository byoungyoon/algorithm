package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9461

public class Dp8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dp8 dp = new Dp8();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(dp.solution(sc.nextInt()));
        }

        sc.close();
    }

    private long solution(int num) {
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        if (num <= 5)
            return dp[num];

        for (int i = 6; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        return dp[num];
    }
}
