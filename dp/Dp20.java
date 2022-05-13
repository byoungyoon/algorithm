package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9465

public class Dp20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr;
        StringTokenizer st;

        Dp20 dp = new Dp20();
        for (int i = 0; i < n; i++) {
            int subN = Integer.parseInt(br.readLine());

            arr = new int[2][subN];
            for (int j = 0; j < arr.length; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int z = 0; z < arr[0].length; z++) {
                    arr[j][z] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(dp.solution(subN, arr));
        }
    }

    private int solution(int n, int[][] arr) {
        int[][] dp = new int[2][n + 1];
        dp[0][1] = arr[0][0];
        dp[1][1] = arr[1][0];

        for (int i = 2; i < n + 1; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i - 1];
        }

        return Math.max(dp[0][n], dp[1][n]);
    }
}
