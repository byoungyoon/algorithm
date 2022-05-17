package dp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1005

public class Dp10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Dp10 dp = new Dp10();

        int[] values;
        int[][] direction;
        int goal;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            values = new int[N];
            for (int j = 0; j < N; j++) {
                values[j] = Integer.parseInt(st.nextToken());
            }

            direction = new int[K][2];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                direction[j][0] = Integer.parseInt(st.nextToken());
                direction[j][1] = Integer.parseInt(st.nextToken());
            }

            goal = Integer.parseInt(br.readLine());

            System.out.println(dp.solution(values, direction, goal));
        }
    }

    static Map<Integer, Queue<Integer>> hm;
    static int[] dp;

    private int solution(int[] values, int[][] direction, int goal) {
        hm = new HashMap<>();
        dp = new int[values.length + 1];

        for (int[] dir : direction) {
            hm.computeIfAbsent(dir[1], data -> new LinkedList<>()).add(dir[0]);
        }

        int test = graph(goal, values);

        return test;
    }

    private int graph(int index, int[] values) {
        if (!hm.containsKey(index)) {
            return values[index - 1];
        }

        Queue<Integer> q = hm.get(index);
        while (!q.isEmpty()) {
            dp[index] = Math.max(dp[index], graph(q.poll(), values) + values[index - 1]);
        }

        return dp[index];
    }
}
