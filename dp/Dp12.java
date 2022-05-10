package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1904

public class Dp12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Dp12 dp = new Dp12();
        System.out.println(dp.solution(n));

        sc.close();
    }

    private int solution(int n) {
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;

        if (n <= 2)
            return dp[n];

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        return dp[n];
    }
}
