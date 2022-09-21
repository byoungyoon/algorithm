package rescue2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945

public class Rescue9 {
    public static void main(String[] args) {
        int n = 5;

        Rescue9 test = new Rescue9();
        System.out.println(test.solution(n));
    }

    public int solution(int n) {
        int[] dp = new int[100001];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
