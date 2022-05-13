package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11057

public class Dp2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Dp2 dp = new Dp2();
        System.out.println(dp.solution(n));
    }

    static int mod = 10007;

    private long solution(int n) {
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int z = j; z < 10; z++) {
                    dp[i][j] = (dp[i - 1][z] + dp[i][j]) % mod;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }

        return answer % mod;
    }
}
