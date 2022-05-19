package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1937

public class Dp15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dp15 dp = new Dp15();
        System.out.println(dp.solution(N, map));
    }

    static Integer[][] dp;
    static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private int solution(int N, int[][] map) {
        dp = new Integer[N][N];

        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                max = Math.max(dfs(map, i, j), max);
            }
        }

        return max;
    }

    private int dfs(int[][] map, int y, int x) {
        if (dp[y][x] == null) {
            dp[y][x] = 1;

            for (int i = 0; i < direction.length; i++) {
                int nY = y + direction[i][0];
                int nX = x + direction[i][1];

                if (nY < 0 || nX < 0 || nY >= map.length || nX >= map[0].length)
                    continue;
                if (map[nY][nX] <= map[y][x])
                    continue;

                dp[y][x] = Math.max(dp[y][x], dfs(map, nY, nX) + 1);
            }
        }

        return dp[y][x];
    }
}
