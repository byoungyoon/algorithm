package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2293

public class Dp3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Dp3 dp = new Dp3();
        System.out.println(dp.solution(arr, k));
    }

    private int solution(int[] arr, int k) {
        Arrays.sort(arr);

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= arr[i]) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }

        return dp[k];
    }
}
