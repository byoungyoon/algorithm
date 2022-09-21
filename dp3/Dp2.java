package dp3;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898

public class Dp2 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = { { 2, 2 } };

        Dp2 test = new Dp2();
        System.out.println(test.solution(m, n, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = 1;
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < dp[0].length; i++) {
            if (map[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            if (map[i][0] == 1)
                break;
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (map[i][j] == 1)
                    continue;

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        return dp[n - 1][m - 1];
    }
}
