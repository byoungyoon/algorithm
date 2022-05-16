package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1699

public class Dp4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Dp4 dp = new Dp4();
        System.out.println(dp.solution(n));
    }

    private int solution(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - (j * j)] + 1)
                    dp[i] = dp[i - (j * j)] + 1;
            }
        }

        return dp[n];
    }
}
