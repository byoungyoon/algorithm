package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1965

public class Dp21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] boxs = new int[N];
        for (int i = 0; i < N; i++) {
            boxs[i] = Integer.parseInt(st.nextToken());
        }

        Dp21 dp = new Dp21();
        System.out.println(dp.solution(N, boxs));
    }

    private int solution(int N, int[] boxs) {
        int[] dp = new int[1001];
        for (int box : boxs) {
            dp[box] = 1;

            for (int i = box - 1; i >= 1; i--) {
                if (dp[box] != 0) {
                    dp[box] = Math.max(dp[box], dp[i] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }
}
