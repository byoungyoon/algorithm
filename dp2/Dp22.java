package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2011

public class Dp22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Dp22 test = new Dp22();
        System.out.println(test.solution(str));
    }

    private int solution(String str) {
        if (str.charAt(0) == '0') // 맨 앞자리 0이면 return 0
            return 0;

        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int value = Integer.parseInt(str.substring(i - 2, i));

            if (value == 0) // 00, 000 처럼 0이 연속 적인 경우 return 0
                return 0;
            if (str.charAt(i - 1) == '0') { // 숫자 2개로 짜를 때 일의 자리 숫자가 0일 경우 26이상이면 return 0
                if (Integer.parseInt(str.substring(i - 2, i)) > 26)
                    return 0;
                dp[i - 1] = dp[i - 2];
                dp[i] = dp[i - 2];
            } else {
                if (value > 26 || value < 10) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                }
            }
        }

        return dp[str.length()];
    }
}
