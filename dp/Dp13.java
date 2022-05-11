package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12865

public class Dp13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int[][] things = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        Dp13 dp = new Dp13();
        System.out.println(dp.solution(weight, things));
    }

    private int solution(int weight, int[][] things) {
        int[][] dp = new int[things.length][weight + 1];

        for (int i = 1; i <= weight; i++) {
            for (int j = 0; j < things.length; j++) {
                if (j == 0) {
                    if (things[j][0] > i) {
                        dp[j][i] = 0;
                    } else {
                        dp[j][i] = things[j][1];
                    }
                    continue;
                }

                if (things[j][0] > i) {
                    dp[j][i] = dp[j - 1][i];
                    continue;
                }

                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - things[j][0]] + things[j][1]);
            }
        }

        return dp[things.length - 1][weight];
    }

}
