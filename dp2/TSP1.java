package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2098

public class TSP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] direction = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        TSP1 tsp = new TSP1();
        System.out.println(tsp.solution(direction, N));
    }

    static int INF = (int) 2e9;
    static int[][] dp;

    private int solution(int[][] direction, int N) {
        dp = new int[N][1 << N];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        return dfs(N, direction, 0, 1);
    }

    private int dfs(int N, int[][] direction, int curr, int bit) {
        if (bit == (1 << N) - 1) {
            if (direction[curr][0] == 0)
                return INF;
            return direction[curr][0];
        }

        if (dp[curr][bit] != INF) {
            return dp[curr][bit];
        }

        for (int i = 0; i < N; i++) {
            if ((bit & (1 << i)) == 0 && direction[curr][i] != 0) {
                dp[curr][bit] = Math.min(dp[curr][bit], dfs(N, direction, i, bit | (1 << i)) + direction[curr][i]);
            }
        }

        return dp[curr][bit];
    }
}
