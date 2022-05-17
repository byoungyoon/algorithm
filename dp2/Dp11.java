package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1890

public class Dp11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dp11 dp = new Dp11();
        System.out.println(dp.solution(map));
    }

    static Long[][] dp;

    private Long solution(int[][] map) {
        dp = new Long[map.length][map[0].length];
        return onSearch(map, 0, 0);
    }

    private Long onSearch(int[][] map, int y, int x) {
        if (y == map.length - 1 && x == map[0].length - 1) {
            return 1L;
        }

        if (dp[y][x] == null) {
            dp[y][x] = 0L;

            int[][] direction = { { map[y][x], 0 }, { 0, map[y][x] } };
            for (int i = 0; i < direction.length; i++) {
                int nY = direction[i][0] + y;
                int nX = direction[i][1] + x;

                if (nY >= map.length || nX >= map.length)
                    continue;

                dp[y][x] += dp[y][x] + onSearch(map, nY, nX);
            }
        }

        return dp[y][x];
    }
}
