package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2096

public class Dp13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dp13 dp = new Dp13();
        int[] answer = dp.solution(map);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private int[] solution(int[][] map) {
        int[][][] dp = new int[map.length + 1][3][2];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][2][0] = Math.max(dp[i - 1][1][0], dp[i - 1][2][0]);
            dp[i][1][0] = Math.max(dp[i][0][0], dp[i][2][0]);

            dp[i][0][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][2][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1]);
            dp[i][1][1] = Math.min(dp[i][0][1], dp[i][2][1]);

            for (int j = 0; j < 3; j++) {
                dp[i][j][0] += map[i - 1][j];
                dp[i][j][1] += map[i - 1][j];
            }
        }

        int[] answer = { Math.max(dp[map.length][0][0], Math.max(dp[map.length][1][0], dp[map.length][2][0])),
                Math.min(dp[map.length][0][1], Math.min(dp[map.length][1][1], dp[map.length][2][1])) };
        return answer;
    }
}
