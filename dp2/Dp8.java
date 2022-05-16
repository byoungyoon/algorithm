package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2225

public class Dp8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Dp8 dp = new Dp8();
        System.out.println(dp.solution(n, k));
    }

    private long solution(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < k + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = (j == 1 ? dp[i - 1][j] + dp[i][j - 1] + 1 : dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }

        return dp[k][n];
    }
}
