import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Main test = new Main();
        System.out.println(test.solution(N, map));
    }

    static Integer[][] dp;
    static int INF = 16000000;

    private int solution(int N, int[][] map) {
        dp = new Integer[N + 1][1 << N];

        return dfs(map, N, 1, 1);
    }

    private int dfs(int[][] map, int N, int visited, int curr) {
        if (visited == (1 << N) - 1) {
            return map[curr][1] == 0 ? INF : map[curr][1];
        }

        if (dp[curr][visited] == null) {
            dp[curr][visited] = INF;

            for (int i = 1; i <= N; i++) {
                if (map[curr][i] == 0 || ((1 << (i - 1)) & visited) != 0)
                    continue;
                dp[curr][visited] = Math.min(dp[curr][visited],
                        dfs(map, N, (1 << (i - 1)) | visited, i) + map[curr][i]);
            }
        }

        return dp[curr][visited];
    }
}
