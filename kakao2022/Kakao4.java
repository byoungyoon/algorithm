package kakao2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/118669

public class Kakao4 {
    public static void main(String[] args) {
        int n = 7;
        int[][] paths = { { 1, 2, 5 }, { 1, 4, 1 }, { 2, 3, 1 }, { 2, 6, 7 }, { 4, 5, 1 }, { 5, 6, 1 }, { 6, 7, 1 } };
        int[] gates = { 3, 7 };
        int[] summits = { 1, 5 };

        Kakao4 test = new Kakao4();
        System.out.println(Arrays.toString(test.solution(n, paths, gates, summits)));
    }

    static int INF = (int) 2e9;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<int[]>> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);

        int[] check = new int[n + 1];
        for (int gate : gates) {
            check[gate] = 1;

            dp[gate] = 0;
            q.offer(gate);
        }

        for (int summit : summits) {
            check[summit] = 2;
        }

        for (int[] path : paths) {
            if (check[path[0]] != 2 && check[path[1]] != 1)
                hm.computeIfAbsent(path[0], data -> new ArrayList<>()).add(new int[] { path[1], path[2] });

            if (check[path[1]] != 2 && check[path[0]] != 1)
                hm.computeIfAbsent(path[1], data -> new ArrayList<>()).add(new int[] { path[0], path[2] });
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (!hm.containsKey(curr))
                continue;

            for (int[] target : hm.get(curr)) {
                if (Math.max(dp[curr], target[1]) < dp[target[0]]) {
                    dp[target[0]] = Math.max(dp[curr], target[1]);
                    q.add(target[0]);
                }
            }
        }

        int top = INF;
        int intensity = INF;
        for (int summit : summits) {
            if (dp[summit] < intensity) {
                intensity = dp[summit];
                top = summit;
            } else if (dp[summit] == intensity) {
                top = Math.min(top, summit);
            }
        }

        return new int[] { top, intensity };
    }
}
