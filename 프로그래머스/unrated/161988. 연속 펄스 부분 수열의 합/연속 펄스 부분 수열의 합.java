class Solution {
    public long solution(int[] sequence) {
        long[] dp = new long[sequence.length];

        long answer = 0;
        for (int i = -1; i <= 1; i = i + 2) {
            dp[0] = sequence[0] * i;
            answer = Math.max(dp[0], answer);

            for (int j = 1; j < sequence.length; j++) {
                int current = sequence[j] * i;

                if (j % 2 != 0)
                    current *= -1;

                dp[j] = Math.max(dp[j - 1] + current, current);
                answer = Math.max(dp[j], answer);
            }
        }

        return answer;
    }
}