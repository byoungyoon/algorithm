package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1915

public class Dp19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        Dp19 dp = new Dp19();
        System.out.println(dp.solution(N, M, map));
    }

    static int[][] dp;

    private int solution(int N, int M, int[][] map) {
        dp = new int[N + 1][M + 1];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    dp[i + 1][j + 1] = dfs(i + 1, j + 1);
                    answer = Math.max(dp[i + 1][j + 1], answer);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return answer * answer;
    }

    private int dfs(int y, int x) {
        if (dp[y - 1][x] == 0 || dp[y][x - 1] == 0 || dp[y - 1][x - 1] == 0)
            return 1;

        return Math.min(dp[y - 1][x], Math.min(dp[y][x - 1], dp[y - 1][x - 1])) + 1;
    }
}
