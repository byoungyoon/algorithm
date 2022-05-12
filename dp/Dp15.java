package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11052

public class Dp15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Dp15 test = new Dp15();
        System.out.println(test.solution(cards));
    }

    private int solution(int[] cards) {
        int[] dp = new int[cards.length + 1];

        for (int i = 1; i <= cards.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cards[j - 1]);
            }
        }

        return cards.length;
    }
}
