package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11066

public class Dp14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Dp14 dp = new Dp14();

        StringTokenizer st;
        int K;
        int[] arr;
        for (int i = 0; i < N; i++) {
            K = Integer.parseInt(br.readLine());
            arr = new int[K];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(dp.solution(K, arr));
        }
    }

    private int solution(int K, int[] arr) {
        int[][] dp = new int[K + 1][K + 1];

        int[] sum = new int[K + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1] + arr[i - 1];
        }

        for (int j = 2; j <= K; j++) {
            for (int i = j - 1; i > 0; i--) {
                dp[i][j] = (int) 2e9;
                for (int z = i; z < j; z++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][z] + dp[z + 1][j]);
                }

                dp[i][j] += sum[j] - sum[i - 1];
            }
        }

        return dp[1][K];
    }
}
