package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11726

public class DP7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DP7 dp = new DP7();
        System.out.println(dp.solution(n) % 10007);

        sc.close();
    }

    private int solution(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        if (n <= 1)
            return dp[0];

        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10700;
        }

        return dp[n - 1];
    }
}
