package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1912

public class Dp17 {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Dp17 dp = new Dp17();
        System.out.println(dp.solution(arr));
    }

    private int solution(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        int answer = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        return answer;
    }
}
