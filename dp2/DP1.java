package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9251

public class DP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        DP1 dp = new DP1();
        System.out.println(dp.solution(str1, str2));
    }

    static Integer[][] dp;
    static char[] arr1;
    static char[] arr2;

    private int solution(String str1, String str2) {
        dp = new Integer[str1.length()][str2.length()];
        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();

        return lcs(str1.length() - 1, str2.length() - 1);
    }

    private int lcs(int y, int x) {
        if (y == -1 || x == -1) {
            return 0;
        }
        if (dp[y][x] == null) {
            dp[y][x] = 0;

            if (arr1[y] == arr2[x]) {
                dp[y][x] = lcs(y - 1, x - 1) + 1;
            } else {
                dp[y][x] = Math.max(lcs(y - 1, x), lcs(y, x - 1));
            }
        }

        return dp[y][x];
    }
}
