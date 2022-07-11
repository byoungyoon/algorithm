package dp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9084

public class Knapsack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Knapsack2 test = new Knapsack2();
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());

            int[] moneys = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                moneys[j] = Integer.parseInt(st.nextToken());
            }
            int result = Integer.parseInt(br.readLine());
            System.out.println(test.solution(moneys, result));
        }
    }

    private int solution(int[] moneys, int result) {
        int[] dp = new int[result + 1];
        dp[0] = 1;

        for (int money : moneys) {
            for (int i = money; i <= result; i++) {
                dp[i] += dp[i - money];
            }
        }

        return dp[result];
    }
}
