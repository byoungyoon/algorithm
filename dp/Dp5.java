package dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2579

public class Dp5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        Dp5 test = new Dp5();
        System.out.println(test.solution(n, nums));

        sc.close();
    }

    private int solution(int n, int[] nums) {
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (nums.length < 2)
            return dp[0];
        dp[1] = nums[0] + nums[1];
        if (nums.length < 3)
            return dp[1];
        dp[2] = Math.max(nums[1], nums[0]) + nums[2];
        if (nums.length < 4)
            return dp[2];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 3] + nums[i - 1], dp[i - 2]) + nums[i];
        }

        return dp[n - 1];
    }
}
