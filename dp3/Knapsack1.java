package dp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7579

public class Knapsack1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] app = new int[N][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                app[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        Knapsack1 test = new Knapsack1();
        System.out.println(test.solution(N, M, app));
    }

    private int solution(int N, int M, int[][] app) {
        int answer = (int) 2e9;

        int[][] dp = new int[N + 1][10001];
        for (int i = 1; i < dp.length; i++) {
            boolean check = false;
            for (int j = 0; j < dp[0].length; j++) {
                if (j >= app[i - 1][1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - app[i - 1][1]] + app[i - 1][0]);
                else
                    dp[i][j] = dp[i - 1][j];

                if (dp[i][j] >= M && !check) {
                    check = true;
                    answer = Math.min(answer, j);
                }
            }
        }

        return answer;
    }
}
