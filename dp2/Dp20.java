package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9252

public class Dp20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        Dp20 dp = new Dp20();
        dp.setDp(str1, str2);

        System.out.println(dp.getNum(str1, str2));
        System.out.println(dp.getStr(str1, str2));
    }

    static int[][] dp;

    public void setDp(String str1, String str2) {
        dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public int getNum(String str1, String str2) {
        return dp[str1.length()][str2.length()];
    }

    public String getStr(String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        int y = str1.length();
        int x = str2.length();
        while (y != 0 && x != 0) {
            if (str1.charAt(y - 1) == str2.charAt(x - 1)) {
                sb.insert(0, str1.charAt(y - 1));
                y = y - 1;
                x = x - 1;
            } else {
                if (dp[y - 1][x] > dp[y][x - 1]) {
                    y = y - 1;
                } else {
                    x = x - 1;
                }
            }
        }

        return sb.toString();
    }
}
