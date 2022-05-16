package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1520

public class Dp6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dp6 dp = new Dp6();
        System.out.println(dp.solution(map));
    }

    static int[][] direction = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
    static int[][] dp;

    private int solution(int[][] map) {
        dp = new int[map.length][map[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(map, 0, 0);
    }

    private int dfs(int[][] map, int y, int x) {
        if (y == map.length - 1 && x == map[0].length - 1) {
            return 1;
        }

        if (dp[y][x] != -1)
            return dp[y][x];

        dp[y][x] = 0;

        for (int i = 0; i < direction.length; i++) {
            int nY = y + direction[i][0];
            int nX = x + direction[i][1];

            if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length)
                continue;

            if (map[nY][nX] >= map[y][x])
                continue;

            dp[y][x] += dfs(map, nY, nX);
        }

        return dp[y][x];
    }
}
