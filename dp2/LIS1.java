package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2565

public class LIS1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] wires = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < wires.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        LIS1 test = new LIS1();
        System.out.println(test.solution(wires));
    }

    static Integer[] dp;

    private int solution(int[][] wires) {
        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        dp = new Integer[wires.length];

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, lis(wires, i));
        }

        return wires.length - max;
    }

    private int lis(int[][] wires, int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n + 1; i < wires.length; i++) {
                if (wires[n][1] < wires[i][1]) {
                    dp[n] = Math.max(dp[n], lis(wires, i) + 1);
                }
            }

        }

        return dp[n];
    }
}
