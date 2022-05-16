package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2133

public class Dp5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Dp5 dp = new Dp5();
        System.out.println(dp.solution(n));
    }

    private int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 2; i < dp.length; i = i + 2) {
            for (int j = i - 2; j >= 0; j = j - 2) {
                if (j == i - 2) {
                    dp[i] += dp[j] * 3;
                } else {
                    dp[i] += dp[j] * 2;
                }
            }
        }

        return dp[n];
    }
}
