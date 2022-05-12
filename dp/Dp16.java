package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1932

public class Dp16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arrs = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < temp.length; j++) {
                arrs[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Dp16 dp = new Dp16();
        System.out.println(dp.solution(n, arrs));
    }

    private int solution(int n, int[][] arrs) {
        int[][] dp = arrs.clone();

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length - 1; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j];
            }
        }

        return dp[0][0];
    }
}
