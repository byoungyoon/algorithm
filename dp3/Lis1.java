package dp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2631

public class Lis1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Lis1 test = new Lis1();
        System.out.println(test.solution(N, nums));
    }

    static Integer[] dp;

    private int solution(int N, int[] nums) {
        dp = new Integer[N];

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer = Math.max(answer, lis(nums, i));
        }

        return N - answer;
    }

    private int lis(int[] nums, int index) {
        if (dp[index] == null) {
            dp[index] = 1;

            for (int i = index + 1; i < nums.length; i++) {
                if (nums[index] < nums[i]) {
                    dp[index] = Math.max(dp[index], lis(nums, i) + 1);
                }
            }
        }

        return dp[index];
    }
}
